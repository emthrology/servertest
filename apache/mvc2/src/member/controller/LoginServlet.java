package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

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
		//1.인코딩
		request.setCharacterEncoding("utf-8");
		//2.변수저장
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		//3.비즈니스 로직
		Member m = new MemberService().login(id, pw);
		//4.처리결과 내보내기
		response.setContentType("text/html; charset=utf-8");
		//RequestDispatcher 를 통해 msg.jsp로 이동
		RequestDispatcher rd = request.getRequestDispatcher("/views/msg.jsp");
		if(m != null) {
			HttpSession session = request.getSession();
			session.setAttribute("member", m);
			request.setAttribute("msg", "로그인 성공");
		}else {
			request.setAttribute("msg", "로그인 실패");
		}
		//최종 이동할 페이지 정보
		request.setAttribute("loc", "/index.jsp");
		rd.forward(request, response);//이동메소드 forward --> msg.jsp로 이동하는 정보 : 로그인 성공 or 로그인 실패 문자열 / 최종 이동할 페이지 정보
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
