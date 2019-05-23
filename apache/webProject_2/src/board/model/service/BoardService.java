package board.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import board.model.dao.BoardDao;
import board.model.vo.Board;
import board.model.vo.BoardPageData;
import board.model.vo.BoardViewData;
import common.JDBCTemplate;

public class BoardService {

	public BoardPageData callList(int reqPage) {
		Connection conn = JDBCTemplate.getConnection();
		int numPerPage = 5;
		int totalCount = new BoardDao().totalCount(conn);
		int totalPage = (totalCount%numPerPage==0)?(totalCount/numPerPage):(totalCount/numPerPage)+1;
		int start = (reqPage-1)*numPerPage+1;
		ArrayList<Board> list = new BoardDao().callList(conn,start,reqPage*numPerPage);
		int pageNaviSize = 5;
		int pageNo = ((reqPage-1)/pageNaviSize)*pageNaviSize+1;
		String pageNavi = "";
		if(pageNo != 1) {
			pageNavi += "<a class='btn' href='/boardList?reqPage="+(pageNo-1)+"'>이전</a>";
		}
		int i = 1;
		while(i++ <= pageNaviSize && pageNo <= totalPage) {
			if(reqPage == pageNo) {
				pageNavi +="<span class='selectPage'>"+pageNo+"</span>";
			} else {
				pageNavi +="<a class='btn' href='/boardList?reqPage="+pageNo+"'>"+pageNo+"</a>";
			}
			pageNo++;
		} // while ends
		if(pageNo <= totalPage) {
			pageNavi +="<a class='btn' href='/boardList?reqPage="+pageNo+"'>다음</a>";
		}
		BoardPageData bpd = new BoardPageData(list, pageNavi);
		JDBCTemplate.close(conn);
		return bpd;
	}

	public int insertBoard(Board b) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new BoardDao().insertBoard(conn, b);
		if(result>0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public BoardViewData selectOne(int boardNo) {
		Connection conn = JDBCTemplate.getConnection();
		Board b = new BoardDao().selectOne(conn, boardNo);
		//댓글 달 ArrayList<BoardComment> 필요
		BoardViewData bvd = new BoardViewData(null, b);
		JDBCTemplate.close(conn);
		return bvd;
	}

}
