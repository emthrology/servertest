<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "member.model.vo.Member" %>
    <%@ page import = "member.model.service.MemberService" %>
    <%
    	//1.인코딩
    	request.setCharacterEncoding("utf-8");
    	//2.변수저장
    		//세션으로부터 수정할 사람의 객체와 그 아이디 가져옴
    	Member m = (Member)session.getAttribute("member");
    	String memberId = m.getMemberId();
    	
    	String memberPwd = request.getParameter("memberPwd");
    	String email = request.getParameter("email");
    	String phone = request.getParameter("phone");
    	String address = request.getParameter("address");
    	String hobby = request.getParameter("hobby");
    	//3.비지니스 로직
    	int result = new MemberService().update(memberId, memberPwd, email, phone, address, hobby);
    	//4.처리결과 내보내기(아래에 씀)
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		if(result>0) {
			m.setMemberPwd(memberPwd);
			m.setEmail(email);
			m.setPhone(phone);
			m.setAddress(address);
			m.setHobby(hobby);
	%>
		<script>
			alert("수정 성공");
			location.href="/views/myinfo.jsp";
		</script>	
		
	<% 	}else { %>	
			<script>
				alert("수정 실패");
				location.href="/index.html";
			</script>
	<%	} %>
</body>
</html>