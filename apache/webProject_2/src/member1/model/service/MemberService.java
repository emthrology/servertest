package member1.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import member1.model.dao.MemberDao;
import member1.model.vo.Member;
import member1.model.vo.MemberPageData;

public class MemberService {
	public Member login(String memberId, String memberPw) {
		Connection conn = JDBCTemplate.getConnection();
		Member m = new MemberDao().login(conn, memberId, memberPw);
		JDBCTemplate.close(conn);
		return m;
	}

	public int join(Member m) throws SQLException {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MemberDao().join(conn, m);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public Member selectOne(String memberId) {
		Connection conn = JDBCTemplate.getConnection();
		Member m = new MemberDao().selectOne(conn, memberId);
		JDBCTemplate.close(conn);
		return m;
	}
	
	public MemberPageData searchKeyword(int reqPage, String type, String keyword) {
		Connection conn = JDBCTemplate.getConnection();
		//페이지 당 게시물 수
		int numPerPage = 5;
		//총 게시물 수
		int totalCount = new MemberDao().totalCount(conn, type, keyword);
		//총 페이지 수
		int totalPage = (totalCount%numPerPage==0)?(totalCount/numPerPage):(totalCount/numPerPage)+1;
		//요청 페이지 시작 게시물 번호와 끝 게시물 번호 구하기
		int start = (reqPage-1)*numPerPage+1;
		int end = reqPage*numPerPage;
		//페이지 navigator작성
		String pageNavi = "";
		int pageNaviSize = 3;
		//요청 페이지가 1~5	인 경우
		//1 2 3 4 5 [다음]
		
		int pageNo = ((reqPage-1)/pageNaviSize)*pageNaviSize+1; //navi의 시작 페이지 번호
		//[이전]버튼 생성 로직
		if(pageNo != 1) {
			pageNavi +="<a class='btn' href='/searchKeyword?type="+type+"&keyword="+keyword+"&reqPage="+(pageNo-1)+"'>이전</a>";
		}
		//숫자 페이지 번호 버튼 생성(1 2 3)
		int i = 1;
		while(!(i++ > pageNaviSize || pageNo>totalPage)) {//후위연산 : 로직 작동 후 증가시킴 / 조건 : 페이지 네비 사이즈가 i보다 크거나 같고, 표시하는 페이지가 토탈 페이지보다 작거나 같은 경우
			if(reqPage == pageNo) {//현재 페이지의 경우
				pageNavi +="<span class='selectPage'>"+pageNo+"</span>"; // 링크를 풀고 그냥 숫자만 표시
			} else {
				pageNavi +="<a class='btn' href='/searchKeyword?type="+type+"&keyword="+keyword+"&reqPage="+pageNo+"'>"+pageNo+"</a>"; //reqPage==pageNo일 때까지 하이퍼링크처리
			}
			pageNo++;
		}//while ends
		//[다음]버튼 생성 로직
		if(pageNo <= totalPage) {
			pageNavi +="<a class='btn' href='/searchKeyword?type="+type+"&keyword="+keyword+"&reqPage="+pageNo+"'>다음</a>";
		}
		//두 가지 객체를 리턴하기 때문에 새로운 객체를 만들어 두 객체를 집어넣음
		ArrayList<Member> list = null;
		switch(type) {
		case "memberId": 
			list = new MemberDao().searchKeywordId(conn, keyword, start, end); 
			//list = new ArrayList<Member>();
			//list.add(new MemberDao().selectOne(conn, keyword));
			break;
		case "memberName": 
			list = new MemberDao().searchKeywordName(conn, keyword, start, end); break;
		}
		MemberPageData mpd = new MemberPageData(list,pageNavi);
		//test
		System.out.println("listSize : " + mpd.getList().size());
		System.out.println("pageNavi : " + mpd.getPageNavi());
		System.out.println();
		JDBCTemplate.close(conn);
		return mpd;
	}

	public String searchId(String memberName, String phone) {
		Connection conn = JDBCTemplate.getConnection();
		String memberId = new MemberDao().searchId(conn,memberName,phone);
		JDBCTemplate.close(conn);
		return memberId;
	}

	public String searchPw(String memberId, String email) {
		Connection conn = JDBCTemplate.getConnection();
		String memberPw = new MemberDao().searchPw(conn,memberId,email);
		JDBCTemplate.close(conn);
		return memberPw;
	}

	//
	public MemberPageData callList(int reqPage) {
		Connection conn = JDBCTemplate.getConnection();
		//페이지 당 게시물 수
		int numPerPage = 5;
		//총 게시물 수
		int totalCount = new MemberDao().totalCount(conn);
		//총 페이지 수
		int totalPage = (totalCount%numPerPage==0)?(totalCount/numPerPage):(totalCount/numPerPage)+1;
		//요청 페이지 시작 게시물 번호와 끝 게시물 번호 구하기
		int start = (reqPage -1)*numPerPage+1;
		int end = reqPage*numPerPage;
		ArrayList<Member> list = new MemberDao().callList(conn,start,end);
		//페이지 navigator작성
		String pageNavi = "";
		int pageNaviSize = 3;
		//요청 페이지가 1~5	인 경우
		//1 2 3 4 5 [다음]
		//요청 페이지가 6~10인 경우
		//[이전] 6 7 8 9 10 [다음]
		
		int pageNo = ((reqPage-1)/pageNaviSize)*pageNaviSize+1; //navi의 시작 페이지 번호
		//[이전]버튼 생성 로직
		if(pageNo != 1) {
			pageNavi +="<a class='btn' href='/adminPage?reqPage="+(pageNo-1)+"'>이전</a>";
		}
		//숫자 페이지 번호 버튼 생성(1 2 3)
		int i = 1;
		while(!(i++>pageNaviSize || pageNo>totalPage)) {//후위연산 : 로직 작동 후 증가시킴 / 조건 : 페이지 네비 사이즈가 i보다 작지 않거나, 표시하는 페이지가 토탈 페이지와 같아지지 않는 경우
			if(reqPage == pageNo) {//현재 페이지의 경우
				pageNavi +="<span class='selectPage'>"+pageNo+"</span>"; // 링크를 풀고 그냥 숫자만 표시
			} else {
				pageNavi +="<a class='btn' href='/adminPage?reqPage="+pageNo+"'>"+pageNo+"</a>"; //reqPage==pageNo일 때까지 하이퍼링크처리
			}
			pageNo++;
		}//while ends
		//[다음]버튼 생성
		if(pageNo <= totalPage) {
			pageNavi +="<a class='btn' href='/adminPage?reqPage="+pageNo+"'>다음</a>";
		}
		//test
		//System.out.println(pageNavi);
		
		//두 가지 객체를 리턴하기 때문에 새로운 객체를 만들어 두 객체를 집어넣음
		MemberPageData mpd = new MemberPageData(list, pageNavi);
		JDBCTemplate.close(conn);
		return mpd;
	}

	public int update(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MemberDao().update(conn, m);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int delete(String memberId) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MemberDao().delete(conn, memberId);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
}
