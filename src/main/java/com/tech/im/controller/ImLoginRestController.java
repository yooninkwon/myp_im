package com.tech.im.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tech.im.service.ImSignUpCheckService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ImLoginRestController {
	
	private final ImSignUpCheckService imSignUpCheckService;
	
	
	@GetMapping("/signUp/checkId")
	public boolean checkId(@RequestParam String userId) {
		
		
		System.out.println(imSignUpCheckService.checkId(userId));
		
		return false;
	}
	
}
