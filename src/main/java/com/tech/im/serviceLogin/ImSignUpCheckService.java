package com.tech.im.serviceLogin;

import org.springframework.stereotype.Service;

import com.tech.im.repository.ImUserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImSignUpCheckService {

	private final ImUserRepository imUserRepository;
	private final ImSignUpEmailService imSignUpEmailService;
	
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
	
	
	
	
	
	
}
