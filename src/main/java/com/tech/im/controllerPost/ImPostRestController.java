package com.tech.im.controllerPost;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tech.im.servicePost.ImDeletePostService;
import com.tech.im.servicePost.ImEditPostService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ImPostRestController {

	private final ImDeletePostService imDeletePostService; 
	private final ImEditPostService imEditPostService;
	
	//게시글 삭제하기
	@DeleteMapping("/deletePost")
	public String deletePost(@RequestParam int postNo, HttpSession session) {
		return imDeletePostService.deletePost(postNo, session);
	}
	//게시글 수정하기
	@PatchMapping("/editPostWrite")
	public String editPostWrite(HttpSession session, @RequestParam int postNo, 
			@RequestParam String postTitle, @RequestParam String postContent) {
		return imEditPostService.editPostWrite(session, postNo, postTitle, postContent);
		
	}
	
	
	
}
