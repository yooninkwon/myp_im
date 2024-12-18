package com.tech.im.serviceLogin;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImSignUpEmailService {
	
	private final JavaMailSender javaMailSender;
	private final HttpSession session;
	
	public void sendEmail(String userEmail) {
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(userEmail);
		message.setSubject("Im 회원가입 인증번호");
		message.setText("인증번호 : "+verification(userEmail));
		javaMailSender.send(message);
		
	}

	//인증번호 만들기
	public String verification(String userEmail) {
		String passSet = "ABCDEFGHIJKLMNOPQRSUVWXYZ0123456789";
		Random random = new Random();
		String pass="";
		for (int i = 0; i < 8; i++) {
			int randomIndex = random.nextInt(passSet.length());
			pass+=passSet.charAt(randomIndex);
		}
		 // 세션에 현재 이메일로 저장된 값이 있으면 삭제 _ 인증버튼 중복으로 누를때를 예방하기위함
	    if (session.getAttribute(userEmail) != null) {
	        session.removeAttribute(userEmail);  // 기존 인증번호 삭제
	    }
		session.setAttribute(userEmail, pass);
		
		return pass;
	}
}
