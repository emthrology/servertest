package board.model.vo;

import java.sql.Date;

public class Board {
	private int boardNo;
	private String category;
	private String boardAuthor;
	private String boardTitle;
	private String boardContent;
	private String filepath;
	private int viewcount;
	private Date boardDate;
	
	public Board() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Board(int boardNo, String category, String boardAuthor, String boardTitle, String boardContent, String filepath, int viewcount, Date boardDate) {
		super();
		this.boardNo = boardNo;
		this.category = category;
		this.boardAuthor = boardAuthor;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.filepath = filepath;
		this.viewcount = viewcount;
		this.boardDate = boardDate;
	}
	
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getBoardAuthor() {
		return boardAuthor;
	}
	public void setBoardAuthor(String boardAuthor) {
		this.boardAuthor = boardAuthor;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public Date getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}
	
	public int getViewcount() {
		return viewcount;
	}
	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	
	@Override
	public String toString() {
		return boardNo+" "+category+" "+boardAuthor+" "+boardTitle+" "+boardContent+" "+filepath+" "+viewcount+" "+boardDate;
	}
	
}
