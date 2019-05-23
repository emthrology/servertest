<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "member.model.vo.Member" %>
    <%@ page import = "member.model.service.MemberService" %>
    <%
    	if(session != null){
    		session.invalidate();
    	}
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Refresh" content="5; url=/index.html"><!-- 5초후 인덱스페이지로 새로고침  -->
<title>Insert title here</title>
</head>
<body>
	<h1>로그아웃</h1>
	<p>5초 후 로그인 페이지로 이동</p>
</body>
</html>