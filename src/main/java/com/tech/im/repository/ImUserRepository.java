package com.tech.im.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tech.im.domain.ImUser;

public interface ImUserRepository extends JpaRepository<ImUser, String>{

	boolean existsByUserId(String userId);

	boolean existsByUserNickname(String userNickName);

	boolean existsByUserEmail(String userEmail);

	
}
