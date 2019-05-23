package member3.model.vo;

import java.util.Calendar;

public class Member3 {
	private String memberId;
	private String memberPw;
	private String memberName;
	private String socialSecurityNum;
	public Member3() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Member3(String memberId, String memberPw, String memberName, String socialSecurityNum) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.socialSecurityNum = socialSecurityNum;
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
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getSocialSecurityNum() {
		return socialSecurityNum;
	}
	public void setSocialSecurityNum(String socialSecurityNum) {
		this.socialSecurityNum = socialSecurityNum;
	}
	
	public int getAge() {
		int sexIdentifier = Integer.parseInt(socialSecurityNum.substring(7,8));
		int year = Integer.parseInt(socialSecurityNum.substring(0,2));
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		if(sexIdentifier>=3) {
			year +=2000;
			return currentYear - year + 1;
		}else {
			year +=1900;
			return currentYear - year + 1;
		}
		
	}
	
	public String getSex() {
		int sexIdentifier = Integer.parseInt(socialSecurityNum.substring(7,8));
		if(sexIdentifier == 1 || sexIdentifier == 3) {
			return "남자";
		} else {
			return "여자";
		}
		
	}
}
