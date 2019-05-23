package ajax.controller.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import ajax.model.vo.user.User;

/**
 * Servlet implementation class AjaxText12Servlet
 */
@WebServlet(name = "AjaxTest12", urlPatterns = { "/ajaxTest12.do" })
public class AjaxTest12Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxTest12Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("/ajaxTest12 시작");
		HashMap<String, User> map = new HashMap<String, User>();
		User user1 = new User(1, "name1","seoul1");
		User user2 = new User(2, "name2","seoul2");
		User user3 = new User(3, "name3","seoul3");
		User user4 = new User(4, "name4","seoul4");
		User user5 = new User(5, "name5","seoul5");
		//System.out.println("/ajaxTest12 insert into map start");
		map.put(user1.getUserName(), user1);
		map.put(user2.getUserName(), user2);
		map.put(user3.getUserName(), user3);
		map.put(user4.getUserName(), user4);
		map.put(user5.getUserName(), user5);
		//System.out.println("/ajaxTest12 insert into map complete");
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		new Gson().toJson(map,response.getWriter());
		//System.out.println("/ajaxTest12 끝");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}