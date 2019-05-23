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

/**
 * Servlet implementation class MyInfoServlet
 */
@WebServlet(name = "MyInfo", urlPatterns = { "/myInfo" })
public class MyInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.인코딩(생략)
		//2.변수 저장
		//how1.method = post
//		HttpSession session = request.getSession(false); // 세션에서 뭘 가져와야하는거 아님?
//		Member m = (Member)session.getAttribute("member1");
//		String memberId = m.getMemberId();
		//how2.method = get
		String memberId = request.getParameter("memberId");
		
		Member mChk = new MemberService().selectOne(memberId);
		if(mChk != null) {
			request.setAttribute("member1", mChk);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/member1/myInfo.jsp");
			rd.forward(request, response);
		} else {
			response.sendRedirect("/");
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
