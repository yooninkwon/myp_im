package com.tech.im.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ImLoginController {
	
//	회원가입 창으로 이동
	@RequestMapping("/login/signUp")
	public String signUp() {
		
		return "login/signUp";
	}
}
