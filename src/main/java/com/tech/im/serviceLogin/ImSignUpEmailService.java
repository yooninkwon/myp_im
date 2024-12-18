package com.tech.im.serviceLogin;

import java.util.Random;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImSignUpEmailService {
	
	private final JavaMailSender javaMailSender;
	
	public void sendEmail(String userEmail) {
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(userEmail);
		message.setSubject("Im 회워가입 인증번호");
		message.setText("인증번호 : "+verification());
		javaMailSender.send(message);
		
	}

	//인증번호 만들기
	public String verification() {
		String passSet = "ABCDEFGHIJKLMNOPQRSUVWXYZ0123456789";
		Random random = new Random();
		String pass="";
		for (int i = 0; i < 8; i++) {
			int randomIndex = random.nextInt(passSet.length());
			pass+=passSet.charAt(randomIndex);
		}
		
		return pass;
	}
}
