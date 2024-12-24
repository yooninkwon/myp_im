package com.tech.im.controllerLogin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ImLoginController {
	
	//회원가입 창으로 이동
	@RequestMapping("/login/signUp")
	public String signUp() {
		
		return "login/signUp";
	}
	
	//아이디 비밀번호 찾기 창으로 이동
	@RequestMapping("/login/findId")
	public String findId() {
		return "login/findId";
	}
}
