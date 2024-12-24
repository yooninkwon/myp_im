package com.tech.im.serviceLogin;

import java.util.Optional;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.tech.im.domain.ImUser;
import com.tech.im.repository.ImUserRepository;
import com.tech.im.security.Encoder;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImFindIdCheckService {

	private final ImUserRepository imUserRepository;
	private final ImSignUpEmailService imSignUpEmailService;
	private final StringRedisTemplate stringRedisTemplate;
	
	//이메일 중복인지 확인 후 _ 중복이면 인증번호 발송
	public boolean checkEmail(String userEmail) {
		if(imUserRepository.existsByUserEmail(userEmail) == false) {
			return false;
		}else {
			imSignUpEmailService.sendEmail(userEmail);
			return true;
		}
	
	}

	//인증번호 입력시 맞는지 확인
	public String checkNumber(String eMail, String userNumber) {
		
		String pass = (String) stringRedisTemplate.opsForValue().get(eMail);
		
		
		if (pass == null) {
			return "no";
			
		//인증번호 확인 시 해당 이메일로 등록된 아이디 가져오기	
		}else if(pass.equals(userNumber)) {
			//인증된 메일로 아이디찾기
			Optional<ImUser> user = imUserRepository.findByUserEmail(eMail);
			return user.get().getUserId();
		}else{
			return "ng";
		}
		
	}
	
	//비밀번호 재설정
	public void changePassword(String id, String newPassword) {
		String encodeNewPassword = Encoder.encode(newPassword);
		
		ImUser updateUser = imUserRepository.findByUserId(id);
		
		updateUser.changePassword(encodeNewPassword);
		
		imUserRepository.save(updateUser);
		
		
	}
	
	
	
	
	
	
}
