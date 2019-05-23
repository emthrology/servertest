package member.model.service;

import java.util.ArrayList;

import member.model.dao.MemberDao;
import member.model.vo.Member;

public class MemberService {
	public Member login(String id, String pw) {
		Member m = new MemberDao().login(id,pw);
		return m;
	}
	
	public int update(String memberId,String memberPwd, String email, String phone, String address, String hobby) {
		int result = new MemberDao().upadte(memberId,memberPwd,email,phone,address,hobby);
		return result;
		
	}
	
	public ArrayList<Member> printAll(){
		ArrayList<Member> members = new MemberDao().printAll();
		return members;
		
	}
	
	public int join(String id, String pw, String name, String gender, int age, String email, String phone, String address, String hobby) {
		int result = new MemberDao().join(id, pw, name, gender, age, email, phone, address, hobby);
		return result;
		
	}
	
}
