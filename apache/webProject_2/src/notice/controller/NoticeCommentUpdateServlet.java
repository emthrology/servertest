package notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.vo.NoticeComment;

/**
 * Servlet implementation class NoticeCommentUpdateServlet
 */
@WebServlet(name = "NoticeCommentUpdate", urlPatterns = { "/noticeCommentUpdate" })
public class NoticeCommentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeCommentUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		int noticeCommentNo = Integer.parseInt(request.getParameter("noticeCommentNo"));
		int noticeCommentLevel = Integer.parseInt(request.getParameter("noticeCommentLevel"));
		String noticeCommentAuthor = request.getParameter("noticeCommentAuthor");
		String noticeCommentContent = request.getParameter("noticeCommentContent");
		int noticeRef = Integer.parseInt(request.getParameter("noticeRef"));
		int noticeCommentRef = Integer.parseInt(request.getParameter("noticeCommentRef"));
		
		NoticeComment nc = new NoticeComment(noticeCommentNo, noticeCommentLevel, noticeCommentAuthor, noticeCommentContent, noticeRef, noticeCommentRef, null);
		
		int result = new NoticeService().updateNoticeCommment(nc);
		if(result>0) {
			request.setAttribute("msg", "댓글 입력 완료");
		} else {
			request.setAttribute("msg", "댓글 입력 실패");
		}
		request.setAttribute("loc", "/noticeView?noticeNo="+noticeRef);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
