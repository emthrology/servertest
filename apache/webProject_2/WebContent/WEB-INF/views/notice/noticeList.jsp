<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%-- <%@ page import = "notice.model.vo.Notice" %>
    <%@ page import = "java.util.ArrayList" %>
    <%@ page import = "notice.model.vo.NoticePageData" %>
    <%
    	/* Servlets에서 결과값을 받아오는 코드  */
    	NoticePageData npd = (NoticePageData)request.getAttribute("npd");
    	ArrayList<Notice> list = npd.getList();
    %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	<section>
		<div class="table-wrapper" style="text-align:center; width:80%; margin:0 auto;">
			<div class="button-wrapper" style="text-align:right;">
				<a class="btn btn-outline-primary btn-sm" style="display:none;" href="/noticeWrite">글쓰기</a>
			</div>
			<table class="table table-striped">
				<tr>
					<th colspan="4" style="font-size:20px; font-weight:bold">공지사항 목록</th>
				</tr>
				<tr>
					<th>번호</th><th>제목</th><th>작성자</th><th>작성일</th>
				</tr>
				<c:forEach items="${npd.list }" var="n">
					<tr>
						<td>${n.noticeNo }</td>
						<td><a href="/noticeView?noticeNo=${n.noticeNo }">${n.noticeTitle }</a></td>
						<td>${n.noticeAuthor }</td>
						<td>${n.noticeDate }</td>
					</tr>
				</c:forEach>
			</table>
			<div id="pageNavi">
				${npd.pageNavi }
			</div>
		</div>
	</section>
	<script>
		$(function(){
			if(${sessionScope.member1.memberId eq 'admin'}) {
				$('.button-wrapper a').css('display','inline');
			}
		});
	</script>
</body>
</html>