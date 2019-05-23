<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="board.model.vo.Board" %>
    <%@ page import="board.model.vo.BoardViewData" %>
    <%@ page import="java.util.ArrayList" %>
    <%
    	BoardViewData bvd = (BoardViewData)request.getAttribute("bvd");
    	Board b = bvd.getB();
    	
    %>
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
			<table class="table table-bordered">
				<tr>
					<th colspan="2" style="font-size:20px; font-weight:bold;">자유제시판</th>
				</tr>
				<tr>
					<th>제목</th>
					<td><%=b.getBoardTitle() %></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><%=b.getBoardAuthor() %></td>
				</tr>
				<% if(b.getFilepath() != null) { %>
				<tr>
					<!-- 첨부파일형식이 아니라 같이 띄워줘야함  -->
					<td colspan="2">
						<img src="<%=b.getFilepath() %>" width="80%;">
					</td>
				</tr>
				<% } %>
				<tr>
					<th>내용</th>
					<td><%=b.getBoardContent().replaceAll("\r\n", "<br>") %></td><!-- 개행문자 변환 -->
				</tr>
				
				<tr>
					<th colspan="2">
						<a href="/boardUpdate?boardNo=<%=b.getBoardNo() %>" class="btn btn-outline-primary btn-sm">수정하기</a>
						<a href="/boardDelete?boardNo=<%=b.getBoardNo() %>" class="btn btn-outline-primary btn-sm">삭제하기</a><!-- 간단히 실습 과제임 -->
						<a href="/boardList" class="btn btn-outline-primary btn-sm">목록으로</a>
					</th>
				</tr>
				<tr>
					<th colspan="2">
						<a href="/boardView?boardNo=<%=b.getBoardNo() %> - 1" class="btn btn-outlineoprimary btn-sm">이전글 </a>
						<a href="/boardView?boardNo=<%=b.getBoardNo() %> + 1" class="btn btn-outlineoprimary btn-sm">다음글 </a>
					</th>
				</tr>
			</table>
		</div>
	</section>
</body>
</html>