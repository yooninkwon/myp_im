package com.tech.im.serviceLogin;

import java.util.UUID;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.tech.im.domain.ImUser;
import com.tech.im.repository.ImUserRepository;
import com.tech.im.security.Encoder;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ImSignUpFormService {

	private final ImUserRepository imUserRepository;
	private final StringRedisTemplate stringRedisTemplate;
	
	//회원가입
	public String signUp(String id, String passWord, String nickName, String eMail) {
		
		//회원가입 시 ok(중복되지 않은 아이디,닉네임 등) 조건 검증된 redis 불러오기
		String checkId = stringRedisTemplate.opsForValue().get("signUp"+id);
		String checkNickName = stringRedisTemplate.opsForValue().get("signUp"+nickName);
		String checkEmail = stringRedisTemplate.opsForValue().get("signUp"+eMail);
		String checkNumber = stringRedisTemplate.opsForValue().get("signUpNumber"+eMail);
		
		
		// 인증번호를 완료하지 않거나, 틀린 인증번호 상태로 회원가입 데이터가 들어왔을 시 조건 검증
		if (checkNumber == null || !checkNumber.equals("good")) {
			return "/login/signUp";
		}
		
		//패스워드 빈칸 조건 검증
		if (passWord.isEmpty()) {
			return "/login/signUp";
		}
		
		//아이디 중복검사 때 했던 값과 비교
		if(!checkId.equals(id)) {
			return "/login/signUp";
		}
		
		//닉네임 중복검사 때 했던 값과 비교
		if(!checkNickName.equals(nickName)) {
			return "/login/signUp";
		}

		//이메일 중복검사 때 했던 값과 비교
		if(!checkEmail.equals(eMail)) {
			return "/login/signUp";
		}
		
		//비밀번호, 이메일 단방향 암호화
		String encodePassword = Encoder.encode(passWord);
		
		//유저정보 객체주입 _ 멤버코드는 UUID사용
		ImUser user = new ImUser(); 
		user.createUser(UUID.randomUUID().toString(), id, encodePassword, nickName, eMail);
		
		//db에 insert
		imUserRepository.save(user);
		
		//redis에 저장된 데이터 삭제
		stringRedisTemplate.delete("signUp"+id);
		stringRedisTemplate.delete("signUp"+nickName);
		stringRedisTemplate.delete("signUp"+eMail);
		stringRedisTemplate.delete("signUpNumber"+eMail);

		
		
		return "/";
	}

}
