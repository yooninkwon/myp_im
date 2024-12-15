package com.tech.im.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ImController {
	
	@RequestMapping("/")
	public String index() {
		
		return "index";
	}
	@RequestMapping("/who")
	public String who() {
		
		return "who";
	}
	@RequestMapping("/life")
	public String life() {
		
		return "life";
	}
	@RequestMapping("/worry")
	public String worry() {
		
		return "worry";
	}
	@RequestMapping("/secret")
	public String secret() {
		
		return "secret";
	}
	@RequestMapping("/free")
	public String free() {
		
		return "free";
	}
	@RequestMapping("/myPage")
	public String myPage() {
		
		return "myPage";
	}
}
