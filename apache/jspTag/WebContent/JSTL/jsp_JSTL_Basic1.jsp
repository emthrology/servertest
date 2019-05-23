<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<h2>JSTL Core Tag 연습</h2>
	<hr>
	<c:set var="num1" value="10"/>
	<c:set var="num2" value="20"/>
	<p>결과 : ${num1 } + ${num2 } = ${num1+ num2 } </p>
	<hr>
	<!-- 변수에 스코프 지정 -->
	<c:set var="num" value="100" scope="request"/>
	<c:set var="num" value="100" scope="session"/>
	<p>request값 출럭 : ${requestScope.num }</p>
	<p>request값 출럭 : ${sessionScope.num }</p>
	
	<c:remove var="num" scope="request"/><!-- scope지정 안하면 다 지워짐 -->
	<hr>
	출력 <c:out value="100"/><br>
	기본출력(escape처리) : <c:out value="글씨를 진하게<b>1</b>태그 사용" escapeXml="false"/><br>
	기본출력(escape처리) : <c:out value="글씨를 진하게<b>1</b>태그 사용" escapeXml="true"/><br>
	
</body>
</html>