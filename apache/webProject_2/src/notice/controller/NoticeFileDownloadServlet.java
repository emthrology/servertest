package notice.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NoticeFileDownloadServlet
 */
@WebServlet(name = "NoticeFileDownload", urlPatterns = { "/noticeFileDownload" })
public class NoticeFileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeFileDownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String filename = request.getParameter("filename");
		String filepath = request.getParameter("filepath");
		//파일이 저장되어있는 경로 생성
		String saveDirectory = getServletContext().getRealPath("/upload/notice/");
		//파일과 서블릿 연결 - 스트림
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(saveDirectory + filepath));
		ServletOutputStream sos = response.getOutputStream();
		BufferedOutputStream bos = new BufferedOutputStream(sos);
		//파일명 세팅
		String resFilename = "";
		//브라우저가 IE인지 판단하는 코드
		boolean bool = (request.getHeader("user-agent").indexOf("MSIE") != -1)||(request.getHeader("user-agent").indexOf("Trident") != -1);
		System.out.println("NoticeFileDownloadServlet using IE : " + bool);
		if(bool) { // IE인 경우
			resFilename = URLEncoder.encode(filename, "UTF-8");//대문자 이슈
			resFilename = resFilename.replaceAll("/", "%20");
		} else { // 그 외 브라우저
			resFilename = new String(filename.getBytes("UTF-8"),"ISO-8859-1");
		}
		//파일 다운로드를 위한 HTTP header 설정
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment;filename="+resFilename);
		//파일 전송
		int read = -1;
		while((read=bis.read()) != -1){
			bos.write(read);
		}
		bis.close();
		bos.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
