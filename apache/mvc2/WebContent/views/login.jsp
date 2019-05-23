<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%-- 사용할 클래스 in --%>
    <%@ page import = "member.model.vo.Member" %>
    <%@ page import = "member.model.service.MemberService" %>
    <%
    	//1.인코딩
    	request.setCharacterEncoding("utf-8");
    	//2.보내준 변수 저장 
    	String id = request.getParameter("id");
    	String pw = request.getParameter("pw");
    	//3.비즈니스로직
    	Member m = new MemberService().login(id, pw);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" content="text/html; charset=UTF-8">
<title>로그인</title>
</head>
<body>
	<%
		if(m!=null){	
			session.setAttribute("member", m);
	%>
		<h1>로그인 성공</h1>
		<h1><%= m.getMemberName() %>님 환영합니다.</h1>
		<a href="/views/myinfo.jsp">마이페이지</a><br>
		<a href="/views/logout.jsp">로그아웃</a><br>
		<a href="/views/lists.jsp">회원 목록 보기</a>
	<%
		}else{
	%>
		<script>
			alert("로그인 실패");
			location.href="/index.html";
		</script>
	<%} %>
</body>
</html>