package com.kh.mvc.member.model.service;

import java.sql.Connection;

import static com.kh.mvc.common.jdbc.JDBCTemplate.*;
import com.kh.mvc.member.model.dao.MemberDao;
import com.kh.mvc.member.model.vo.Member;

public class MemberService {

	public Member login(String id, String password) {
		// JDBCTemplate을 static import로 해서 클래스명 생략 가능하게 함.
//		Connection connection = getConnection();
		
		Member member = this.findMemberById(id);
		
		// 비즈니스 로직을 처리하기 위해 
		// findMemberById : 데이터베이스에서 단순하게 데이터를 읽거나 입력하기 위해 조회
		// 직접 데이터를 가져오지 않기 때문에 MemberDao 를 이용
//		member = new MemberDao().findMemberById(id);
		// 만드는 순서 : MemberDao 클래스 - findMemberById 메서드
		// 위에 변수 선언과 동시에 처리
		
		// JDBCTemplate을 static import로 해서 클래스명 생략 가능하게 함.
//		close(connection);
		
		
		if(member == null || !member.getPassword().equals(password)) {
			return null;
		} else {
			// 꼭 참조변수를 리턴하는지 확인-!
			return member;
		}
		
		
		
	}

	public int save(Member member) {
		int result = 0;
		Connection connection = getConnection();
		
		// 넘어오는 member 객체를 DB에 넘겨준다. 
		// insert, delete, update는 정수값을 리턴한다. 
		// insert : 멤버객체에 No 값이 없고, No 값을 시퀀스로 만든다 . 
		// update : 멤버객체에 No 값이 있다.
		// 매개값으로 전달되는 것에 따라서 
		// No값이 있으면 Update, 없으면 Insert로 생각하기
		if (member.getNo() != 0) {
			// update 작업
			result = new MemberDao().updateMember(connection, member);
		} else {
			// insert 작업
			result = new MemberDao().insertMember(connection, member);
		}
		
		
		if (result > 0) {
			commit(connection);
		} else {
			rollback(connection);
		}
		
		close(connection);
		
		return result;
	}

	// 탈퇴
	public int delete(int no) {
		int result = 0;
		Connection connection = getConnection();
		
		result = new MemberDao().updateMemberStatus(connection, no, "N");
		
		if(result > 0 ) {
			commit(connection);
		} else {
			rollback(connection);
		}
		
		close(connection);
		
		return result;
	}

	
	public Boolean isDuplicateId(String id) {
		// 중복되는 코드 제거
//		Connection connection = getConnection();
//		Member member = this.findMemberById(id);
		
//		close(connection);
		
		return this.findMemberById(id) != null;
	}

	// Object → Member 로 바꾸기
	public Member findMemberById(String id) {
		Connection connection = getConnection();
		Member member = new MemberDao().findMemberById(connection, id);
		
		close(connection);
		
		return member;
	}

	public int updatePassword(int no, String password) {
		int result = 0;
		Connection connection = getConnection();
		
		result = new MemberDao().updateMemberPassword(connection, no, password);
		
		if(result > 0 ) {
			commit(connection);
		} else {
			rollback(connection);
		}
		
		close(connection);
		
		return result;
	}
		
		
	
}
