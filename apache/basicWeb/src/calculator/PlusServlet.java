package calculator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PlusServlet
 */
@WebServlet(name = "Plus", urlPatterns = { "/plus" })
public class PlusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.전송값에 한글이 있을 경우의 인코딩
		request.setCharacterEncoding("utf-8");
		//2.웹에서 보내준 데이터를 꺼내서 변수에 저장
		int firstValue = Integer.parseInt(request.getParameter("firstValue"));
		int secondValue = Integer.parseInt(request.getParameter("secondValue"));
		//3.Service클래스 호출 ->비지니스로직 처리
		//4.처리결과 내보내기
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>더하기 결과</title></head>");
		out.println("<body>");
		out.println(firstValue+" + "+secondValue+" = "+(firstValue+secondValue));
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);// post로 요청해도 doGet()으로 가기 때문에 로직을 고치려면 doGet()만 고치면 됨
	}

}
