package com.tech.im.serviceLogin;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

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
			//이메일 검증 완료 후 비밀번호 재설정 시 서버에서 받은 아이디의 등록된 이메일인지 확인하기 위함 
			stringRedisTemplate.opsForValue().set("findId"+userEmail, userEmail, 10, TimeUnit.MINUTES);
			return true;
		}
	
	}

	//인증번호 입력시 맞는지 확인
	public String checkNumber(String eMail, String userNumber) {
		
		String pass = (String) stringRedisTemplate.opsForValue().get("check"+eMail);
		
		
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
		
		Optional<ImUser> updateUser = imUserRepository.findByUserId(id);
		
		//관리자도구를 통해 아이디값을 바꾸면 null이 되니 리턴
		//이메일 인증까지는 ok지만 아이디를 바꿔 데이터를 보냈을 때, 그 아이디와 이전에 인증받은 이메일의 일치여부 검증 
		if(updateUser.isEmpty() ||  
				!updateUser.get().getUserEmail().equals((String) stringRedisTemplate.opsForValue().get("findId"+updateUser.get().getUserEmail()))) {
			return;
		}
		
		updateUser.get().changePassword(encodeNewPassword);
		
		imUserRepository.save(updateUser.get());
		
		//정상적으로 비밀번호 변경 완료시 이전에 redis에 저장한 데이터는 삭제
		stringRedisTemplate.delete("findId" + updateUser.get().getUserEmail());
		
	}
	
	
	
	
	
	
}
