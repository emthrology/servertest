package notice.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import notice.model.dao.NoticeDao;
import notice.model.vo.Notice;
import notice.model.vo.NoticeComment;
import notice.model.vo.NoticePageData;
import notice.model.vo.NoticeViewData;

public class NoticeService {

	public NoticePageData callList(int reqPage) {
		Connection conn = JDBCTemplate.getConnection();
		int numPerPage = 5;
		int totalCount = new NoticeDao().totalCount(conn);
		int totalPage = (totalCount%numPerPage==0)?(totalCount/numPerPage):(totalCount/numPerPage)+1;
		int start = (reqPage-1)*numPerPage+1;
		int end = reqPage*numPerPage;
		ArrayList<Notice> list = new NoticeDao().callList(conn,start,end);
		int pageNaviSize = 5;
		int pageNo = ((reqPage-1)/pageNaviSize)*pageNaviSize+1;
		String pageNavi = "";
		if(pageNo != 1) {
			pageNavi += "<a class='btn' href='/noticeList?reqPage="+(pageNo-1)+"'>이전</a>";
		}
		int i = 1;
		while(i++<=pageNaviSize && pageNo<=totalPage) {
			if(reqPage == pageNo) {
				pageNavi +="<span class='selectPage'>"+pageNo+"</span>";
			} else {
				pageNavi +="<a class='btn' href='/noticeList?reqPage="+pageNo+"'>"+pageNo+"</a>";
			}
			pageNo++;
		}
		if(pageNo <= totalPage) {
			pageNavi +="<a class='btn' href='/noticeList?reqPage="+pageNo+"'>다음</a>";
		}
		NoticePageData npd = new NoticePageData(list,pageNavi);
		JDBCTemplate.close(conn);
		return npd;
	}

	public NoticeViewData selectOne(int noticeNo) {
		Connection conn = JDBCTemplate.getConnection();
		Notice n = new NoticeDao().selectOne(conn,noticeNo);
		ArrayList<NoticeComment>list = new NoticeDao().selectCommentList(conn,noticeNo);
		n.setNoticeContent(n.getNoticeContent().replaceAll("\r\n", "<br>"));
		NoticeViewData nvd = new NoticeViewData(list, n);
		JDBCTemplate.close(conn);
		return nvd;
	}

	public int insertNotice(Notice n) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new NoticeDao().insertNotice(conn, n);
		if(result>0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int insertNoticeCommment(NoticeComment nc) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new NoticeDao().isertNoticeComment(conn,nc);
		if(result>0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int updateNoticeCommment(NoticeComment nc) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new NoticeDao().updateNoticeComment(conn, nc);
		if(result>0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int noticeUpdate(Notice n) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new NoticeDao().noticeUpdate(conn, n);
		if(result>0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int deleteNotice(int noticeNo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new NoticeDao().deleteNotice(conn, noticeNo);
		if(result>0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

}
