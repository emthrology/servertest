<%@page import="member1.model.vo.MemberPageData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#pageNavi{
		text-align:center;
		width:80%;
		margin:0 auto;
		
	}
	#pageNavi>*{
		margin: 10px;
	}
	.selectPage{
		font-size:18px;
		color:blue;
	}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	<section>
		<div style="margin:0 auto; width:500px; text-align:center;">
			<form action="/searchKeyword">
				<select name="type" class="form-control" style="display:inline-block; width:100px; height:30px; font-size:0.8em;">
					<option value="memberId">아이디</option>
					<option value="memberName">이름</option>
				</select>
				<input type="text" class="form-control" name="keyword" style="display:inline-block; width:200px; height:30px; font-size:0.8em;">
				<button type="submit" class="btn btn-outline-secondary btn-sm">조회</button>
			</form>
		</div>
		<table class="table table-hover" style="text-align:center; width:80%; margin:0 auto;">
			<tr>
				<th>ID</th><th>이름</th><th>나이</th><th>이메일</th><th>전화번호</th><th>주소</th><th>가입일</th><th>탈퇴버튼</th>
			</tr>
			<c:forEach items="${mpd.list }" var="m1">
				<tr>
					<td>${m1.memberId }</td>
					<td>${m1.memberName }</td>
					<td>${m1.age }</td>
					<td>${m1.email }</td>
					<td>${m1.phone }</td>
					<td>${m1.address }</td>
					<td>${m1.enrollDate }</td>
					<td><button class="btn btn-outline-info btn-sm" onclick="location.href='/deleteMember?memberId=${m1.memberId}'">탈퇴</button></td>
				</tr>
			</c:forEach>
		</table>
		<div id="pageNavi">
			${mpd.pageNavi }
		</div>
	</section>
	<script>
		$(function(){
			if(${smd.type eq 'memberId' }) {
				$('select option[value=memberId]').attr('selected');
			}else if(${smd.type eq 'memberName' }) {
				$('select option[value=memberName]').attr('selected');
			}
			if(${not empty smd.keyword}) {
				$('input').val('${smd.keyword}');
			}
		});
	</script>
</body>
</html>