package member1.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member1.model.service.MemberService;
import member1.model.vo.Member;
import member1.model.vo.MemberPageData;

/**
 * Servlet implementation class AdminPageServlet
 */
@WebServlet(name = "AdminPage", urlPatterns = { "/adminPage" })
public class AdminPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    /*
    페이징처리
     
	페이징처리시 필요한 값
	1.reqPage : 현재 요청한 페이지 
		->사용자가 요청
	2.numPerPage : 한 페이지당 게시될 항목 개수
		->개발자의 설정
	3.totalCount : 총 게시물 수
		->db조회(count 함수로)
	4.totalPage : 총 페이지 수
		->totalCount/numPerPage (올림처리 - 남은 게시물들 무조건 한 페이지 차지)
	5.pageNaviSize : 페이지 네비의 수(e.g. 5 : <1 2 3 4 5>)
		->개발자의 설정
	6.pageNo : 페이지 번호 (출력용)
		->개발자의 설정
	
	@@페이지 처리용 쿼리
	게시판의 경우, 가장 최신 글이 나옴
	조회를 할 때는, 게시판의 경우, 가장 오래된 글 부터 조회해야함 -->정렬 필요
	-->정렬 기준 : 아이디, 게시일자(가입일자)
	*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String memberId = ((Member)session.getAttribute("member1")).getMemberId();
		//목록을 처음 불러올 때에는 지정해놓은 reqPage와 pageNo가 없기 때문에 아래와 같이 try~catch로 만들어준다
		int reqPage;
		try {
			reqPage = Integer.parseInt(request.getParameter("reqPage")); // 이 블록은 페이지가 처음 로딩될 때 예외를 발생시킨다(reqPage를 선언만하고 value를 주지 않음)
		} catch(NumberFormatException e) {
			reqPage = 1;// 처음 로딩될 때 1번 페이지를 요구하도록 강제지정
		}
		if(memberId.equals("admin")) {
			MemberPageData mpd = new MemberService().callList(reqPage);
			request.setAttribute("mpd", mpd);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/member1/adminPage.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			request.setAttribute("msg", "잘못된 접근");
			request.setAttribute("loc", "/");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
