package com.tech.im.controllerLogin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tech.im.serviceLogin.ImSignUpCheckService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ImLoginRestController {
	
	private final ImSignUpCheckService imSignUpCheckService;
	
	//회원가입 아이디 중복확인 ajax
	@GetMapping("/signUp/checkId")
	public boolean checkId(@RequestParam String userId) {
		return imSignUpCheckService.checkId(userId);
	}
	
	//회원가입 닉네임 중복확인 ajax
	@GetMapping("/signUp/checkNickName")
	public boolean checkNickName(@RequestParam String userNickName) {
		return imSignUpCheckService.checkNickName(userNickName);
	}
	
	//회원가입 이메일 중복확인(+중복아닐시 인증번호 발송)
	@GetMapping("/signUp/checkEmail")
	public boolean checkEmail(@RequestParam String userEmail) {
		return imSignUpCheckService.checkEmail(userEmail);
	}
	
	//회원가입 인증번호 확인 ajax
	@PostMapping("/signUp/checkNumber")
	public String checkNumber(@RequestParam String eMail,
			@RequestParam String userNumber) {
		return imSignUpCheckService.checkNumber(eMail,userNumber);
	}
}
