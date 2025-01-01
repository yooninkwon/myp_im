package com.tech.im.serviceLogin;

import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.tech.im.repository.ImUserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImSignUpCheckService {

	private final ImUserRepository imUserRepository;
	private final ImSignUpEmailService imSignUpEmailService;
	private final StringRedisTemplate stringRedisTemplate;
	
	//아이디 중복확인
	public boolean checkId(String userId) {
		//영문 대소문자와 숫자설정
		Pattern pattern = Pattern.compile("^[a-zA-Z0-9]+$");
		
		//영문 대소문자와 숫자 검증 후 부적합이면 true 반환
		if(!pattern.matcher(userId).matches()) {
			return true;
		}
		
		//정규식 검사 ok시에 길이 확인
		if (userId.length() < 5 || userId.length() > 50) {
			return true;
		}
		
		//이미 존재하는 아이디면 true 반환
		if (imUserRepository.existsByUserId(userId)) {
			return true;
			
		}else {
		//존재하지 않으면 redis에 저장 및 false 반환
			stringRedisTemplate.opsForValue().set("signUp"+userId, userId, 15,TimeUnit.MINUTES);
			return false;
		}
	}

	//닉네임 중복확인
	public boolean checkNickName(String userNickName) {
		
		Pattern pattern = Pattern.compile("^[a-zA-Z0-9가-힣]+$");
		
		//영문 대소문자, 한글, 숫자 검증 후 부적합이면 true로 응답
		if(!pattern.matcher(userNickName).matches()) {
			return true;
		}
		
		//1글자 이상이 아닐 시 true 반환
		if (userNickName.length()<1) {
			return true;
		}
		
		//이미 존재하는 아이디면 true 반환
		if (imUserRepository.existsByUserNickname(userNickName)) {
			return true;
		}else {
			//존재하지 않으면 redis에 저장 및 false 반환
			stringRedisTemplate.opsForValue().set("signUp"+userNickName, userNickName, 15,TimeUnit.MINUTES);
			return false;
		}
	}

	//이메일 중복인지 확인 후 _ 중복이 아닐 시 인증번호 발송
	public boolean checkEmail(String userEmail) {
		
		Pattern pattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
		
		//이메일 검증 후 부적합이면 true로 응답
		if(!pattern.matcher(userEmail).matches()) {
			return true;
		}
		
		if(imUserRepository.existsByUserEmail(userEmail)) {
			return true;
		}else {
			stringRedisTemplate.opsForValue().set("signUp"+userEmail, userEmail, 15,TimeUnit.MINUTES);
			imSignUpEmailService.sendEmail(userEmail);
			return false;
		}
	
	}

	//인증번호 입력시 맞는지 확인
	public String checkNumber(String eMail, String userNumber) {
		
		String pass = (String) stringRedisTemplate.opsForValue().get("check"+eMail);
		
		if (pass == null) {
			return "no";
		}else if(pass.equals(userNumber)) {
			stringRedisTemplate.opsForValue().set("signUpNumber"+eMail, "good", 15,TimeUnit.MINUTES);
			return "good";
		}else{
			return "ng";
		}
		
	}
	
	
	
	
	
	
}
