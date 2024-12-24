package com.tech.im.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//암호화
public class Encoder{
	public static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	/* 비밀번호 암호화 */
	public static String encode(String raw) {
		
		return encoder.encode(raw);
	}
	
	/* 비밀번호 매치 확인 */
	public static boolean matchPassword(String raw, String encodeRaw) {
		return encoder.matches(raw, encodeRaw);	
	}
	
}
