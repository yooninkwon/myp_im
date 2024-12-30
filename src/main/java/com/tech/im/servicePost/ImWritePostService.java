package com.tech.im.servicePost;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.tech.im.mapper.ImPostMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImWritePostService {

	private final ImPostMapper imPostMapper;
	
	public String writePostSave(HttpSession session, String category, String title, String content) {
		//만약 제목 길이가 100 초과면 리턴
		if(title.length()>100) {
			return "redirect:/writePost";
		}
		//만약 카테고리가 이상한 카테고리면 리턴
		if(!category.equals("누구야") && !category.equals("이렇게 살아왔어") && !category.equals("고민이 있어") && 
				!category.equals("숨겨둔 비밀") && !category.equals("자유게시판")) {
			return "redirect:/writePost";
		}
		//만약 로그인 상태가 아니라면
		if(session.getAttribute("userCode")==null) {
			return "redirect:/writePost";
		}
		
		imPostMapper.writePost(category, title, content, (String)session.getAttribute("userCode"));
		
		return "redirect:/myPost";
		
	}
	

	
	
}
