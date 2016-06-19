package com.xaruy.spitter.mvc;

import java.io.File;
import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.xaruy.spitter.common.ImageUploadException;
import com.xaruy.spitter.dao.Spitter;
import com.xaruy.spitter.service.SpitterService;

@Controller
@RequestMapping("/spitter")
public class SpitterController {
	
	private final SpitterService spitterService;
	
	@Inject
	public SpitterController(SpitterService spitterService) {
		this.spitterService = spitterService;
	}
	
	@RequestMapping(value="/spittles", method=RequestMethod.GET)
	public String listSpittlesForSpitter(@RequestParam("spitter") String username, Model model) {
		Spitter spitter = spitterService.getSpitter(username);
		model.addAttribute(spitter);
		model.addAttribute(spitterService.getSpittlesForSpitter(username));
		return "spittles/list";
	}
	
	@RequestMapping(method=RequestMethod.GET, params="new")
	public String createSpitterProfile(Model model) {
		model.addAttribute(new Spitter());
		return "spitters/edit";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String addSpitterFromForm(@Valid Spitter spitter, BindingResult bindingResult,
			@RequestParam(value="image", required=false) MultipartFile image, HttpSession session) {
		if(bindingResult.hasErrors()) {
			return "spitters/edit";
		}
		spitterService.saveSpitter(spitter);
		
		String webRootPath = session.getServletContext().getRealPath(File.separator);
        String imageStorePath = webRootPath + "/resources/";
		
		try {
			if(!image.isEmpty()) {
				validateImage(image);
				
				saveImage(imageStorePath + spitter.getId() + ".jpg", image);
			} 
		} catch (ImageUploadException e) {
			bindingResult.reject(e.getMessage());
			return "spitters/edit";
		}
		return "redirect:/spitters/" + spitter.getUsername();
	}
	
	@RequestMapping(value="/{username}", method=RequestMethod.GET)
	public String showSpitterProfile(@PathVariable String username, Model model) {
		model.addAttribute(spitterService.getSpitter(username));
		return "spitters/view";
	}
	
	private void validateImage(MultipartFile image) {
		if(!image.getContentType().equals("image/jpeg")) {
			throw new ImageUploadException("Only JPG images accepted");
		}
	}
	
	private void saveImage(String path, MultipartFile image) throws ImageUploadException {
		try {
			File file = new File(path);
			FileUtils.writeByteArrayToFile(file, image.getBytes());
		} catch (IOException e) {
			throw new ImageUploadException("Unable to save image", e);
		}
	}

}
