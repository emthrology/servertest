<%@page import="member1.model.vo.MemberPageData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="member1.model.vo.Member" %>
    <%@ page import="member1.model.vo.MemberPageData" %>
    <%
    	/* AdminPageServlet이나 SearchKeywordServlet에서 결과값을 받아오는 코드  */
    	MemberPageData mpd = (MemberPageData)request.getAttribute("mpd");
    	ArrayList<Member> list = mpd.getList();
    %>

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
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
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
			<% for(Member m1 : list) { %>
				<tr>
					<td><%=m1.getMemberId() %></td>
					<td><%=m1.getMemberName() %></td>
					<td><%=m1.getAge() %></td>
					<td><%=m1.getEmail() %></td>
					<td><%=m1.getPhone() %></td>
					<td><%=m1.getAddress() %></td>
					<td><%=m1.getEnrollDate() %></td>
					<td><button class="btn btn-outlin-info btn-sm"  onclick="location.href='/deleteMember?memberId=<%=m1.getMemberId() %>'">탈퇴</button></td>
				</tr>
			<% } %>
		</table>
		<div id="pageNavi">
			<%= mpd.getPageNavi() %>
		</div>
	</section>
</body>
</html>