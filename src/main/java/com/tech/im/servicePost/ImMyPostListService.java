package com.tech.im.servicePost;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.tech.im.dto.ImPostListDto;
import com.tech.im.mapper.ImPostMapper;
import com.tech.im.vo.ImPostPageVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImMyPostListService {
	
	private final ImPostMapper imPostMapper;
	
	public void myPostList(HttpSession session, Model model, int page) {
		//로그인 된 유저의 유저코드 
		String userCode = (String) session.getAttribute("userCode");
		//페이지당 게시글 수 설정
		int postPerPage = 10;
		//전체 게시글 수 가져오기
		int totalPost= imPostMapper.countMyPostList(userCode);
		//페이징 데이터 가져오기
		ImPostPageVO pagination = new ImPostPageVO(page, totalPost, postPerPage);
		//현재 페이지에 해당하는 게시글 가져오기
		int offset = (page - 1) * postPerPage;
		List<ImPostListDto> myPostList = imPostMapper.myPostList(userCode, offset, postPerPage);
		//모델에 담아 뷰로 전달
		model.addAttribute("myPostList", myPostList);
		model.addAttribute("pagination", pagination);
		
	}

}
