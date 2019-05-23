<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="/js/member/join.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	<section>
		<div id="container" style="margin:0 auto; width:80%; color:black; text-align:center">
			<form name="checkIdFrm">
				<input type="hidden" name="checkId">
			</form>
			<form action="/join" method="post" id="memberJoin">
				<h1>회원가입</h1>
				<table class="table">
					<tr>
						<th><label for="memberId">아이디</label></th>
						<td><input type="text" name="memberId" id="memberId" class="form-control"></td>
						<td style="width:150px;"><button type="button" class="btn btn-primary" onclick="checkId()">중복체크</button></td> <!-- button태그의 타입을 설정안하면 submit으로 작동한다 -->
						<td style="width:150px;"><span id="chkMsg"></span>
					</tr>
					<tr>
						<th><label for="memberPw">비밀번호</label></th>
						<td><input type="password" name="memberPw" id="memberPw" class="form-control"></td>
						<td style="width:150px;"></td>
					</tr>
					<tr>
						<th><label for="pwChk">비밀번호확인</label></th>
						<td><input type="password" id="pwChk" class="form-control"></td>
						<td style="width:150px;"></td>
					</tr>
					<tr>
						<th><label for="memberName">이름</label></th>
						<td><input type="text" name="memberName" id="memberName" class="form-control"></td>
						<td style="width:150px;"></td>
					</tr>
					<tr>
						<th><label for="age">나이</label></th>
						<td><input type="text" name="age" id="age" class="form-control"></td>
						<td style="width:150px;"></td>
					</tr>
					<tr>
						<th><label for="email">이메일</label></th>
						<td><input type="text" name="email" id="email" class="form-control"></td>
						<td style="width:150px;"></td>
					</tr>
					<tr>
						<th><label for="phone">휴대폰번호</label></th>
						<td><input type="text" name="phone" id="phone" class="form-control"></td>
						<td style="width:150px;"></td>
					</tr>
					<tr>
						<th><label for="address">주소</label></th>
						<td><input type="text" name="address" id="address" class="form-control"></td>
						<td style="width:150px;"></td>
					</tr>
				</table>
				<hr>
				<div id="btn-box">
					<button class="btn btn-warning byn-lg" type="submit">회원가입</button>
					<button class="btn btn-success byn-lg" type="reset">초기화</button>
				</div>
			</form>
		</div>
	</section>
	<script>
		$("#memberId").keyup(function(){
			var memberId = $("#memberId").val();
			$.ajax({
				url : "/ajaxCheckId.do",
				type : "get",
				data : {memberId:memberId},
				success : function(data) {
					var $msg = $("#chkMsg");
					if(data == 0) {
						$msg.html("사용 가능한 아이디");
						$msg.css('color','green');
					} else {
						$msg.html("이미 사용중인 아이디");
						$msg.css('color','red');
					}
				},
				error : function() {
					console.log("아무튼 실패");
				}
			});
		});
	</script>
</body>
</html>