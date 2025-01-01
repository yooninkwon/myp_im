package com.tech.im.servicePost;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.tech.im.mapper.ImPostMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImDeletePostService {

	private final ImPostMapper imPostMapper;

	public String deletePost(int postNo, HttpSession session) {
		//게시글 작성자의 유저코드 가져오기
		String postUserCode = imPostMapper.postUserCode(postNo);
		//만약 게시글 작성자의 유저코드와 현재 로그인된 유저코드가 맞지 않으면 리턴
		if (!postUserCode.equals(session.getAttribute("userCode"))) {
			return "ng";
		}else {
			//게시글 작성자의 유저코드와 현재 로그인된 유저코드가 맞으면 게시글 삭제
			imPostMapper.deletePost(postNo);
			return "good";
		}
		
		
	}
	
	
	

	
	
}
