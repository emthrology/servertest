package member.model.service;

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
	
}
