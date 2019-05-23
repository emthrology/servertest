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
		<div class="table-wrapper" style="text-align: center; margin: 0 auto;">
			<form action="/insertPhoto" method="post" enctype="multipart/form-data">
				<table class="table table-bordered">
					<tr>
						<th colspan="2" style="font-size: 20px; font-weight: bold;">글 올리기 - 사진 게시판</th>
					</tr>
					<tr>
						<th>작성자</th>
						<td>
							<%=m.getMemberId() %>
							<input type="hidden" name="photoAuthor" value="<%=m.getMemberId() %>">
						</td>
					</tr>
					<tr>
						<th>첨부파일</th>
						<td>
							<input type="file" name="filename" onchange="loadImg(this)"> <!-- 파일 올리면 올리기 전에 이미지 확인할 수 있는 이벤트로 변경 -->
						</td>
					</tr>
					<tr>
						<th>이미지 보기</th>
						<td>
							<div id="img-viewer">
								<img id="img-view" width="350">
							</div>
						</td>
					</tr>
					<tr>
						<th>내용</th>
						<td>
							<textarea rows="3" class="form-control" name="photoContent"></textarea>
						</td>
					</tr>
					<tr>
						<th colspan="2">
							<button type="submit" class="btn btn-outline-primary">제출</button>
							<button type="button" class="btn btn-primary" onclick="back()">취소</button>
						</th>
					</tr>
				</table>
			</form>	
		</div>
	</section>
	<script>
		function loadImg(f) {
			/* f.files : 선택한 파일을 지정, 기본적으로 멀티업로드를 가정하기에 배열 형태로 가져온다 */
			if(f.files.length != 0 && f.files[0] != 0) { /* 배열 길이가 0이 아니고 배열의 0번째의 값이 0이 아닐 때 */
				var reader = new FileReader(); /* JS의 파일리더 인스턴스 : 인스턴스 내부의 result 속성에 파일 컨텐츠가 들어있음 */
				reader.readAsDataURL(f.files[0]); /* 선택한 파일의 경로를 읽어옴, 읽기가 완료되면 자동으로 onload이벤트가 발생함*/
				reader.onload = function(e) {
					$("#img-view").attr('src',e.target.result);
				}
			} else {
				$("#img-view").attr('src','');
			}
		}
		function back() {
			location.href="/photoList";
		}
	</script>
</body>
</html>