<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<section>
		<div class="container" style="color:black;">
			<h3>1.AJAX 서버에 전송값 보내기</h3>
			<p>버튼 선택시 전송값을 서버에 출력하기</p>
			<input type="text" class="form-control" id="msg1" placeholder="메시지 입력">
			<button class="btn btn-primary" onclick="jsFunction();">보내기(JS)</button>
			<h3>2.Jquery 방식으로 서버에 보내기</h3>
			<button class="btn btn-primary" id="jQ1">보내기(JQuery)</button>
			<hr>
			<h3>2.버튼 클릭 시 서버에서 보낸 값 사용자가 수신</h3>
			<button class="btn btn-primary" id="jQ2">서버에서 보낸 값 받기</button>
			<p id="p2" class="border border-danger"></p>
			<h3>3.서버로 기본형 전송값 보내고,결과값 받기</h3>
			첫번째 숫자 : <input type="text" id="firstValue">
			두번째 숫자 : <input type="text" id="secondValue">
			<button id="jQ3">주고받기</button>
			<p id="p3" class="border border-danger"></p>
			<hr>
			<h3>4.서버로 Object형 전송값 보내고, 결과 처리</h3>
			이름 : <input type="text" id="studentName"><br>
			나이 : <input type="text" id="studentAge"><br>
			주소 : <input type="text" id="studentAddr"><br>
			이클립스 콘솔에서 확인
			<button class="btn btn-primary" id="jQ4">Object 주기</button>
			<hr>
			<h3>5.서버로 기본값 보내고 결과로 객체 받아서 처리</h3>
			<p>유저 번호를 넘겨주고, 해당하는 유저 정보 받기</p>
			유저 번호 입력 : <input type="text" id="userNum"><br>
			<button class="btn btn-primary" id="jQ5">실행</button>
			<p id="p5" class="border border-danger"></p>
			<h3>6.서버로 기본형 전송값 보내고, 결과로 리스트 객체 받아서처리</h3>
			<p>JSON사용</p>
			<p>유저번호를 입력받아 해당 유저번호 가져오기 -> 없는 경우 전체 리스트 가져오기</p>
			유저번호 입력 : <input type = "text" id="userNum2"><br>
			<button class="btn btn-primary" id="jQ6">실행</button>
			<p id="p6" class="border border-danger"></p>
			<hr>
			<h3>7.서버로 기본형 전송값 여러개 보내고, 결과로 리스트 객체 받아서처리</h3>
			<p>JSON사용</p>
			<p>유저번호를 입력받아 해당 유저번호 가져오기 -> 없는 경우 전체 리스트 가져오기</p>
			유저번호 입력(숫자,숫자,숫자)(','기준으로 구분) : <input type = "text" id="userNum3"><br>
			<button class="btn btn-primary" id="jQ7">실행</button>
			<p id="p7" class="border border-danger"></p>
			<hr>
			<h3>8.서버로 기본형 전송값 여러개 보내고, 결과로 Map 객체 받아서처리</h3>
			<p>JSON사용</p>
			<p>유저번호를 입력받아 해당 유저번호 가져오기 -> 없는 경우 전체 Map 가져오기</p>
			유저번호 입력(숫자,숫자,숫자)(','기준으로 구분) : <input type = "text" id="userNum4"><br>
			<button class="btn btn-primary" id="jQ8">실행</button>
			<p id="p8" class="border border-danger"></p>
			<hr>
			<h3>9.서버유저정보로 표 구성</h3>
			<p>JSON사용</p>
			<p>현재 유저 정보를 받아 테이블에 뿌린다</p>
			<button class="btn btn-primary" id="jQ9">실행</button>
			<table id="userTbl" class="table">
				<thead>
					<tr>
						<th>번호</th>
						<th>이름</th>
						<th>주소</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
			<hr>
			<h3>10.서버에서 리스트 받아 select로 표현</h3>
			<p>입력한 유저를 선택한 상태의 select 구현</p>
			유저 이름 : <input type="text" id="userName10"><br>
			<button class="btn btn-primary" id="jQ10">실행</button>
			<select id="select10"></select>
			<hr>
			<h3>11.서버에서 리스트 받아 select로 표현</h3>
			<p>GSON사용</p>
			<p>입력한 유저를 선택한 상태의 select 구현</p>
			유저 이름 : <input type="text" id="userName11"><br>
			<button class="btn btn-primary" id="jQ11">실행</button>
			<select id="select11"></select>
			<hr>
			<h3>12.서버에서 리스트 받아 map으로 표현</h3>
			<p>GSON사용</p>
			<p>입력한 유저를 선택한 상태의 select 구현</p>
			유저 이름 : <input type="text" id="userName12"><br>
			<button class="btn btn-primary" id="jQ12">실행</button>
			<select id="select12"></select>
		</div>
	</section>
	<script>
		function jsFunction(){
			//1.XMLHttpRequest 인스턴스 생성
			var xhr = new XMLHttpRequest();
			var msg = document.getElementById("msg1").value;
			//2.요청정보설정
			xhr.open("GET","/ajaxTest1.do?msg="+msg,true);
			//3.데이터 처리에 따라 동작할 함수 설정
			xhr.onreadystatechange = function() {
				if(this.readyState==4 && this.status==200) {
					console.log("전송 완료");
				} else {
					console.log("전송 중");
				}
			}
			//4.서버에 요청
			xhr.send();
		}
		
		$("#jQ1").click(function(){
			var msg = $("#msg1").val();
			$.ajax({
				url : "/ajaxTest1.do",
				data : {msg : msg},
				type : "get",
				success : function(){
					console.log("서버 전송 완료");
				},
				error : function(){
					console.log("서버 전송 실패");
				},
				complete : function(){
					console.log("finally블록같은곳")
				}
			});
		});
		
		$("#jQ2").click(function(){
			$.ajax({
				url : "/ajaxTest2.do",
				type : "get",
				success : function(data) {
					$("#p2").html(data);
				},
				error : function() {
					console.log("실패");
				}
			});
		});
		
		$("#jQ3").click(function(){
			var fstVal = $("#firstValue").val();
			var secVal = $("#secondValue").val();
			$.ajax({
				url : "/ajaxTest3.do",
				type : "get",
				data : {firstValue : fstVal, secondValue : secVal},
				success : function(data) {
					$("#p3").html(data);
				},
				error : function() {
					console.log("전송 실패");
				}
			});
		});
		
		$("#jQ4").click(function(){
			var studentName = $("#studentName").val();
			var studentAge = $("#studentAge").val();
			var studentAddr = $("#studentAddr").val();
			//객체 생성
			var student = {
				studentName:studentName, 
				studentAge:studentAge, 
				studentAddr:studentAddr
			};
			$.ajax({
				url : "/ajaxTest4.do",
				type : "get",
				data : student,
				success : function() {
					console.log("전송 성공");
				},
				error : function() {
					console.log("전송 실패");
				}
			});
		});
		
		$("#jQ5").click(function(){
			var userNum = $("#userNum").val();
			$.ajax({
				url : "/ajaxTest5.do",
				type : "get",
				data : {userNum : userNum},
				success : function(data) {
					var userNo = data.userNo;
					var userName = decodeURIComponent(data.userName);
					var userAddr = decodeURIComponent(data.userAddr);
					$("#p5").html("유저 번호 : "+userNo+"<br>유저 이름 : "+userName+"<br>유저 주소 : "+userAddr);
				}, 
				error : function() {
					console.log("전송 실패");
				}
			});
		});
		
		$("#jQ6").click(function(){
			var userNum = $("#userNum2").val();
			$.ajax({
				url : "/ajaxTest6.do",
				type : "get",
				data : {userNum:userNum},
				success : function(data){ /* JS에서 list는 array처럼 취급된다 */
					var resultText="";
					for(var i=0; i<data.length; i++){
						var userNo = data[i].userNo;
						var userName = decodeURIComponent(data[i].userName);
						var userAddr =  decodeURIComponent(data[i].userAddr);
						resultText += "유저번호 : "+userNo+"/유저이름 : "+userName+"/유저주소 : "+userAddr+"<br>";
					}
					$("#p6").html(resultText);
				},
				error : function(){
					console.log("아무튼 실패");
				}
			});
		});
		
		$("#jQ7").click(function(){
			var userNum = $("#userNum3").val();
			$.ajax({
				url : "/ajaxTest7.do",
				type : "get",
				data : {userNum:userNum},
				success : function(data){ /* JS에서 list는 array처럼 취급된다 */
					var resultText="";
					for(var i=0; i<data.length; i++){
						var userNo = data[i].userNo;
						var userName = decodeURIComponent(data[i].userName);
						var userAddr =  decodeURIComponent(data[i].userAddr);
						resultText += "유저번호 : "+userNo+"/유저이름 : "+userName+"/유저주소 : "+userAddr+"<br>";
					}
					$("#p7").html(resultText);
				},
				error : function(){
					console.log("아무튼 실패");
				}
			});	
		});
		
		$("#jQ8").click(function(){
			var userNum = $("#userNum4").val();
			$.ajax({
				url : "/ajaxTest8.do",
				type : "get",
				data : {userNum:userNum},
				success : function(data){ /* JS에서 list는 array처럼 취급된다 */
					var resultText="";
					var keys = Object.keys(data); /* JS 객체는 기본적으로 map이기 때문에 이 메소드를 사용하면 객체의 key들을 모아 객체로 만들어 인덱싱에 활용할 수 있다 */
					for(var i=0; i<keys.length; i++){
						var userNo = data[keys[i]].userNo;
						var userName = decodeURIComponent(data[keys[i]].userName);
						var userAddr =  decodeURIComponent(data[keys[i]].userAddr);
						resultText += "유저번호 : "+userNo+"/유저이름 : "+userName+"/유저주소 : "+userAddr+"<br>";
					}
					$("#p8").html(resultText);
				},
				error : function(){
					console.log("아무튼 실패");
				}
			});	
		});
		
		$("#jQ9").click(function(){
			$.ajax({
				url : "/ajaxTest9.do",
				type : "get",
				success : function(data) {
					var $tbody = $("#userTbl tbody");
					for(var i=0; i<data.length; i++) {
						var $tr = $("<tr>");
						var $td = $("<td>");
						var $noTd = $("<td>").html(data[i].userNo);
						var $nameTd = $("<td>").html(decodeURIComponent(data[i].userName));
						var $addrTd = $("<td>").html(decodeURIComponent(data[i].userAddr));
						$tr.append($noTd).append($nameTd).append($addrTd);
						$tbody.append($tr);
					}
				},
				error : function(){
					console.log("아무튼 실패");
				}
			});	
		});
		
		$("#jQ10").click(function(){
			var selectName = $("#userName10").val();
			$.ajax({
				url : "/ajaxTest9.do",
				type : "get",
				success : function(data) {
					var $select = $("#select10");
					$select.find("option").remove(); /* 버튼 누를 때마다 추가되는걸 방지하기 위해 초기화 */
					for(var i=0; i<data.length; i++){
						var userNo = data[i].userNo;
						var userName = decodeURIComponent(data[i].userName);
						var userAddr = decodeURIComponent(data[i].userAddr);
						var selected = "";
						if(userName == selectName){ /* 자바 아님 */
							var selected = "selected";
						}
						$select.append("<option value='"+userNo+"' "+selected+">"+userName+"</option>");
					}
				},
				error : function() {
					console.log("아무튼 실패");
				}
			});
		});
		
		$("#jQ11").click(function(){
			var selectName = $("#userName11").val();
			$.ajax({
				url : "/ajaxTest11.do",
				type : "get",
				success : function(data) {
					var $select = $("#select11");
					$select.find("option").remove(); /* 버튼 누를 때마다 추가되는걸 방지하기 위해 초기화 */
					for(var i=0; i<data.length; i++){
						var userNo = data[i].userNo;
						var userName = data[i].userName; /* GSON은 인코딩자료도 알아서 디코딩해준다; decodeURIComponent 필요 없음 */
						var userAddr = data[i].userAddr;
						var selected = "";
						if(userName == selectName){ /* 자바 아님 */
							var selected = "selected";
						}
						$select.append("<option value='"+userNo+"' "+selected+">"+userName+"</option>");
					}
				},
				error : function() {
					console.log("아무튼 실패");
				}
			});
		});
		
		$("#jQ12").click(function(){
			var selectName = $("#userName12").val();
			$.ajax({
				url : "/ajaxTest12.do",
				type : "get",
				success : function(data) {
					var $select = $("#select12");
					$select.find("option").remove(); /* 버튼 누를 때마다 추가되는걸 방지하기 위해 초기화 */
					for(var key in data){ /* key에 하나씩 접근해 데이터를 꺼내옴 */
						var userNo = data[key].userNo;
						var userName = data[key].userName; /* GSON은 인코딩자료도 알아서 디코딩해준다; decodeURIComponent 필요 없음 */
						var userAddr = data[key].userAddr;
						var selected = "";
						if(userName == selectName){ /* 자바 아님 */
							var selected = "selected";
						}
						$select.append("<option value='"+userNo+"' "+selected+">"+userName+"</option>");
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