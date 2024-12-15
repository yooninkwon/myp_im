package com.tech.im.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ImController {
	
	@RequestMapping("/")
	public String index() {
		
		return "index";
	}
}
