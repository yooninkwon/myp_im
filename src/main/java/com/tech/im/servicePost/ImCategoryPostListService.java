package com.tech.im.servicePost;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.tech.im.dto.ImPostListDto;
import com.tech.im.mapper.ImPostMapper;
import com.tech.im.vo.ImPostPageVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImCategoryPostListService {
	
	private final ImPostMapper imPostMapper;
	
	public void PostList(Model model, String category, int page) {

		//페이지당 게시글 수 설정
		int postPerPage = 10;

		// db 카테고리 형식으로 전환
		String changeCategory = categoryChange(category);
		
		//전체 게시글 수 가져오기
		int totalPost= imPostMapper.countPostList(changeCategory);
		//페이징 데이터 가져오기
		ImPostPageVO pagination = new ImPostPageVO(page, totalPost, postPerPage);
		
		//현재 페이지에 해당하는 게시글 가져오기
		int offset = (page - 1) * postPerPage;
		List<ImPostListDto> postList = imPostMapper.postList(changeCategory, offset, postPerPage);
		
		//모델에 담아 뷰로 전달
		model.addAttribute("postList", postList);
		model.addAttribute("pagination", pagination);
		model.addAttribute("category",category);
	}
	
	public String categoryChange(String category) {
		String rs = "";
		
		if(category.equals("who")) {
			rs = "누구야";
		}else if(category.equals("life")) {
			rs = "이렇게 살아왔어";
		}else if(category.equals("worry")) {
			rs = "고민이 있어";
		}else if(category.equals("secret")) {
			rs = "숨겨둔 비밀";
		}else if(category.equals("free")) {
			rs = "자유게시판";
		}
		
		return rs;
	}

}
