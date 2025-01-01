package com.tech.im.servicePost;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.tech.im.dto.ImDetailPostDto;
import com.tech.im.mapper.ImPostMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImDetailPostService {

	private final ImPostMapper imPostMapper;
	
	public void detailPost(Model model, int postNo) {
		//게시글 상세정보 불러오기
		ImDetailPostDto detailPost = imPostMapper.detailPost(postNo);
		
		model.addAttribute("detailPost",detailPost);
		
	}

	
	
}
