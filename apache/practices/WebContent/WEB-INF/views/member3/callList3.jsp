<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member3 전체 출력</title>
</head>
<body>
	<h1>회원목록보기</h1>
	<table class="table table-hover" style="text-align:center; width:80%; margin:0 auto;">
		<tr>
			<th>ID</th><th>비번</th><th>나이</th><th>성별</th><th>주민번호</th>
		</tr>
		<c:forEach items="${list }" var="m3">
			<tr>
				<td>${m3.memberId }</td>
				<td>${m3.memberPw }</td>
				<td>${m3.age }</td>
				<td>${m3.sex }</td>
				<td>${m3.socialSecurityNum }</td>
			</tr>
		</c:forEach>
	</table>
	<a href="/">메인페이지로 가기</a>
</body>
</html>