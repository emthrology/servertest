package calculator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcServlet
 */
@WebServlet(name = "Calc", urlPatterns = { "/calc" })
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalcServlet() {
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
		String operators = request.getParameter("operators");
		//3.Service클래스 호출 ->비지니스로직 처리
		//4.처리결과 내보내기
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>results</title></head>");
		out.println("<body>");
		switch(operators) {
		case "+":
			out.println(firstValue+" + "+secondValue+" = "+(firstValue + secondValue));
			break;
		case "-":
			out.print(firstValue+" - "+secondValue+" = "+(firstValue - secondValue));
			break;
		case "*":
			out.print(firstValue+" * "+secondValue+" = "+(firstValue * secondValue));
			break;
		case "/":
			out.print(firstValue+" / "+secondValue+" = "+((double)firstValue / secondValue));	
		}
		
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
