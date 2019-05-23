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

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import ajax.model.vo.user.User;

/**
 * Servlet implementation class AjaxTest9Servlet
 */
@WebServlet(name = "AjaxTest9", urlPatterns = { "/ajaxTest9.do" })
public class AjaxTest9Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxTest9Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		JSONArray userArr = new JSONArray(); // 안에 JSONObject를 담을 수 있는 Array
		JSONObject userInfo = null;
		for(User user : list) {
			userInfo = new JSONObject();
			userInfo.put("userNo", user.getUserNo());
			userInfo.put("userName", URLEncoder.encode(user.getUserName(),"UTF-8"));
			userInfo.put("userAddr", URLEncoder.encode(user.getUserAddr(),"UTF-8"));
			userArr.add(userInfo);
		}
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(userArr);
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
