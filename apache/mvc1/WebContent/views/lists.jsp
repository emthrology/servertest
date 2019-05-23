<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "java.util.ArrayList" %>
    
    <%@ page import = "member.model.vo.Member" %>
    <%@ page import = "member.model.service.MemberService" %>
    
    <%
    	//1.인코딩
    	request.setCharacterEncoding("utf-8");
    	//2.변수저장(생략)
    	//3.비즈니스 로직
    	ArrayList<Member> members = new MemberService().printAll();
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		if(!members.isEmpty()){
	%>		
			<caption>회원전체목록</caption>
			<table border="1" style="border-collapse: collapse;">
				<tr>
					<th>번호</th>
		            <th>아이디</th>
		            <th>이름</th>
		            <th>전화번호</th>
		            <th>취미</th>
				</tr>
				<%for(int i = 0; i<members.size(); i++){ %>
					<tr>
						<th><%= (i+1) %> </th>
						<td><%= members.get(i).getMemberId() %></td>
						<td><%= members.get(i).getMemberName() %></td>
						<td><%= members.get(i).getPhone() %></td>
						<td><%= members.get(i).getHobby() %></td>
					</tr>
				<% } %>
			</table>
			<a href="/index.html">메인페이지로 가기</a>
	<% } %>
 
</body>
</html>