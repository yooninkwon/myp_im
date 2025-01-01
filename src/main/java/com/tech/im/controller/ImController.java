package com.tech.im.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tech.im.servicePost.ImCategoryPostListService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ImController {
	
	private final ImCategoryPostListService imCategoryPostListService;
	
	//메인페이지
	@GetMapping("/")
	public String index() {
		
		return "index";
	}
	
	//카테고리별 게시글 리스트 페이지
	@GetMapping("/post")
	public String who(Model model, @RequestParam String category, @RequestParam(defaultValue = "1") int page) {
		
		imCategoryPostListService.PostList(model, category, page);
		
		return "post";
	}
	
}
