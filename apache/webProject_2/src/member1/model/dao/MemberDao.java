package member1.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import common.JDBCTemplate;
import member1.model.vo.Member;

public class MemberDao {
	private Properties prop = new Properties();
	public MemberDao() {
		String fileName = MemberDao.class.getResource("/sql/member1/member1Query.properties").getPath(); // 절대경로 구해오는법
		//System.out.println(fileName);
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Member login(Connection conn, String memberId, String memberPw) {
		Member m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("login");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPw);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				m = new Member();
				m.setMemberId(rset.getString("member_id"));
				m.setMemberPw(rset.getString("member_pw"));
				m.setMemberName(rset.getString("member_name"));
				m.setAge(rset.getInt("age"));
				m.setEmail(rset.getString("email"));
				m.setPhone(rset.getString("phone"));
				m.setAddress(rset.getString("address"));
				m.setEnrollDate(rset.getDate("enroll_date"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
			
		}
		return m;
		
	}

	public int join(Connection conn, Member m) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("join");	
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, m.getMemberId());
		pstmt.setString(2, m.getMemberPw());
		pstmt.setString(3, m.getMemberName());
		pstmt.setInt(4, m.getAge());
		pstmt.setString(5, m.getEmail());
		pstmt.setString(6, m.getPhone());
		pstmt.setString(7, m.getAddress());
		result = pstmt.executeUpdate();
		JDBCTemplate.close(pstmt);
		return result;
		
	}

	public Member selectOne(Connection conn, String memberId) {
		Member m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectOne");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				m = new Member();
				m.setMemberId(rset.getString("member_id"));
				m.setMemberPw(rset.getString("member_pw"));
				m.setMemberName(rset.getString("member_name"));
				m.setAge(rset.getInt("age"));
				m.setEmail(rset.getString("email"));
				m.setPhone(rset.getString("phone"));
				m.setAddress(rset.getString("address"));
				m.setEnrollDate(rset.getDate("enroll_date"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
			
		}
		return m;
	}

	public String searchId(Connection conn, String memberName, String phone) {
		String memberId = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String qurey = prop.getProperty("searchId");
		try {
			pstmt = conn.prepareStatement(qurey);
			pstmt.setString(1, memberName);
			pstmt.setString(2, phone);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				memberId = rset.getString("member_Id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return memberId;
	}

	public String searchPw(Connection conn, String memberId, String email) {
		String memberPw = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String qurey = prop.getProperty("searchPw");
		try {
			pstmt = conn.prepareStatement(qurey);
			pstmt.setString(1, memberId);
			pstmt.setString(2, email);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				memberPw = rset.getString("member_Pw");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return memberPw;
	}

	public ArrayList<Member> callList(Connection conn, int start, int end) {
		ArrayList<Member> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String qurey = prop.getProperty("callList");
		try {
			pstmt = conn.prepareStatement(qurey);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			list = new ArrayList<Member>();
			while(rset.next()) {
				Member m = new Member();
				m.setMemberId(rset.getString("member_id"));
				m.setMemberPw(rset.getString("member_pw"));
				m.setMemberName(rset.getString("member_Name"));
				m.setAge(rset.getInt("age"));
				m.setEmail(rset.getString("email"));
				m.setPhone(rset.getString("phone"));
				m.setAddress(rset.getString("address"));
				m.setEnrollDate(rset.getDate("enroll_date"));
				list.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public ArrayList<Member> searchKeywordId(Connection conn, String keyword, int start, int end) {
		ArrayList<Member> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("searchKeywordId");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, keyword);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			list = new ArrayList<Member>();
			//test
			System.out.println("keyword :" + keyword + "\n" + "startrowNum : " + start + "\n" + "endrowNum : " + end);
			System.out.println(query);
			while(rset.next()) {
				System.out.println("searchKeywordIdWhileTesting");
				Member m = new Member();
				m.setMemberId(rset.getString("member_id"));
				m.setMemberPw(rset.getString("member_pw"));
				m.setMemberName(rset.getString("member_Name"));
				m.setAge(rset.getInt("age"));
				m.setEmail(rset.getString("email"));
				m.setPhone(rset.getString("phone"));
				m.setAddress(rset.getString("address"));
				m.setEnrollDate(rset.getDate("enroll_date"));
				list.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public ArrayList<Member> searchKeywordName(Connection conn, String keyword, int start, int end) {
		ArrayList<Member> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("searchKeywordName");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			list = new ArrayList<Member>();
			//test
			System.out.println("keyword :" + keyword + "\n" + "startRowNum : " + start + "\n" + "endRowNum : " + end);
			while(rset.next()) {
				Member m = new Member();
				m.setMemberId(rset.getString("member_id"));
				m.setMemberPw(rset.getString("member_pw"));
				m.setMemberName(rset.getString("member_Name"));
				m.setAge(rset.getInt("age"));
				m.setEmail(rset.getString("email"));
				m.setPhone(rset.getString("phone"));
				m.setAddress(rset.getString("address"));
				m.setEnrollDate(rset.getDate("enroll_date"));
				list.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	
	public int totalCount(Connection conn) {
		int totalCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("totalCount");
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if(rset.next()) {
				totalCount = rset.getInt("cnt");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		return totalCount;
	}
	
	public int totalCount(Connection conn, String type, String keyword) {
		int totalCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String queryType = (type.equals("memberId")?"idCount":"nameCount");
		String query = prop.getProperty(queryType);
		try {
			pstmt = conn.prepareStatement(query);
			if(queryType.equals("nameCount")) {
				pstmt.setString(1, "%"+keyword+"%");
			}else {
				pstmt.setString(1, keyword);
			}
			rset = pstmt.executeQuery();
			if(rset.next()) {
				totalCount = rset.getInt("cnt");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		//test
		System.out.println("countByType : " + totalCount);
		return totalCount;
	}

	public int update(Connection conn, Member m) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("update");	
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getMemberPw());
			pstmt.setString(2, m.getMemberName());
			pstmt.setString(3, m.getEmail());
			pstmt.setString(4, m.getPhone());
			pstmt.setString(5, m.getAddress());
			pstmt.setString(6, m.getMemberId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int delete(Connection conn, String memberId) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("delete");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}


	


}
