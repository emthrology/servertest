<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입페이지</h1>
	<form action="/join2" method="post">
		아이디 : <input type="text" name="memberId"><br>
		비밀번호 : <input type="password" name="memberPw"><br>
		생년월일 : <input type="text" name="birthday"><br>
		<input type="submit" value="submit"><input type="reset" value="reset"><br>
	</form>
	<a href="/">메인페이지로</a>
</body>
</html>