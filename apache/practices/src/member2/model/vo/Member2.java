package member2.model.vo;

import java.util.Calendar;

public class Member2 {
	private String memberId;
	private String memberPw;
	private String birthday;
	public Member2() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Member2(String memberId, String memberPw, String birthday) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.birthday = birthday;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public int getAge() {
		String birthYear = birthday.substring(0,4);
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		return (currentYear - Integer.parseInt(birthYear)+1);
	}
}
