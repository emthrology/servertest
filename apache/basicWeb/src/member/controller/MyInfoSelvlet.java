package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.vo.Member;

/**
 * Servlet implementation class MyInfoSelvlet
 */
@WebServlet(name = "MyInfo", urlPatterns = { "/myinfo" })
public class MyInfoSelvlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyInfoSelvlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.인코딩 :전송값에 한글이 있을 경우
		request.setCharacterEncoding("utf-8");
		//2.웹에서 보내준 값 변수에 저장(생략)
		//3.비지니스 로직(세션을 불러올거임)
		HttpSession session = request.getSession(false);
		Member m = (Member)session.getAttribute("member");//Object 타입을 형변환
		//4.처리결과 내보내기
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>니 페이지</title></head>");
		out.println("<h1>니 정보</h1>");
		out.println("<form action='/update' method='post'>");
		out.println("<p>비밀번호: <input type='password' name='memberPwd' value='"+m.getMemberPwd()+"'></p>");
		out.println("<p>이메일: <input type='text' name='email' value='"+m.getEmail()+"'></p>");
		out.println("<p>휴대폰: <input type='text' name='phone' value='"+m.getPhone()+"'></p>");
		out.println("<p>주소: <input type='text' name='address' value='"+m.getAddress()+"'></p>");
		out.println("<p>취미: <input type='text' name='hobby' value='"+m.getHobby()+"'></p>");
		out.println("<input type='submit' value='수정하기'>");
		out.println("</form>");
		out.println("<a href='/index.html'>메인페이지로 꺼져</a>");
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
