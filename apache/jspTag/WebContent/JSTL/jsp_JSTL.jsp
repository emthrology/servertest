<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="jsp_JSTL_if.jsp">
		숫자 입력 : <input type="text" name="num1">
		<input type="submit" value="전송">
 	</form>
 	<hr>
	<form action="jsp_JSTL_choose.jsp">
		1~3	중 하나 입력 : <input type="text" name="num2">
		<input type="submit" value="submit">
	</form>
	<hr>
	<h2>JSTL forEach</h2>
	<a href="/jspTag/JSTL/jsp_JSTL_foreach.jsp">for-each문 이용</a>
	<hr>
	<h2>JSTL forTokens</h2>
	<form action="/jspTag/JSTL/jsp_JSTL_forTokens.jsp">
		type(delimiter : ',') :<input type="text" name="hobby">
		<input type="submit" value="submit">
	</form>
</body>
</html>