package com.tech.im.serviceLogin;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.tech.im.repository.ImUserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImSignUpCheckService {

	private final ImUserRepository imUserRepository;
	private final ImSignUpEmailService imSignUpEmailService;
	private final HttpSession session;
	
	public boolean checkId(String userId) {
		
		return imUserRepository.existsByUserId(userId);
	}

	public boolean checkNickName(String userNickName) {
		
		return imUserRepository.existsByUserNickname(userNickName);
	}

	public boolean checkEmail(String userEmail) {
		if(imUserRepository.existsByUserEmail(userEmail) == true) {
			return true;
		}else {
			imSignUpEmailService.sendEmail(userEmail);
			return false;
		}
	
	}

	public String checkNumber(String eMail, String userNumber) {
		
		String pass = (String) session.getAttribute(eMail);
		
		if (pass == null) {
			return "no";
		}else if(pass.equals(userNumber)) {
			return "good";
		}else{
			return "ng";
		}
		
	}
	
	
	
	
	
	
}
