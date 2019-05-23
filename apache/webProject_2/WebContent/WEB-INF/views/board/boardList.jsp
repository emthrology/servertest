<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "board.model.vo.Board" %>
    <%@ page import = "java.util.ArrayList" %>
    <%@ page import = "board.model.vo.BoardPageData" %>
    <%
    	BoardPageData bpd = (BoardPageData)request.getAttribute("bpd");
    	ArrayList<Board> list = bpd.getList();
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
			<div style="text-align:left;">
				<a class="btn btn-outline-primary btn-sm" href="/boardWrite">글쓰기 </a>
			</div>
			<table class="table table-striped">
				<tr>
					<th colspan="6" style="font-size:20px; font-weight:bold;">자유게시판 목록</th>
				</tr>
				<tr>
					<th>번호</th><th>카테고리</th><th>제목</th><th>작성자</th><th>조회수</th><th>작성일</th>
				</tr>
				<% for(Board b : list) { %>
				<tr>
					<td><%=b.getBoardNo() %></td>
					<td><%=b.getCategory() %></td>
					<td><a href="/boardView?boardNo=<%=b.getBoardNo() %>"><%=b.getBoardTitle() %></a></td>
					<td><%=b.getBoardAuthor() %></td>
					<td><%=b.getViewcount() %></td>
					<td><%=b.getBoardDate() %></td>
				</tr>
				<% } %>
			</table>
			<div id="pageNavi">
				<%=bpd.getPageNavi() %>
			</div>
		</div>	
	</section>
</body>
</html>