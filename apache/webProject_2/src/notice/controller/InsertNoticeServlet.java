package notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class InsertNoticeServlet
 */
@WebServlet(name = "InsertNotice", urlPatterns = { "/insertNotice" })
public class InsertNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertNoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.인코딩
		request.setCharacterEncoding("utf-8");
		//2.변수에 저장
		//파일 업로드의 경우 enctype=multipart/form-data인지 확인해야함
		if(!ServletFileUpload.isMultipartContent(request)) {// multipart/form-data가 아닌 경우 
			request.setAttribute("msg", "공지사항 작성 실패:[enctype]");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response); //한방에 만들어서 보내기
			return;//서블릿 종료
		}
		//파일 업로드 준비
		//파일 업로드 경로 지정
		String root = getServletContext().getRealPath("/"); // 절대경로 읽어오는 메소드 - WebContent폴더까지 읽어옴
		String saveDir = root+"upload/notice";
		//파일 최대크기 지정 (cos library는 10mb까지만 허용)
		int maxSize = 10*1024*1024; // 10MB = 10,000KB = 10,000,000Byte
		//request -> MultipartRequest로 변환 
		//new DefaultFileRenamePolicy() : 중복이름의 파일에 넘버링해주는 메소드
		MultipartRequest mRequest = new MultipartRequest(request, saveDir, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		String noticeTitle = mRequest.getParameter("noticeTitle");
		String noticeContent = mRequest.getParameter("noticeContent");
		String noticeAuthor = mRequest.getParameter("noticeAuthor");
		String filename = mRequest.getOriginalFileName("filename");
		String filepath = mRequest.getFilesystemName("filename");
		//3.비지니스 로직
		Notice n = new Notice(0, noticeTitle, noticeAuthor, noticeContent, null, filename, filepath);
		System.out.println("servlet : " + n);
		int result = new NoticeService().insertNotice(n);
		//4.view처리
		if(result>0) {
			request.setAttribute("msg", "작성 완료");
			
		} else {
			request.setAttribute("msg", "작성 실패");
		}
		request.setAttribute("loc", "/noticeList");
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
