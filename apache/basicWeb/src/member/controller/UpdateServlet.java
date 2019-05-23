package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet(name = "Update", urlPatterns = { "/update" })
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
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
		HttpSession session = request.getSession(false);
		Member m = (Member) session.getAttribute("member");
		String id = m.getMemberId();
		
		String pw = request.getParameter("memberPwd");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String addr = request.getParameter("address");
		String hobby = request.getParameter("hobby");
		//3.비지니스 로직
		int result = new MemberService().update(id,pw,email,phone,addr,hobby);
		//4.처리결과 내보내기
		if(result>0) {
			m.setMemberPwd(pw);
			m.setEmail(email);
			m.setPhone(phone);
			m.setAddress(addr);
			m.setHobby(hobby);
			response.sendRedirect("/myinfo");
		}else {
			response.sendRedirect("/index.html");
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
