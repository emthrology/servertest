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
	<c:choose>
		<c:when test="${param.num2 == 1 }">
			1을 입력함<br>
		</c:when>
		<c:when test="${param.num2 == 2 }">
			2을 입력함<br>
		</c:when>
		<c:when test="${param.num2 == 3 }">
			3을 입력함<br>
		</c:when>
		<%-- dafault : otherwise --%>
		<c:otherwise>
			잘못 입력함<br>
		</c:otherwise>
	</c:choose>
</body>
</html>