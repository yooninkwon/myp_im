package com.tech.im.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tech.im.dto.ImDetailPostDto;
import com.tech.im.dto.ImPostListDto;

@Mapper
public interface ImPostMapper {

	//게시글 작성 db에 insert
	void writePost(String category, String title, String content, String userCode);
	//내가 쓴 글 갯수
	int countMyPostList(String userCode);
	//내가 쓴 글 리스트
	List<ImPostListDto> myPostList(String userCode, int offset, int limit);
	//카테고리에 맞는 총 게시글 갯수
	int countPostList(String changeCategory);
	//카테고리에 맞는 게시글 리스트 
	List<ImPostListDto> postList(String changeCategory, int offset, int limit);
	//고유코드에 맞는 게시글 상세정보 불러오기
	ImDetailPostDto detailPost(int postNo);
	//게시글에 등록된 유저코드 가져오기
	String postUserCode(int postNo);
	//게시글 삭제
	void deletePost(int postNo);
	//게시글 수정
	void editPostWrite(int postNo, String postTitle, String postContent);

	
	
}
