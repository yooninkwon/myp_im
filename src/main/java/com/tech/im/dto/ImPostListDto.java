package com.tech.im.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImPostListDto {
	
    private int post_no;              
    private String post_category;      
    private String post_title;               
    private Date post_created_at; 
    private String user_nickname;
	
}
