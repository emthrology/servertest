<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<h1>로그인 페이지</h1>
	<form action="/login" method="post">
		아이디<input type="text" name="memberId"><br>
		비밀번호<input type="password" name="memberPw"><br>
		<input type="submit" value="submit">
	</form>
	<a href="/">메인페이지로 돌아가기</a>
</body>
</html>