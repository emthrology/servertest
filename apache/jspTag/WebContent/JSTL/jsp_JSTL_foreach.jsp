<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="test.model.vo.Member" %>
    <%
    	ArrayList<Member> list = new ArrayList<Member>();
    	list.add(new Member("id1","pw1","이름1"));
    	list.add(new Member("id2","pw2","이름2"));
    	list.add(new Member("id3","pw3","이름3"));
    	request.setAttribute("list", list);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<table border="1" style="border-collapse: collapse">
		<tr><th>순번</th><th>아이디</th><th>비밀번호</th><th>이름</th></tr>
		<c:forEach items="${list }" var="m" varStatus="i">
		<tr>
			<td>${i.count }</td>
			<td>${m.id }</td>
			<td>${m.pw }</td>
			<td>${m.name }</td>
		</tr>	
		</c:forEach>
	</table>
</body>
</html>