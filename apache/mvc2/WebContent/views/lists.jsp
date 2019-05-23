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

</body>
</html>