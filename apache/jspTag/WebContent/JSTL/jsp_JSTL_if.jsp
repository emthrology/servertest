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
	
		<c:if test="${param.num1%2 == 0 }" var="result1">
			짝수입니다<br>
		</c:if>
		<c:if test="${param.num1%2 == 1 }" var="result2">
			홀수입니다<br>
		</c:if>	
		짝수판별 if 결과 : ${result1 }<br>
		홀수판별 if 결과 : ${result2 }
				
</body>
</html>