package com.tech.im.serviceLogin;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImSignUpEmailService {
	
	private final JavaMailSender javaMailSender;
	private final StringRedisTemplate stringRedisTemplate;
	
	//이메일 발송
	@Async
	public void sendEmail(String userEmail) {
		//이메일 보낼 설정
		SimpleMailMessage message = new SimpleMailMessage();
		//to 누구에게 보낼지 _ 이메일주소
		message.setTo(userEmail);
		//이메일 제목
		message.setSubject("Im 회원가입 인증번호");
		//이메일 내용 _ 인증번호 생서 메소드 리턴값
		message.setText("인증번호 : "+verification(userEmail));
		//이메일 보내기
		javaMailSender.send(message);
		
	}

	//인증번호 만들기 + Redis 5분 유효로 값 저장
	public String verification(String userEmail) {
		String passSet = "ABCDEFGHIJKLMNOPQRSUVWXYZ0123456789";
		Random random = new Random();
		String pass="";
		for (int i = 0; i < 8; i++) {
			int randomIndex = random.nextInt(passSet.length());
			pass+=passSet.charAt(randomIndex);
		}
		 // 레디스에 현재 이메일로 저장된 값이 있으면 삭제 _ 인증버튼 중복으로 누를때를 예방하기위함
        stringRedisTemplate.delete("check"+userEmail);// 기존 인증번호 삭제

        // 레디스에 현재 이메일 키값으로 인증번호 저장 _ 타임은 1분
	    stringRedisTemplate.opsForValue().set("check"+userEmail, pass, 5, TimeUnit.MINUTES);
		
		
		return pass;
	}
	
	
	
	
}
