package com.kh.mvc.member.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.kh.mvc.common.jdbc.JDBCTemplate.*;
import com.kh.mvc.member.model.vo.Member;

public class MemberDao {

	// 멤버 객체로 변환해서 리턴
	// jdbc 라이브러리 이용해서 DB랑 연동
	public Member findMemberById(Connection connection, String id) {
		Member member = null;
//중복		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		// 멤버 조회
		String query = "SELECT * FROM MEMBER WHERE ID=? AND STATUS='Y'";
		
		try {
			// DriverManager에 해당 DBMS Driver 등록
//중복			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 등록된 Driver로 Connection 얻어온다. 링크는 다 다르다 !
//중복			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "WEB", "WEB");
			
			pstm = connection.prepareStatement(query);
			
			// ? 부분에 값을 채워준다.
			// 첫 번째 물음표에 매개값으로 전달해주는 String id 값을 넣어준다. 
			pstm.setString(1, id);
			
			// 쿼리문 실행 후 그 결과값을 resultset으로 리턴해주는 역할
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				member = new Member();
				
				member.setNo(rs.getInt("NO"));
				member.setId(rs.getString("ID"));
				member.setPassword(rs.getString("PASSWORD"));
				member.setRole(rs.getString("ROLE"));
				member.setName(rs.getString("NAME"));
				member.setPhone(rs.getString("PHONE"));
				member.setEmail(rs.getString("EMAIL"));
				member.setAddress(rs.getString("ADDRESS"));
				member.setHobby(rs.getString("HOBBY"));
				member.setStatus(rs.getString("STATUS"));
				member.setEnrollDate(rs.getDate("ENROLL_DATE"));
				member.setModifyDate(rs.getDate("MODIFY_DATE"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 중복 모두 삭제함 !
			// JDBCTemplate을 static import로 해서 클래스명 생략 가능하게 함.
			close(rs);
			close(pstm);
		}
		
		return member;
	}

	public int insertMember(Connection connection, Member member) {
		int result = 0;
		String query ="INSERT INTO MEMBER VALUES(SEQ_UNO.NEXTVAL,?,?,DEFAULT,?,?,?,?,?,DEFAULT,DEFAULT,DEFAULT)";
		PreparedStatement pstm = null;
		
		try {
			pstm = connection.prepareStatement(query);
			
			pstm.setString(1, member.getId());
			pstm.setString(2, member.getPassword());
			pstm.setString(3, member.getName());
			pstm.setString(4, member.getPhone());
			pstm.setString(5, member.getEmail());
			pstm.setString(6, member.getAddress());
			pstm.setString(7, member.getHobby());
			
			result = pstm.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
		}
		
		return result;
	}

}
