package photo.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import common.JDBCTemplate;
import photo.model.vo.Photo;

public class PhotoDao {
	private Properties prop = new Properties();
	public PhotoDao() {
		String filename = PhotoDao.class.getResource("/sql/photo/photoQuery.properties").getPath();
		try {
			prop.load(new FileReader(filename));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int insert(Connection conn, Photo p) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("insert");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, p.getPhotoAuthor());
			pstmt.setString(2, p.getPhotoContent());
			pstmt.setString(3, p.getFilename());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;

	}

	public int totalCount(Connection conn) {
		int totalCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("photoTotalCount");
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if(rset.next()) {
				totalCount = rset.getInt("cnt");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		return totalCount;
		
	}

	public ArrayList<Photo> morePhoto(Connection conn, int start, int end) {
		ArrayList<Photo> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("morePhoto");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			list = new ArrayList<Photo>();
			while(rset.next()) {
				Photo p = new Photo();
				p.setPhotoNo(rset.getInt("photo_no"));
				p.setPhotoAuthor(rset.getString("photo_author"));
				p.setPhotoContent(rset.getString("photo_content"));
				p.setFilename(rset.getString("filename"));
				p.setPhotoDate(rset.getDate("photo_date"));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

}
