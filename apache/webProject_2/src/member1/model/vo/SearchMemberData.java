package member1.model.vo;

public class SearchMemberData {
	private String type;
	private String keyword;
	public SearchMemberData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SearchMemberData(String type, String keyword) {
		super();
		this.type = type;
		this.keyword = keyword;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	
}
