package com.tech.im.servicePost;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.tech.im.domain.ImPost;
import com.tech.im.repository.ImPostRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImWritePostService {

	private final ImPostRepository imPostRepository;
	
	public String writePostSave(HttpSession session, String category, String title, String content) {
		//만약 제목 길이가 100 초과면 리턴
		if(title.length()>100) {
			return "redirect:/writePost";
		}
		//만약 카테고리가 이상한 카테고리면 리턴
		if(!category.equals("who") && !category.equals("life") && !category.equals("worry") && 
				!category.equals("secret") && !category.equals("free")) {
			return "redirect:/writePost";
		}
		
		ImPost post = new ImPost(); 
				
		post.writePost(category, title, content, (String)session.getAttribute("userCode"));
		
		imPostRepository.save(post);
		
		return "post/myPost";
		
	}

	
	
}
