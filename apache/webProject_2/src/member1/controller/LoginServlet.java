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
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "Login", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("member1.LoginServlet : 로그인 서블릿 시작");
		//1.인코딩
		request.setCharacterEncoding("utf-8");
		//2.변수저장
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		//3.비즈니스로직
		Member m = new MemberService().login(memberId,memberPw);
		//4.view처리
		//(1)sendRedirect
		//(2)RequestDispatchr --> request.setAttribute를 통해 객체 데이터 전송이 가능함
		//WEB-INF의 view에 있는 페이지들은 Servlet의 비즈니스로직을 통하지않는 직접접근 불가능
		//sendRedirect로는 WEB-INF의 페이지들 접근 불가능
		if(m!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("member1", m);
			request.setAttribute("msg", "로그인 성공");
		}else {
			request.setAttribute("msg", "로그인 실패");
		}
		request.setAttribute("loc", "/");
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		rd.forward(request, response);//페이지 이동
		System.out.println("member1.LoginServlet : 로그인 서블릿 끝");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
