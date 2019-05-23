package board.model.vo;

import java.util.ArrayList;

public class BoardViewData {
	private ArrayList<Board> list;
	private Board b;
	public BoardViewData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoardViewData(ArrayList<Board> list, Board b) {
		super();
		this.list = list;
		this.b = b;
	}
	public ArrayList<Board> getList() {
		return list;
	}
	public void setList(ArrayList<Board> list) {
		this.list = list;
	}
	public Board getB() {
		return b;
	}
	public void setB(Board b) {
		this.b = b;
	}
	
	
}
