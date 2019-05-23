package notice.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class MultiUploadServlet
 */
@WebServlet(name = "MultiUpload", urlPatterns = { "/multiUpload" })
public class MultiUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MultiUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//1.메모리나 파일로 업로드파일을 보관하는 FileItem의 Factory설정 (import org.apache.commons.fileupload.disk.DiskFileItemFactory /commons를 가져와야함)
		DiskFileItemFactory diskFactory = new DiskFileItemFactory();
		//업로드시 사용할 임시메모리 (단위 :byte, 기본값10240(10KB))
		diskFactory.setSizeThreshold(4096);
		//용량이 임시메모리를 초과할 경우 사용할 임시 저장 폴더 지정
		diskFactory.setRepository(new File(getServletContext().getRealPath("/")+"upload/test"));
		//2.업로드요청을 처리하는 ServletFileUpload객체 생성
		ServletFileUpload upload = new ServletFileUpload(diskFactory);
		//파일 다중업로드 가능
		//setSizeMax(long sizeMax) : 전체 파일 업로드 최대크기 / setFileSizeMax(long fileSizeMax) : 각 파일의 업로 최대크기 지정
		upload.setSizeMax(100*1024*1024);
		//3.ServletFileUpload객체를 이용하여 request에서 보낸 parameter값 처리
		//모든 parameter가 FileItem이라는 형태로 저장, list구조
		try {
			List<FileItem> items = upload.parseRequest(request);
			Iterator iter = items.iterator();
			ArrayList<String> list = new ArrayList<String>();
			//form태그에서 작성된 순서대로 꺼내짐 - cos는 순서없이 꺼내짐
			while(iter.hasNext()) {
				FileItem item = (FileItem)iter.next();
				if(item.isFormField()) {//isFormField() == true이면 파일이 아닌 일반 파라미터인 경우
					String fieldName = item.getFieldName();
					String param = item.getString("UTF-8");//utf-8로 인코딩하여 저장
					list.add(fieldName);
				} else { // 파일인 경우
					String fileOriginName = item.getName();//파일명 변수에 저장
					if(!fileOriginName.equals("")) {//파일이름이 공백이 아니면 == 파일이 있다면
						String fieldName = item.getFieldName();
						String contentType = item.getContentType();
						long fileSize = item.getSize();
						list.add(fieldName);
						//중복파일명 제거 코드
						//파일 이름과 확장자를 분리한 후 파일이름을 비교하여 같으면 뒤에 넘버링하고 다시 확장자와 합체
						String filenameFront = fileOriginName.substring(0, fileOriginName.lastIndexOf('.')); // 확장자를 제외한 앞부분
						String fileNameExtension = fileOriginName.substring(fileOriginName.lastIndexOf('.')); // 확장자만
						File uploadFile = null;
						StringBuilder fileName = new StringBuilder();
						int num = 0;
						while(true) {
							fileName.setLength(0);
							fileName.append(filenameFront);
							if(num != 0) {
								fileName.append("_"+num);
							}
							fileName.append(fileNameExtension);
							uploadFile = new File(getServletContext().getRealPath("/")+"upload/ttest/"+fileName.toString());//실제로 저장될 폴더
							if(!uploadFile.exists()) {
								list.add(fileName.toString());
								try {
									item.write(uploadFile);
									break;//wile을 빠져나감, 파일명이 겹치지 않을때까지 반복
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							num++;
						}//while ends
					}
				}
				for(String test : list) {
					System.out.println(test);
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
