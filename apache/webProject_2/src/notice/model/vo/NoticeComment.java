package notice.model.vo;

import java.sql.Date;

public class NoticeComment {
	private int noticeCommentNo;			//댓글번호, primary key
	private int noticeCommentLevel;			//댓글인지 대댓글인지 구분(0이 댓글, 그 이상이 대댓글?)
	private String noticeCommentAuthor;		//댓글작성자(외래키 : member_id
	private String noticeCommentContent;	//댓글 내용
	private int noticeRef;					//댓글을 단 글의 번호(외래키 : notice_no)
	private int noticeCommentRef;			//대댓글을 단 댓글의 번호(외래키 : notice_comment_ref)
	private Date noticeCommentDate;			//댓글 단 날짜
	
	public NoticeComment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NoticeComment(int noticeCommentNo, int noticeCommentLevel, String noticeCommentAuthor,
			String noticeCommentContent, int noticeRef, int noticeCommentRef, Date noticeCommentDate) {
		super();
		this.noticeCommentNo = noticeCommentNo;
		this.noticeCommentLevel = noticeCommentLevel;
		this.noticeCommentAuthor = noticeCommentAuthor;
		this.noticeCommentContent = noticeCommentContent;
		this.noticeRef = noticeRef;
		this.noticeCommentRef = noticeCommentRef;
		this.noticeCommentDate = noticeCommentDate;
	}

	public int getNoticeCommentNo() {
		return noticeCommentNo;
	}

	public void setNoticeCommentNo(int noticeCommentNo) {
		this.noticeCommentNo = noticeCommentNo;
	}

	public int getNoticeCommentLevel() {
		return noticeCommentLevel;
	}

	public void setNoticeCommentLevel(int noticeCommentLevel) {
		this.noticeCommentLevel = noticeCommentLevel;
	}

	public String getNoticeCommentAuthor() {
		return noticeCommentAuthor;
	}

	public void setNoticeCommentAuthor(String noticeCommentAuthor) {
		this.noticeCommentAuthor = noticeCommentAuthor;
	}

	public String getNoticeCommentContent() {
		return noticeCommentContent;
	}

	public void setNoticeCommentContent(String noticeCommentContent) {
		this.noticeCommentContent = noticeCommentContent;
	}

	public int getNoticeRef() {
		return noticeRef;
	}

	public void setNoticeRef(int noticeRef) {
		this.noticeRef = noticeRef;
	}

	public int getNoticeCommentRef() {
		return noticeCommentRef;
	}

	public void setNoticeCommentRef(int noticeCommentRef) {
		this.noticeCommentRef = noticeCommentRef;
	}

	public Date getNoticeCommentDate() {
		return noticeCommentDate;
	}

	public void setNoticeCommentDate(Date noticeCommentDate) {
		this.noticeCommentDate = noticeCommentDate;
	}
	
	

}