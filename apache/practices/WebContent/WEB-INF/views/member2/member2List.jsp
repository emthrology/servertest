<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록</title>
</head>
<body>
	<h1>회원목록보기</h1>
	<table class="table table-hover" style="text-align:center; width:80%; margin:0 auto;">
		<tr>
			<th>ID</th><th>비번</th><th>나이</th>
		</tr>
		<c:forEach items="${list }" var="m2">
			<tr>
				<td>${m2.memberId }</td>
				<td>${m2.memberPw }</td>
				<td>${m2.age }</td>
			</tr>
		</c:forEach>
	</table>
	<a href="/">메인페이지로 가기</a>
</body>
</html>