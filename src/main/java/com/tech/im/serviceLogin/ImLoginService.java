package com.tech.im.serviceLogin;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.tech.im.domain.ImUser;
import com.tech.im.repository.ImUserRepository;
import com.tech.im.security.Encoder;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImLoginService {

	private final ImUserRepository imUserRepository;
	
	//로그인과정
	public String login(String username, String password,HttpSession session) {
		/* 접속하려는 아이디로 db조회 */
		Optional<ImUser> user = imUserRepository.findByUserId(username);
		
		/* db에 없으면 error=id 전달 */
		if (user.isEmpty()) {
			return "redirect:/?error=id";
		}
		
		// 아이디가 있다면 비밀번호 조회 후 불일치일 경우 error=pw 전달
		if (!Encoder.matchPassword(password, user.get().getUserPassword())) {
			return "redirect:/?error=pw";
		}
		
		// 다 맞으면 세션에 유저코드, 유저닉네임 담기 (+http 30분간 아무 요청없을시 세션자동삭제)
		session.setAttribute("userCode", user.get().getUserCode());
		session.setAttribute("userNickname", user.get().getUserNickname());
		session.setMaxInactiveInterval(60 * 30);

		return "redirect:/";
	}
	
	//로그아웃 _ 세션 내 모든내용 지우기
	public String logout(HttpSession session) {
		/* 세션전체삭제 */
		session.invalidate();
		
		return "redirect:/";
	}
	
	
}
