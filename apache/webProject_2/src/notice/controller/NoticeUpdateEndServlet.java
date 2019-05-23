package notice.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeUpdateEndServlet
 */
@WebServlet(name = "NoticeUpdateEnd", urlPatterns = { "/noticeUpdateEnd" })
public class NoticeUpdateEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdateEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//변수저장
		if(!ServletFileUpload.isMultipartContent(request)) { //올바른 형식이 아닌 경우
			request.setAttribute("msg", "공지사항 수정 오류");
			request.setAttribute("loc", "/");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			rd.forward(request, response);
			return;
		} else { // 올바른 형식일 때
			//경로, 최대크기 지정
			String root = getServletContext().getRealPath("/");
			String saveDirectory = root + "upload/notice";
			int maxSize = 1024*1024*10;
			//멀티파일 리퀘스트 객체 생성 - 이 때 파일 업로드 실행됨
			MultipartRequest mpRequest = new MultipartRequest(request, saveDirectory, maxSize, "UTF-8", new DefaultFileRenamePolicy());
			//변수 저장
			int noticeNo = Integer.parseInt(mpRequest.getParameter("noticeNo"));
			String noticeTitle = mpRequest.getParameter("noticeTitle");
			String noticeContent = mpRequest.getParameter("noticeContent");
			String filename = mpRequest.getOriginalFileName("filename");
			String filepath = mpRequest.getFilesystemName("filename");
			//기존경로
			String oldFilename = mpRequest.getParameter("oldFilename");
			String oldFilepath = mpRequest.getParameter("oldFilepath");
			//삭제로직 확인용
			String status = mpRequest.getParameter("status");
			File f = mpRequest.getFile("filename");
			if(f != null && f.length()>0) { // (1)새로운 첨부파일이 있는 경우
				if(oldFilename != null) { // 1) 기존파일을 교체하는 경우(멀티파일업로드가 아니므로 당연히 교체해야함)
					File deleteFile = new File(saveDirectory + "/" + oldFilename);
					boolean bool = deleteFile.delete();
					System.out.println("NoticeUpdateEndServlet - 파일삭제 : " + bool); // test
				}
			} else { // (2)새로운 첨부파일이 없는 경우
				if(status.equals("stay")) { // 1)기존파일을 삭제하지 않은 경우
					filename = oldFilename;
					filepath = oldFilepath;
				} else { // 2)기존파일 삭제한 경우
					File deleteFile = new File(saveDirectory + "/" + oldFilename);
					boolean bool = deleteFile.delete();
					System.out.println("NoticeUpdateEndServlet - 파일삭제 : " + bool); // test
				}
			}
			//비즈니스 로직
			Notice n = new Notice(noticeNo, noticeTitle, null, noticeContent, null, filename, filepath);
			//view 처리
			int result = new NoticeService().noticeUpdate(n);
			if(result>0) {
				request.setAttribute("msg", "공지 수정 완료");
			} else {
				request.setAttribute("msg", "공제 수정 실패");
			}
			request.setAttribute("loc", "/noticeView?noticeNo="+noticeNo);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			rd.forward(request, response);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
