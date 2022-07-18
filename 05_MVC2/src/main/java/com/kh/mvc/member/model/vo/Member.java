package com.kh.mvc.member.model.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Member {
	// DB 각 컬럼은 <필드> !
	// 작성할 때 java 작성법으로 하기
	private int no;
	
	private String id;
	
	private String password;
	
	private String role;
	
	private String name;
	
	private String phone;
	
	private String email;
	
	private String address;
	
	private String hobby;
	
	private String status;
	
	// java.util
	private Date enrollDate;
	
	private Date modifyDate;
}
