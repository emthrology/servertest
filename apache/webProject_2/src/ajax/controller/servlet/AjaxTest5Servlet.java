package ajax.controller.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import ajax.model.vo.user.User;

/**
 * Servlet implementation class AjaxTest5Servlet
 */
@WebServlet(name = "AjaxTest5", urlPatterns = { "/ajaxTest5.do" })
public class AjaxTest5Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxTest5Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//DB대용
		ArrayList<User> list = new ArrayList<User>();
		User user1 = new User(1, "name1","seoul1");
		User user2 = new User(2, "name2","seoul2");
		User user3 = new User(3, "name3","seoul3");
		User user4 = new User(4, "name4","seoul4");
		User user5 = new User(5, "name5","seoul5");
		list.add(user1);
		list.add(user2);
		list.add(user3);
		list.add(user4);
		list.add(user5);
		
		int userNum = Integer.parseInt(request.getParameter("userNum"));
		User user = list.get(userNum - 1);
		JSONObject result = new JSONObject(); // JSON으로 JS형 객체 만들기
		result.put("userNo", user.getUserName());
		result.put("userName", URLEncoder.encode(user.getUserName(), "utf-8")); //한글 인코딩
		result.put("userAddr", URLEncoder.encode(user.getUserAddr(), "utf-8"));
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(result);
		out.flush(); // 버퍼링되어 아직 기록되지 않은 데이터를 출력 스트림에 모두 출력
		out.close(); // 출력되지 않은 데이터가 있으면 먼저 출력하고 스트림 닫기
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
