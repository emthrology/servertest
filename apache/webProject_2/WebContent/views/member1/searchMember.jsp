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
		<section id="searchIdSection" style="width:900px; margin-left:10%; float:left;">
			<div style="width:300px; height:400px; float:left;">
				<form action="/searchId" method="post" id = "searchId">
					<h2>아이디 찾기</h2>
					<span>이름과 전화번호를 입력하세요.</span>
					<ul>
						<li><label for="memberName">이름</label></li>
						<li><input type="text" name="memberName" id="memberName" class="form-control"></li>
						<li><label for="phone">전화번호</label></li>
						<li><input type="text" name="phone" id="phone" class="form-control"></li>
						<li id="btn-wrapper">
							<br>
							<button class="btn btn-outline-danger btn-lg" type="submit">찾기</button>
							<button class="btn btn-outline-danger btn-lg" type="reset">초기화</button>
							
					</ul>
				</form>
			</div>
			<div style="width:300px; height:400px; float:left; margin-left:10%;">
				<form action="/searchPw" method="post" id = "searchId">
					<h2>비밀번호찾기</h2>
					<span>아이디와 이메일을 입력하세요.</span>
					<ul>
						<li><label for="memberId">아이디</label></li>
						<li><input type="text" name="memberId" id="memberId" class="form-control"></li>
						<li><label for="email">이메일</label></li>
						<li><input type="text" name="email" id="email" class="form-control"></li>
						<li id="btn-wrapper">
							<br>
							<button class="btn btn-outline-danger btn-lg" type="submit">찾기</button>
							<button class="btn btn-outline-danger btn-lg" type="reset">초기화</button>
							
					</ul>
				</form>
			</div>
			
		</section>
		
	
</body>
</html>