package member2.model.dao;

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
import member.model.dao.MemberDao;
import member2.model.vo.Member2;

public class Member2Dao {
	private Properties prop = new Properties();
	public Member2Dao() {
		String filename = MemberDao.class.getResource("/sqls/member2/member2Query.properties").getPath();
		try {
			prop.load(new FileReader(filename));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int join(Connection conn, Member2 m) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("join");
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, m.getMemberId());
		pstmt.setString(2, m.getMemberPw());
		pstmt.setString(3, m.getBirthday());
		result = pstmt.executeUpdate();
		JDBCTemplate.close(pstmt);
		return result;
	}

	public ArrayList<Member2> callList(Connection conn) {
		ArrayList<Member2> list = null;
		Statement stmt = null;
		ResultSet rset = null;
		String qurey = prop.getProperty("callList");
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(qurey);
			list = new ArrayList<Member2>();
			while(rset.next()) {
				Member2 m2 = new Member2();
				m2.setMemberId(rset.getString("member_id"));
				m2.setMemberPw(rset.getString("member_pw"));
				m2.setBirthday(rset.getString("birthday"));
				list.add(m2);
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
