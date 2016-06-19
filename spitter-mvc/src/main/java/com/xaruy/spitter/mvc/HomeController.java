package com.xaruy.spitter.mvc;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xaruy.spitter.service.SpitterService;

@Controller
public class HomeController {
	
	public static final int DEFAULT_SPITTLES_PER_PAGE = 1;
	
	private SpitterService spitterService;
	
	@Autowired
	public HomeController(SpitterService spitterService) {
		this.spitterService = spitterService;
	}
	
	@RequestMapping({"/", "/home"}) //处理 ‘/’或者‘/home’路径的请求
	public String showHomePage(Map<String, Object> model) {
		model.put("spittles", spitterService.getRecentSpittles(DEFAULT_SPITTLES_PER_PAGE));
		
		//返回视图名
		return "home";
	}

}
