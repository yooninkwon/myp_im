package com.tech.im.servicePost;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.tech.im.dto.ImPostListDto;
import com.tech.im.mapper.ImPostMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImMyPostListService {
	
	private final ImPostMapper imPostMapper;
	
	public void myPostList(HttpSession session, Model model) {
		//로그인 된 유저의 유저코드 
		String userCode = (String) session.getAttribute("userCode");
		//내가 쓴 글 불러오기
		List<ImPostListDto> myPostList = imPostMapper.myPostList(userCode);
		//모델에 담아 뷰로 전달
		model.addAttribute("myPostList", myPostList);
		
	}

}
