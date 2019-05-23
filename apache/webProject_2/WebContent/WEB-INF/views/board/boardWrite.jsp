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
		<div class="table-wrapper" style="text-align:center; width:80%; margin:0 auto;">
			<form action="/insertBoard" method="post" enctype="multipart/form-data">
				<table class="table table-bordered" style="text-align:left;">
					<tr>
						<th colspan="2" style="font-size:20px; font-weight:bold;">게시글 작성</th>
					</tr>
					<tr>
						<th>제목</th>
						<td><input type="text" class="form-control" name="boardTitle"></td>
					</tr>
					<tr>
						<th>카테고리</th>
						<td>
							<select name="category">
								<option value='뻘글'>뻘글</option>
								<option value='유머'>유머</option>
								<option value='진지'>진지</option>
								<option value='감동'>감동</option>
							</select>
						</td>
					</tr>
					<tr>
						<th>작성자</th>
						<td>
							<%=m.getMemberId() %>
							<input type="hidden" class="form-control" name="boardAuthor" value="<%=m.getMemberId() %>">
						</td>
					</tr>
					<tr>
						<th>같이 올릴 사진(1장)</th>
						<td><input type="file" name="filepath"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea name="boardContent" class="form-control" rows="3" cols="40"></textarea></td>
					</tr>
					<tr style="text-aign:center;">
						<th colspan="2">
							<button type="submit" class="btn btn-outline-primary">등록하기</button>
							<button type="button" class="btn btn-primary" onclick="back()">취소</button>
						</th>
					</tr>
				</table>
			</form>
		</div>
	</section>
	<script>
		function back() {
			if(confirm("작성을 취소하시겠습니까?")) {
				location.href="/boardList";
			}
		}
	</script>
</body>
</html>