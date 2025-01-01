package com.tech.im.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tech.im.dto.ImPostListDto;

@Mapper
public interface ImPostMapper {

	//게시글 작성 db에 insert
	void writePost(String category, String title, String content, String userCode);
	//내가 쓴 글 리스트
	List<ImPostListDto> myPostList(String userCode, int offset, int limit);
	//내가 쓴 글 갯수
	int countMyPostList(String userCode);

	
	
}
