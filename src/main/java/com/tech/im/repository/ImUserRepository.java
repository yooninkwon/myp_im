package com.tech.im.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tech.im.domain.ImUser;

public interface ImUserRepository extends JpaRepository<ImUser, String>{

	//아이디 중복확인 
	boolean existsByUserId(String userId);
	//닉네임 중복확인
	boolean existsByUserNickname(String userNickName);
	//등록된 이메일 중복확인
	boolean existsByUserEmail(String userEmail);
	//아이디/비밀번호 찾기 시 이메일 인증완료가되면 해당 이메일을 포함한 유저 데이터 가져오기
	Optional<ImUser> findByUserEmail(String userEmail);
	//비밀번호 재설정하기 위한 유저 데이터 가져오기
	Optional<ImUser> findByUserId(String id);
	
}
