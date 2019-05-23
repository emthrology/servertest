package photo.model.vo;

import java.sql.Date;

public class Photo {
	private int photoNo;
	private String photoAuthor;
	private String photoContent;
	private String filename;
	private Date photoDate;
	public Photo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Photo(int photoNo, String photoAuthor, String photoContent, String filename, Date photoDate) {
		super();
		this.photoNo = photoNo;
		this.photoAuthor = photoAuthor;
		this.photoContent = photoContent;
		this.filename = filename;
		this.photoDate = photoDate;
	}
	public int getPhotoNo() {
		return photoNo;
	}
	public void setPhotoNo(int photoNo) {
		this.photoNo = photoNo;
	}
	public String getPhotoAuthor() {
		return photoAuthor;
	}
	public void setPhotoAuthor(String photoAuthor) {
		this.photoAuthor = photoAuthor;
	}
	public String getPhotoContent() {
		return photoContent;
	}
	public void setPhotoContent(String photoContent) {
		this.photoContent = photoContent;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public Date getPhotoDate() {
		return photoDate;
	}
	public void setPhotoDate(Date photoDate) {
		this.photoDate = photoDate;
	}
	
	@Override
	public String toString() {
		return photoNo+" "+photoAuthor+" "+photoContent+" "+filename+" "+photoDate;
	}
}
