package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board.model.service.BoardService;
import board.model.vo.Board;

/**
 * Servlet implementation class InsertBoardServlet
 */
@WebServlet(name = "InsertBoard", urlPatterns = { "/insertBoard" })
public class InsertBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "enctype 누락");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
			return;
		}
		String saveDirectory = getServletContext().getRealPath("/") + "upload/board";
		int maxSize = 10*1024*1024;
		MultipartRequest mRequest = new MultipartRequest(request, saveDirectory, maxSize, "utf-8", new DefaultFileRenamePolicy());
		String category = mRequest.getParameter("category");
		String boardTitle = mRequest.getParameter("boardTitle");
		String boardAuthor = mRequest.getParameter("boardAuthor");
		String filepath = mRequest.getParameter("filepath");
		int viewcount = 0;
		String boardContent = mRequest.getParameter("boardContent");
		
		Board b = new Board(0, category, boardAuthor, boardTitle, boardContent, filepath, viewcount, null);
		int result = new BoardService().insertBoard(b);
		if(result>0) {
			request.setAttribute("msg", "작성 완료");
			
		} else {
			request.setAttribute("msg", "작성 실패");
		}
		request.setAttribute("loc", "/boardList");
		request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
