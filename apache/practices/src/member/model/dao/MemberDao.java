package member.model.dao;

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
import member.model.vo.Member;

public class MemberDao {
	private Properties prop = new Properties();
	public MemberDao() {
		String filename = MemberDao.class.getResource("/sqls/member/memberQuery.properties").getPath();
		try {
			prop.load(new FileReader(filename));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int join(Connection conn, Member m) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("join");
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, m.getMemberId());
		pstmt.setString(2, m.getMemberPw());
		pstmt.setInt(3, m.getAge());
		pstmt.setInt(4, m.getSex());
		result = pstmt.executeUpdate();
		JDBCTemplate.close(pstmt);
		return result;
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

	public ArrayList<Member> callList(Connection conn) {
		ArrayList<Member> list = null;
		Statement stmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("callList");
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			list = new ArrayList<Member>();
			while(rset.next()) {
				Member m = new Member();
				m.setMemberId(rset.getString("member_id"));
				m.setMemberPw(rset.getString("member_pw"));
				m.setAge(rset.getInt("age"));
				m.setSex(rset.getInt("sex"));
				list.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		return list;
	}

}
