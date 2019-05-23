package inputExam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InputBoxServlet
 */
@WebServlet(name = "InputBox", urlPatterns = { "/inputBox" })
public class InputBoxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InputBoxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.인코딩
		request.setCharacterEncoding("utf-8");
		//2.보내준 데이터 변수에 저장
		String chkMail = request.getParameter("chk_mail");
		String comment = request.getParameter("comment");
		String gender = request.getParameter("gender");
		String[] places = request.getParameterValues("place");//여러 값을 전달 받는 경우 쓰는 메소드
		//3.비지니스 로직 처리(생략)
		//4.처리결과 내보내기
		response.setContentType("text/html;charset=UTF-8");//리스폰스 데이터의 케릭터셋 정하는 메소드
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>결과</title></head>");
		out.println("<body><h2>당신이 선택한 관광지</h2><hr>");
		for(String place : places) {
			out.print(place + " ");
		}
		out.println("<h2>당신의 성별은 "+gender+"입니다</h2>");
		out.println("<h2>메일 수신여부는 "+(chkMail.equals("yes")?"동의":"거부")+"입니다.</h2>");
		out.println("<h2>가입입사</h2><hr>");
		out.println(comment);
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
