<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%!
    	static int count = 10;
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
		*{
			font-family : 'apple sd gothic neo';
		})
	</style>
</head>
<body>
	<h1>JSP test page</h1>
	<hr>
	<%
		int num = 1;
		if(num == 1) {
	%>
	<h1> count + num 의 값은 <%= count + num %></h1><!--표현식 태그에서 끝마칠 때 ';'를 쓰면 예외발생 -->
	<%}else{ %>
	<h1> 1이 아닙니다. </h1>
	<%} %>
	<%@ include file = "footer.html" %>

</body>
</html>