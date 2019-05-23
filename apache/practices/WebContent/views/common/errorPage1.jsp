<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
    <%
    	String status = String.valueOf(response.getStatus());
    	String msg = exception!=null?exception.getMessage():status;
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	<section>
		<h1>결과값이 없는데요</h1>
		<p>에러 내용 : <%=msg %></p>
		<a href="/">메인페이지로</a>
	</section>
</body>
</html>