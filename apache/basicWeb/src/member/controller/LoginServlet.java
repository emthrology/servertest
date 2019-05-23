package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
		//2.변수 저장
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		//3.비지니스 로직
		Member m = new MemberService().login(id,pw);
		//4.처리결과 내보내기
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		if(m!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("member", m);
			out.println("<html><head><title>로그인 성공</title></head>");
			out.println("<h1>로그인 성공했어</h1>");
			out.println("<h1>"+m.getMemberName()+"님 환영합니다.</h1>");
			out.println("<a href='/myinfo'>니 페이지</a><br>");
			out.println("<a href='/logout'>로그아웃</a><br>");
			out.println("<a href='/index.html'>메인페이지로 꺼져</a>");
			out.println("</body></html>");
		}else {
			out.println("<html><head><title>로그인 실패</title></head>");
			out.println("<h1>로그인 실패했어</h1>");
			out.println("<h1>아이디 혹은 패스워드를 확인해봐라</h1>");
			out.println("</body></html>");
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
