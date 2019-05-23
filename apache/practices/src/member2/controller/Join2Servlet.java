package member2.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member2.model.service.Member2Service;
import member2.model.vo.Member2;

/**
 * Servlet implementation class Join2Servlet
 */
@WebServlet(name = "Join2", urlPatterns = { "/join2" })
public class Join2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Join2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		String birthday = request.getParameter("birthday");
		Member2 m = new Member2(memberId,memberPw,birthday);
		try {
			int result = new Member2Service().join(m);
			if(result>0) {
				request.setAttribute("msg", "회원가입완료");
			} else {
				request.setAttribute("msg", "회원가입 실패");
			}
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
		} catch (SQLException e) {
			request.setAttribute("msg", "sql에러");
			request.setAttribute("loc", "/views/member/join.jsp");
			request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
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
