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
	
	@RequestMapping({"/", "/home"}) //���� ��/�����ߡ�/home��·��������
	public String showHomePage(Map<String, Object> model) {
		model.put("spittles", spitterService.getRecentSpittles(DEFAULT_SPITTLES_PER_PAGE));
		
		//������ͼ��
		return "home";
	}

}
