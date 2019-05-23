package member3.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member3.model.service.Member3Service;
import member3.model.vo.Member3;

/**
 * Servlet implementation class Join3Servlet
 */
@WebServlet(name = "Join3", urlPatterns = { "/join3" })
public class Join3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Join3Servlet() {
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
		String memberName = request.getParameter("memberName");
		String socialSecurityNum = request.getParameter("socialSecurityNum");
		Member3 m3 = new Member3(memberId, memberPw, memberName, socialSecurityNum);
		try {
			int result = new Member3Service().join(m3);
			if(result>0) {
				request.setAttribute("msg", "회원가입완료");
			} else {
				request.setAttribute("msg", "회원가입 실패");
			}
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
		} catch (SQLException e) {
			request.setAttribute("msg", "sql에러");
			request.setAttribute("loc", "/views/member3/join.jsp");
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
