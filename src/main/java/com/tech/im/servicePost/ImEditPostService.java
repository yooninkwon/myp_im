package com.tech.im.servicePost;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.tech.im.mapper.ImPostMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImEditPostService {

	private final ImPostMapper imPostMapper;

	public void goEditPostPage(Model model, int postNo, String postCategory, String postTitle, String postContent) {
		
        model.addAttribute("postNo", postNo);
        model.addAttribute("postCategory", postCategory);
        model.addAttribute("postTitle", postTitle);
        model.addAttribute("postContent", postContent);
		
	}

	public String editPostWrite(HttpSession session, int postNo, String postTitle, String postContent) {
		
		//게시글 작성자의 유저코드 가져오기
		String postUserCode = imPostMapper.postUserCode(postNo);
		//만약 게시글 작성자의 유저코드와 현재 로그인된 유저코드가 맞지 않으면 리턴
		if (!postUserCode.equals(session.getAttribute("userCode"))) {
			return "ng";
		}else {
			//게시글 작성자의 유저코드와 현재 로그인된 유저코드가 맞으면 게시글 수정
			imPostMapper.editPostWrite(postNo, postTitle, postContent);
			return "good";
		}
	}
	
	
	

		
		
	
	
	
	

	
	
}
