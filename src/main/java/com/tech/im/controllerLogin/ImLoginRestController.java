package com.tech.im.controllerLogin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tech.im.serviceLogin.ImFindIdCheckService;
import com.tech.im.serviceLogin.ImSignUpCheckService;
import com.tech.im.serviceLogin.ImSignUpFormService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ImLoginRestController {
	
	private final ImSignUpCheckService imSignUpCheckService;
	private final ImSignUpFormService imSignUpFormService;
	private final ImFindIdCheckService imFindIdCheckService;
	
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
	@PostMapping("/signUp/checkEmail")
	public boolean checkEmail(@RequestParam String userEmail) {
		return imSignUpCheckService.checkEmail(userEmail);
	}
	
	//회원가입 인증번호 확인 ajax
	@PostMapping("/signUp/checkNumber")
	public String checkNumber(@RequestParam String eMail,
			@RequestParam String userNumber) {
		return imSignUpCheckService.checkNumber(eMail,userNumber);
	}
	
	//회원가입 
	@PostMapping("/signUp/form")
	public String signUpForm(@RequestParam String id, @RequestParam String passWord,
			@RequestParam String nickName, @RequestParam String eMail) {
		
			imSignUpFormService.signUp(id,passWord, nickName, eMail);
		
		return "/";
	}
	
	//아이디/비밀번호 찾기 이메일 확인 + 인증번호 보내기
	@PostMapping("/findId/checkEmail")
	public boolean findIdCheckEmail(@RequestParam String userEmail) {
		return imFindIdCheckService.checkEmail(userEmail);
	}
	
	//아이디/비밀번호 찾기 인증번호 확인
	@PostMapping("/findId/checkNumber")
	public String findIdCheckNumber(@RequestParam String eMail,
			@RequestParam String userNumber) {
		return imFindIdCheckService.checkNumber(eMail, userNumber);
	}

	//아이디/비민번호 찾기 비밀번호 재설정
	@PostMapping("/findId/changePassword")
	public String findIdChangePassword(@RequestParam String id,
			@RequestParam String newPassword) {
		imFindIdCheckService.changePassword(id, newPassword);	
		
		return "/";
	}
	
}
