<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.vo.Member"%>
    <%
    	Member m = (Member)session.getAttribute("member");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>메인페이지</h1><hr>
	<% if(m == null){ %>
	<form action="/login" method="post">
		ID : <input type="text" name='id'><br>
		PW : <input type="password" name="pw"><br>
		<input type="submit" value="제출">
		<input type="reset" value="취소">
	</form>
	<% }else { %>
		<h1><%= m.getMemberName() %>님 환영합니다.</h1>
	<% } %>	
</body>
</html>