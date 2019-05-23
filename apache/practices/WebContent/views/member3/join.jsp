<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<h1>member3회원가입</h1>
	<form action="/join3" method="post">
		아이디 : <input type="text" name="memberId"><br>
		비밀번호 : <input type="password" name="memberPw"><br>
		이름 : <input type="text" name="memberName"><br>
		주빈번호 : <input type="text" name="socialSecurityNum"><br>
		<input type="submit" value="submit"><input type="reset" value="reset">
	</form>
	<a href="/">메인페이지로 돌아가기</a>
</body>
</html>