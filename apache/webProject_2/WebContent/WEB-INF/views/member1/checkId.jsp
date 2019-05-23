<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	//결과
    	boolean result = (Boolean)request.getAttribute("result");
    	String checkId = (String)request.getAttribute("checkId");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style type="text/css">
		#checked-container{
			text-align: center;
			padding-top: 50px;
		}
		#checked{
			color: red;
			font-weight: bold;
		}
	</style>
</head>
<body>
	<script>
		function setMemberId(memberId){
			var id = opener.document.getElementById("memberId"); //opener는 이 창을 연 객체를 의미
			var pw = opener.document.getElementById("memberPw");
			id.value = memberId;//메인 창의 input에 id값 넣고
			pw.focus();//비밀번호 input에 포커스
			self.close();//자기자신의 창 닫기
		}
	</script>
	<div id="checked-container">
		<% if(result) { %>
			[<span><%=checkId %></span>]는 사용 가능합니다.<br><br>
			<button type="button" onclick="setMemberId('<%=checkId%>');">닫기</button>
		<% }else{ %>
			[<span id="checked"><%=checkId %></span>]는 이미 사용중입니다<br><br>
			<!-- 새 창에서 바로 다시 입력 가능하게 세팅 -->
			<form action="/checkId" method="post">
				<input type="text" name="checkId" placeholder="아이디를 입력하세요"><br>
				<button type="submit">중복검사</button> 
			</form>
		<% } %>
	</div>
</body>
</html>