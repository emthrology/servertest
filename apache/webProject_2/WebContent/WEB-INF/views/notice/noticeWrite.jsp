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
			<form action="/insertNotice" method="post" enctype="multipart/form-data">
				<table class="table table-bordered" style="text-align:left;">
					<tr>
						<th colspan="2" style="font-size:20px; font-weight:bold;">공지사항작성</th>
					</tr>
					<tr>
						<th>제목</th>
						<td><input type="text" class="form-control" name="noticeTitle"></td>
					</tr>
					<tr>
						<th>작성자</th>
						<td>
							<%=m.getMemberId() %>
							<input type="hidden" class="form-control" name="noticeAuthor" value="<%=m.getMemberId() %>">
						</td>
					</tr>
					<tr>
						<th>첨부파일</th>
						<td><input type="file" name="filename"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea name="noticeContent" class="form-control" rows="3" cols="40"></textarea></td>
					</tr>
					<tr style="text-aign:center;">
						<th colspan="2">
							<button type="submit" class="btn btn-outline-primary">등록하기</button>
						</th>
					</tr>
				</table>
			</form>
		</div>
	</section>
</body>
</html>