package com.tech.im.controllerPost;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tech.im.servicePost.ImDetailPostService;
import com.tech.im.servicePost.ImEditPostService;
import com.tech.im.servicePost.ImMyPostListService;
import com.tech.im.servicePost.ImWritePostService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ImPostController {

	private final ImWritePostService imWritePostService;
	private final ImMyPostListService imMyPostListService;
	private final ImDetailPostService imDetailPostService;
	private final ImEditPostService imEditPostService; 
	
	//글 작성 페이지로 가기
	@GetMapping("/writePost")
	public String writePost() {
		return "post/writePost";
	}
	
	//내가 쓴 글 리스트 보기
	@GetMapping("/myPost")
	public String myPost(HttpSession session, Model model, @RequestParam(defaultValue = "1") int page) {
		
		imMyPostListService.myPostList(session, model, page);
		
		return "post/myPost";
	}
	
	//작성한 글 등록하기
	@PostMapping("/writePost/save")
	public String writePostSave(HttpSession session,
			@RequestParam String category, @RequestParam String title,
			@RequestParam String content){
		return imWritePostService.writePostSave(session, category, title, content);
	}
	
	//게시글 상세보기
	@GetMapping("/detailPost")
	public String detailPost(Model model, @RequestParam int postNo) {
		
		imDetailPostService.detailPost(model, postNo);
		
		return "post/detailPost";
	}
	
	//게시글 수점 폼으로 이동
	@PostMapping("/editPost")
	public String editPost(Model model, @RequestParam int postNo, @RequestParam String postCategory,
            @RequestParam String postTitle, @RequestParam String postContent) {
		
		imEditPostService.goEditPostPage(model, postNo, postCategory, postTitle, postContent);
		
		return "post/editPost";
		
	}
	
}
