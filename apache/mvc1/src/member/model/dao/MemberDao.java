package member.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import member.model.vo.Member;

public class MemberDao {

	public Member login(String id, String pw) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member m =null;
		String query = 
				"select * from member where member_id=? and member_pwd=?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:49161:xe","system","oracle");
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,id);
			pstmt.setString(2, pw);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				m = new Member();
				m.setMemberId(rset.getString("member_id"));
				m.setMemberPwd(rset.getString("member_pwd"));
				m.setMemberName(rset.getString("member_name"));
				m.setGender(rset.getString("gender"));
				m.setAge(rset.getInt("age"));
				m.setPhone(rset.getString("phone"));
				m.setEmail(rset.getString("email"));
				m.setAddress(rset.getString("address"));
				m.setHobby(rset.getString("hobby"));
				m.setEnrollDate(rset.getDate("enroll_date"));
				System.out.println(m);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return m;
	}

	public int upadte(String memberId,String memberPwd, String email, String phone, String address, String hobby) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "update member set "
				+ "member_pwd = ?,"
				+ "email = ?,"
				+ "phone = ?,"
				+ "address = ?,"
				+ "hobby= ? "
				+ "where member_id = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:49161:xe", "system", "oracle");
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberPwd);
			pstmt.setString(2, email);
			pstmt.setString(3, phone);
			pstmt.setString(4, address);
			pstmt.setString(5, hobby);
			pstmt.setString(6, memberId);
			result = pstmt.executeUpdate();
			//servlet은 오토커밋 해준단다
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	public ArrayList<Member> printAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Member> members = null;
		String query = "select * from member";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:49161:xe", "system", "oracle");
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			members = new ArrayList<Member>();
			while(rset.next()) {
				Member m = new Member();
				m.setMemberId	(rset.getString	("member_id"));
				m.setMemberPwd	(rset.getString	("member_pwd"));
				m.setMemberName	(rset.getString	("member_name"));
				m.setGender		(rset.getString	("gender"));
				m.setAge		(rset.getInt	("age"));
				m.setEmail		(rset.getString	("email"));
				m.setPhone		(rset.getString	("phone"));
				m.setAddress	(rset.getString	("address"));
				m.setHobby		(rset.getString	("hobby"));
				m.setEnrollDate	(rset.getDate	("enroll_date"));
				members.add(m);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return members;
	}

	public int join(String id, String pw, String name, String gender, int age, String email, String phone, String address, String hobby) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "insert into member values("
				+ "?,?,?,?,?,?,?,?,?,sysdate)";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:49161:xe", "system", "oracle");
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, gender);
			pstmt.setInt(5, age);
			pstmt.setString(6, email);
			pstmt.setString(7, phone);
			pstmt.setString(8, address);
			pstmt.setString(9, hobby);
			result = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

}
