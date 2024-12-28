package com.tech.im.controllerPost;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ImPostController {

	//글 작성 페이지로 가기
	@GetMapping("/writePost")
	public String writePost() {
		return "post/writePost";
	}
	
	//내가 쓴 글 보기
	@GetMapping("/myPost")
	public String myPost() {
		return "post/myPost";
	}
	
	//작성한 글 등록하기
	@PostMapping("/writePost/save")
	public String writePostSave(HttpSession session,
			@RequestParam String category, @RequestParam String title,
			@RequestParam String content){
		
		System.out.println(category+" "+title+" "+content);
		
		return "post/myPost";
	}
	
}
