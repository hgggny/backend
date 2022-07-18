package com.kh.mvc.member.model.service;

import com.kh.mvc.member.model.dao.MemberDao;
import com.kh.mvc.member.model.vo.Member;

public class MemberService {

	public Member login(String id, String password) {
		Member member = new MemberDao().findMemberById(id);;
		
		// 비즈니스 로직을 처리하기 위해 
		// findMemberById : 데이터베이스에서 단순하게 데이터를 읽거나 입력하기 위해 조회
		// 직접 데이터를 가져오지 않기 때문에 MemberDao 를 이용
//		member = new MemberDao().findMemberById(id);
		// 만드는 순서 : MemberDao 클래스 - findMemberById 메서드
		// 위에 변수 선언과 동시에 처리
		
		if(member == null || !member.getPassword().equals(password)) {
			return null;
		} else {
			// 꼭 참조변수를 리턴하는지 확인-!
			return member;
		}
		
	}

}
