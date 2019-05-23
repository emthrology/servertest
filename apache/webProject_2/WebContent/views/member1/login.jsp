<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/member1/login.css">
<script type="text/javascript" src="/js/jquery-3.3.1.js"></script>
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<section>
		<form action="/login" method="post" id="login-box">
			<h1>로그인</h1>
			<ul>
				<li><label for="memberId">아이디</label></li>
				<li><input type="text" name="memberId" id="memberId" class="form-control"></li>
				<li><label for="memberPw">비밀번호</label></li>
				<li><input type="password" name="memberPw" id="memberPw" class="form-control"></li>
				<li id="btn-wrapper">
					<br>
					<button class="btn btn-outline-danger btn-lg" type="submit">로그인</button>
					<button class="btn btn-outline-danger btn-lg" type="reset">초기화</button>
					<br><br>
					<a href="/views/member1/searchMember.jsp">아이디/비밀번호 찾기</a>
				</li>
			</ul>
		</form>
	</section>
</body>
</html>