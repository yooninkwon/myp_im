package com.tech.im.serviceLogin;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.tech.im.domain.ImUser;
import com.tech.im.repository.ImUserRepository;
import com.tech.im.security.Encoder;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ImSignUpFormService {

	private final ImUserRepository imUserRepository;
	
	//회원가입
	public void signUp(String id, String passWord, String nickName, String eMail) {
		//비밀번호, 이메일 단방향 암호화
		String encodePassword = Encoder.encode(passWord);
		
		//유저정보 객체주입 _ 멤버코드는 UUID사용
		ImUser user = new ImUser(); 
		user.createUser(UUID.randomUUID().toString(), id, encodePassword, nickName, eMail);
		
		//db에 insert
		imUserRepository.save(user);
		
	}

}
