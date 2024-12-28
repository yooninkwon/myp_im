package com.tech.im.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;

@Entity
@Getter
@Table(name = "im_post")
public class ImPost {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "post_no")
	private Long postNo;
	
	@Column(name = "post_category")
	private String postCategory;
	
	@Column(name = "post_title")
	private String postTitle;
	
	@Column(name = "post_content")
	private String postContent;
	
	@Column(name = "post_created_at", updatable = false)
	private LocalDateTime postCreatedAt;
	
	@Column(name = "post_usercode")
	private String postUserCode;
	
	//게시글 작성
	public void writePost(String postCategory, String postTitle, 
			String postContent, String postUserCode) {
		
		this.postCategory = postCategory;
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.postUserCode = postUserCode;
	}
	
	
}
