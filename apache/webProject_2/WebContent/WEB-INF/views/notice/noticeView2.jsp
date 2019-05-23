<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="notice.model.vo.Notice"%>
    <%@ page import="notice.model.vo.NoticeViewData" %>
    <%@ page import="notice.model.vo.NoticeComment" %>
    <%@ page import="notice.model.vo.Notice" %>
    <%@ page import="java.util.ArrayList" %>
    <%
    	/* NoticeViewServlet에서 받아온 객체  */
    	NoticeViewData nvd = (NoticeViewData)request.getAttribute("nvd");
    	Notice n = nvd.getN();
    	ArrayList<NoticeComment> list = nvd.getList();
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
					<th colspan="2" style="font-size:20px; font-weight:bold;">공지사항</th>
				</tr>
				<tr>
					<th>제목</th>
					<td><%=n.getNoticeTitle() %></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><%=n.getNoticeAuthor() %></td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td>
						<% if(n.getFilepath() != null) { %>
							<img src="/img/file.png" width="16px">
							<!-- <a href="/noticeFileDownload?filename=<%-- <%=n.getFilename() %> --%>&filepath=<%-- <%=n.getFilepath() %> --%>"> --> 
							<a href="javascript:fileDownload('<%=n.getFilename() %>','<%=n.getFilepath() %>');">
								<%=n.getFilename() %>
							</a>
						<% } %>
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td><%=n.getNoticeContent().replaceAll("\r\n", "<br>") %></td><!-- 개행문자 변환 -->
				</tr>
				<tr>
					<th colspan="2">
						<a href="/noticeUpdate?noticeNo=<%=n.getNoticeNo() %>" class="btn btn-outline-primary btn-sm">수정하기</a>
						<a href="/noticeDelete?noticeNo=<%=n.getNoticeNo() %>" class="btn btn-outline-primary btn-sm">삭제하기</a><!-- 간단히 실습 과제임 -->
						<a href="/noticeList" class="btn btn-outline-primary btn-sm">목록으로</a>
					</th>
				</tr>
			</table>
		</div>
		<!-- 댓글 -->
		<!-- 댓글 쓰기  -->
		<% if(m!=null) { %>
			<div class="comment-write" style="text-align:center; width:80%; margin:0 auto;">
				<table class="table">
					<form action="/noticeCommentInsert" method="post">
						<!-- 숨겨서 전달해야할 정보를 type="hidden"으로 전달 -->
						<input type="hidden" name="noticeCommentAuthor" value="<%=m.getMemberId() %>">
						<input type="hidden" name="noticeRef" value="<%=n.getNoticeNo() %>">
						<input type="hidden" name="noticeCommentLevel" value="1"><!-- 댓글인지 대댓글인지 구분 -->
						<input type="hidden" name="noticeCommentRef" value="0"><!-- value를 비워두면 자바 컴파일 오류 발생(int 는 null이 될 수 없음) -->
						<tr>
							<td width="85%">
								<textarea rows="1" class="form-control" name="noticeCommentContent"></textarea>
							</td>
							<td width="15%">
								<button type="submit" class="btn btn-primary">댓글등록</button>
							</td>
						</tr>
					</form>
				</table>
			</div>
		<% } %>
		<!-- 댓글 및 대댓글 수정 및 삭제 -->
		<!-- 댓글 수정 및 삭제 form -->
		<div class="comment-wrapper" style="text-align:center; width:80%; margin:0 auto;">
			<table class="table">
				<form action="/noticeCommentUpdate" method="post">
					<!-- 숨겨서 전달해야할 정보를 type="hidden"으로 전달 -->
					<input type="hidden" name="noticeCommentAuthor" value="<%=m.getMemberId() %>">
					<input type="hidden" name="noticeRef" value="<%=n.getNoticeNo() %>">
					<input type="hidden" name="noticeCommentLevel" value="1"><!-- 댓글인지 대댓글인지 구분 -->
					<input type="hidden" name="noticeCommentRef" value="0"><!-- value를 비워두면 자바 컴파일 오류 발생(int 는 null이 될 수 없음) -->
					<tr>
						<th>작성자</th><th>내용</th><th>작성일</th><th></th>
					</tr>
					<% 
					for(NoticeComment nc : list) { 
						if(nc.getNoticeCommentLevel()==1){
					%>
					<tr>
						<td><%=nc.getNoticeCommentAuthor() %></td>
						<td>
							<span><%=nc.getNoticeCommentContent() %></span>
							<input type="text" name="noticeCommentContent" style="display:none;" value="<%=nc.getNoticeCommentContent() %>">
						</td>
						<td><%=nc.getNoticeCommentDate() %></td>
						<td>
							<% 
							if(m != null) {
							%>
							<button type="button" class="btn btn-primary btn-sm insrt">댓글 달기</button>
							<%	
								if(m.getMemberId().equals(nc.getNoticeCommentAuthor())) { 
							%>
								<button type="button" class="btn btn-primary btn-sm modi">수정</button>
								<input type="hidden" id="noticeCommentLevelRepository" value="<%=nc.getNoticeCommentLevel() %>">
								<input type="hidden" name="noticeCommentNo" value="<%=nc.getNoticeCommentNo() %>"><!-- 쿼리문에 필요  -->
								<button type="button" class="btn btn-primary btn-sm del">삭제</button>
							<% 
								} // inner if ends
							} // button if ends	
							%>
						</td> <!-- button "td" ends  -->
					</tr> <!-- button "tr" ends -->
				</form>
				<!-- 대댓글 수정 및 삭제 form  -->
				<form action="/noticeCommentUpdate" method="post">
					<!-- 숨겨서 전달해야할 정보를 type="hidden"으로 전달 -->
					<input type="hidden" name="noticeCommentAuthor" value="<%=m.getMemberId() %>">
					<input type="hidden" name="noticeRef" value="<%=n.getNoticeNo() %>">
					<input type="hidden" name="noticeCommentLevel" value="1"><!-- 댓글인지 대댓글인지 구분 -->
					<input type="hidden" name="noticeCommentRef" value="0"><!-- value를 비워두면 자바 컴파일 오류 발생(int 는 null이 될 수 없음) -->
						<% }// 'if(nc.getNoticeCommentLevel()==1)' ends %>
						<%
						for(NoticeComment ncc:list) {
							boolean bool = ncc.getNoticeCommentLevel()==2 && ncc.getNoticeCommentRef()==nc.getNoticeCommentNo();
							System.out.println("noticeView.jsp 대댓글 bool : " + bool);
							if(ncc.getNoticeCommentLevel()==2 && ncc.getNoticeCommentRef()==nc.getNoticeCommentNo()) {	
						%>
							<tr>
								<td width="10%"><%=ncc.getNoticeCommentAuthor() %></td>
								<td>
									<span><%=ncc.getNoticeCommentContent() %></span>
									<input type="text" name="noticeCommentContent" style="display:none;" value="<%=ncc.getNoticeCommentContent() %>">
								</td>
								<td><%=ncc.getNoticeCommentDate() %></td>
								<td>
									<% 
									if(m != null) {
									%>
									<button type="button" class="btn btn-primary btn-sm insrt">댓글 달기</button>		
									<%	
										if(m.getMemberId().equals(ncc.getNoticeCommentAuthor())) { 
											System.out.println(ncc.getNoticeCommentLevel());
									%>							
										<button type="button" class="btn btn-primary btn-sm modi">수정</button>
										<input type="hidden" id="noticeCommentLevelRepository" value="<%=ncc.getNoticeCommentLevel() %>">
										<input type="hidden" name="noticeCommentNo" value="<%=ncc.getNoticeCommentNo() %>"><!-- 쿼리문에 필요  -->
										<button type="button" class="btn btn-primary btn-sm del">삭제</button>
									<% 
										} // inner if ends
									} // button if ends	
									%>
								</td> <!-- button "td" ends  -->
							</tr> <!-- button "tr" ends -->
						<% 
							} // 대댓글 조건 if 종료
						} // 대댓글 for ends
						%>
					<% } // for ends %>
				</form>
			</table>
		</div>
	</section>
	<script>
		function fileDownload(filename,filepath){
			var url = "/noticeFileDownload";
			var encFilename = encodeURIComponent(filename);
			var encFilepath = encodeURIComponent(filepath);
			location.href=url+"?filename="+encFilename+"&filepath="+encFilepath;
		}
		$(function(){			
			console.log($('.modi')); /* test log */
			$('.modi').click(function(){
				var $span = $(this).parent().siblings().eq(1).children().first();
				var $input = $(this).parent().siblings().eq(1).children().last();
				var $commentLevel = $(this).next().val()
				$span.css('display','none');
				$input.css('display','inline');
				$input.focus(function(){
					$(this).parent().siblings().eq(2).children().first().attr('type','submit').html('제출');
					if($commentLevel > 1){
						$('.comment-wrapper input[type=hidden]').eq(2).val($commentLevel);
					}
				});
			});
			
			$('.insrt').click(function(){
				$upperTr = $(this).parent().parent()
				$tr1 = $("<tr></tr>")
				$td1 = $("<td></td>")
				$upperTr.after($tr1);
				$upperTr.next().append($td1);
				$upperTr.next().children().first().append("<textarea rows='1'class='form-control' name='noticeCommentContent'></textarea>");
				
			});
		});
	</script>
</body>
</html>