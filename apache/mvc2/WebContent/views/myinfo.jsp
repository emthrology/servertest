<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "member.model.vo.Member" %>
    <%@ page import = "member.model.service.MemberService" %>
    <%
    	//1.인코딩
    	request.setCharacterEncoding("utf-8");
    	//2.변수 받아오기(세션으로부터 불러오기)
    	Member m = (Member)session.getAttribute("member");
    	//3.비지니스 로직(생략-안씀)
    	//4.처리 결과? -->html에 body에 쓰기
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개인정보 확인 및 수정</title>
</head>
<body>
	<h1>니 정보</h1>
	<form action="/views/update.jsp" method="post">
		<p>비밀번호 : <input type='password' name='memberPwd' value ="<%= m.getMemberPwd() %>"></p>
		<p>이메일 : <input type='text' name='email' value ="<%= m.getEmail() %>"></p>
		<p>휴대폰 : <input type='text' name='phone' value ="<%= m.getPhone() %>"></p>
		<p>주소 : <input type='text' name='address' value ="<%= m.getAddress() %>"></p>
		<p>취미 : <input type='text' name='hobby' value ="<%= m.getHobby() %>"></p>
		<p>가입일 : <%= m.getEnrollDate() %></p>
		<input type='submit' value='수정하기'>
	</form>
	<a href="/index.html">메인페이지로 가기</a>
</body>
</html>