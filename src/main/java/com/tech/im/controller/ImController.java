package com.tech.im.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ImController {
	
	//메인페이지
	@RequestMapping("/")
	public String index() {
		
		return "index";
	}
	
	//누구야 페이지
	@RequestMapping("/who")
	public String who() {
		
		return "who";
	}
	
	//이렇게 살아왔어 페이지
	@RequestMapping("/life")
	public String life() {
		
		return "life";
	}
	
	//고민이 있어 페이지
	@RequestMapping("/worry")
	public String worry() {
		
		return "worry";
	}
	
	//말 못할 비밀 페이지
	@RequestMapping("/secret")
	public String secret() {
		
		return "secret";
	}
	
	//왁자지껄 _ 자유게시판 페이지
	@RequestMapping("/free")
	public String free() {
		
		return "free";
	}
	
	//마이페이지(내가 쓴글 보기)
	@RequestMapping("/myPage")
	public String myPage() {
		
		return "myPage";
	}
}
