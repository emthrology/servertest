package member.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import member.model.dao.MemberDao;
import member.model.vo.Member;

public class MemberService {

	public int join(Member m) throws SQLException {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MemberDao().join(conn,m);
		if(result>0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public Member login(String memberId, String memberPw) {
		Connection conn = JDBCTemplate.getConnection();
		Member m = new MemberDao().login(conn, memberId,memberPw);
		JDBCTemplate.close(conn);
		return m;
	}

	public ArrayList<Member> callList() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Member> list = new MemberDao().callList(conn);
		JDBCTemplate.close(conn);
		return list;
	}

}