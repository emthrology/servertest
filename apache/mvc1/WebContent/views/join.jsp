<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "member.model.vo.Member" %>
    <%@ page import = "member.model.service.MemberService" %>
    <%
    	//1.인코딩
    	request.setCharacterEncoding("utf-8");
    	//2.보내준 변수 저장
    	String id = request.getParameter("id");
    	String pw = request.getParameter("pw");
    	String name = request.getParameter("name");
    	String gender = request.getParameter("gender");
    	int age = Integer.parseInt(request.getParameter("age"));
    	String email = request.getParameter("email");
    	String phone = request.getParameter("phone");
    	String address = request.getParameter("address");
    	String hobby = request.getParameter("hobby");
    	//3.비즈니스 로직
    	int result = new MemberService().join(id, pw, name, gender, age, email, phone, address, hobby);
    	//4. 처리결과 보내기(html본문에 씀)
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		if(result>0) {
	%>
		<script>
			alert("회원가입 완료");
			location.href="/index.html";
		</script>
	<%
		}else {
	%>
		<script>
			alert("회원가입 실패");
			location.href="/index.html";
		</script>
	<%
		}
	%>
</body>
</html>