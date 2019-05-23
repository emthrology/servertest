<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="notice.model.vo.Notice"%>
    <%
    	Notice n = (Notice)request.getAttribute("notice");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type=text/javascript src="/js/jquery-3.3.1.js"></script>
	<script>
		$(document).ready(function(){
			$("#fileDelBtn").click(function(){
				if(confirm("sure?")){
					$(".delFile").hide();
					$("#file").show();
					$("#status").val('delete');
				}
			});
			
		});
	</script>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<section>
		<form action="/noticeUpdateEnd" method="post" enctype="multipart/form-data">
			<div class="table-wrapper" style="text-align:center; width:80%; margin:0 auto;">
				<input type="hidden" name="noticeNo" value="<%=n.getNoticeNo() %>">
				<table class="table table-bordered">	
					<tr>
						<th colspan="2" style="font-size:20px; font-weight:bold;">공지사항</th>
					</tr>
					<tr>
						<th>제목</th>
						<td><input type="text" class="form-control" name="noticeTitle" value="<%=n.getNoticeTitle() %>"></td>
					</tr>
					<tr>
						<th>작성자</th>
						<td><%=n.getNoticeAuthor() %></td>
					</tr>
					<tr>
						<th>첨부파일</th>
						<td>
							<input type="hidden" id="status" name="status" value="stay"><!-- 파일을 삭제할 것인지 구분하는 hidden input (value == "stay"||"delete") -->
							<% if(n.getFilepath() != null) { %>
								<input type="hidden" name="oldFilename" value="<%=n.getFilename() %>">
								<input type="hidden" name="oldFilepath" value="<%=n.getFilepath() %>">
								<img class="delFile" src="/img/file.png" width="16px">
								<input type="file" name="filename" id="file" style="display:none;">
								<span class="delFile"><%=n.getFilename() %></span>
								<button type="button" id="fileDelBtn" class="btn btn-primary btn-sm delFile">삭제</button>
							<% } else { //첨부파일이 없는 경우: 파일 입력 input을 만들어준다 %>
								<input type="file" name="filename">
							<% } %>
						</td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea name="noticeContent" class="form-control" rows="3"><%=n.getNoticeContent() %></textarea></td>
					</tr>
					<tr>
						<th colspan="2">
							<button type="submit" class="btn btn-outline-primary">수정하기</button>
						</th>
					</tr>
				</table>
			</div>
		</form>
	</section>
</body>
</html>