package com.tech.im.service;

import org.springframework.stereotype.Service;

import com.tech.im.repository.ImUserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImSignUpCheckService {

	private final ImUserRepository imUserRepository;
	
	public boolean checkId(String userId) {
		
		return imUserRepository.existsByUserId(userId);
	}
	
}
