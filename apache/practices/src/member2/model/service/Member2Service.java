package member2.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import member2.model.dao.Member2Dao;
import member2.model.vo.Member2;

public class Member2Service {

	public int join(Member2 m) throws SQLException {
		Connection conn = JDBCTemplate.getConnection();
		int result = new Member2Dao().join(conn,m);
		if(result>0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<Member2> callList() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Member2> list = new Member2Dao().callList(conn);
		JDBCTemplate.close(conn);
		return list;
	}

}
