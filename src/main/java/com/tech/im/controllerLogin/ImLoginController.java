package com.tech.im.controllerLogin;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tech.im.serviceLogin.ImLoginService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ImLoginController {
	
	private final ImLoginService imLoginService;
	
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
	//로그인하기 _ 아이디 및 비밀번호 조회
	@PostMapping("/login")
	public String login(HttpSession session,@RequestParam String username, @RequestParam String password) {
		return imLoginService.login(username, password, session);
	}
	//로그아웃하기
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		return imLoginService.logout(session);
	}
}
