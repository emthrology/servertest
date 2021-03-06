package member1.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.RequestWrapper;

import member1.model.service.MemberService;
import member1.model.vo.MemberPageData;
import member1.model.vo.SearchMemberData;

/**
 * Servlet implementation class SearchKeywordServlet
 */
@WebServlet(name = "SearchKeyword", urlPatterns = { "/searchKeyword" })
public class SearchKeywordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchKeywordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.인코딩
		request.setCharacterEncoding("utf-8");
		//2.변수저장
		String type = request.getParameter("type"); //찾을 종류 : 이름, 아이디 중 고르는 곳
		String keyword = request.getParameter("keyword"); // 구체적으로 찾을 키워드
		int reqPage;
		try {
			reqPage = Integer.parseInt(request.getParameter("reqPage")); // 이 블록은 페이지가 처음 로딩될 때 예외를 발생시킨다(reqPage를 선언만하고 value를 주지 않음)
		} catch(NumberFormatException e) {
			reqPage = 1;// 처음 로딩될 때 1번 페이지를 요구하도록 강제지정
		}
		//3.비즈니스로직
//		ArrayList<Member> list = new MemberService().searchKeyword(type,keyword);
		MemberPageData mpd = new MemberService().searchKeyword(reqPage, type, keyword);
		SearchMemberData smd = new SearchMemberData(type,keyword);
		//4.view에 전달
		request.setAttribute("mpd", mpd);
		request.setAttribute("smd", smd);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/member1/adminPage.jsp");
//		검색 이후 검색 조건과 키워드 초기화되는 현상 방지하기위해 view로 다시 보내줌 (setting은 view에서 JQuery로 하면됨...)
//		request.setAttribute("type", type);
//		request.setAttribute("keyword", keyword);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
