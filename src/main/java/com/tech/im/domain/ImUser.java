package com.tech.im.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;

@Entity
@Table(name = "im_user")
@Getter
public class ImUser {
	
	// 유저 고유 코드번호
	@Id
	@Column(name = "user_code", length = 250)
	private String userCode;
	
	// 유저 아이디
	@Column(name = "user_id", length = 50)
	private String userId;
	
	// 유저 비밀번호
	@Column(name = "user_password", length = 255)
	private String userPassword;
	
	// 유저 닉네임
	@Column(name = "user_nickname", length = 50)
	private String userNickname;
	
	// 유저 등록된 이메일
	@Column(name = "user_email", length = 100)
	private String userEmail;
	
	// 유저 정보(ex 유저, 관리자)
	@Column(name = "user_role", length = 20)
	private String userRole;
	
	// 유저 상태(활성화, 비매너 등등 추후 업데이트 예정)
	@Column(name = "user_status", length = 20)
	private String userStatus;
	
	// 유저 아이디 생성날짜
	@Column(name = "user_created_at")
	private LocalDateTime userCreatedAt;
	
	//유저 회원가입
	public void createUser(String userCode, String id, String passWord, String nickName, String eMail) {
		this.userCode = userCode;
		this.userId = id;
		this.userPassword = passWord;
		this.userNickname = nickName;
		this.userEmail = eMail;
		this.userRole = "USER";
		this.userStatus = "ACTIVE";
		
	}
	
	//비밀번호 재설정
	public void changePassword(String changePassword) {
		this.userPassword = changePassword;
	}
	
}
