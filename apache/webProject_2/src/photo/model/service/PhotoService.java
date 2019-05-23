package photo.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import photo.model.dao.PhotoDao;
import photo.model.vo.Photo;

public class PhotoService {

	public int insert(Photo p) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new PhotoDao().insert(conn, p);
		if(result>0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int photoTotalCount() {
		Connection conn = JDBCTemplate.getConnection();
		int totalCount = new PhotoDao().totalCount(conn);
		JDBCTemplate.close(conn);
		return totalCount;
	}

	public ArrayList<Photo> morePhoto(int start) {
		Connection conn = JDBCTemplate.getConnection();
		int length = 5; // 한번에 가져올 사진들의 값
		ArrayList<Photo> list = new PhotoDao().morePhoto(conn, start, start+length-1);
		JDBCTemplate.close(conn);
		return list;
	}

}
