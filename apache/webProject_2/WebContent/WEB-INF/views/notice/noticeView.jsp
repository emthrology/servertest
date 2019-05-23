<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="notice.model.vo.Notice"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	<section>
		<div class="table-wrapper" style="text-align:center; width:80%; margin:0 auto;">
			<table class="table table-bordered">
				<tr>
					<th colspan="2" style="font-size:20px; font-weight:bold;">공지사항</th>
				</tr>
				<tr>
					<th>제목</th>
					<td>${nvd.n.noticeTitle }</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>${nvd.n.noticeAuthor }</td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td>
						<c:if test="${nvd.n.filepath != null }">
							<img src="/img/file.png" width="16px"> 
							<a href="javascript:fileDownload('${nvd.n.filename }','${nvd.n.filepath }');">
								${nvd.n.filename }
							</a>
						</c:if>
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>${nvd.n.noticeContent }</td>
				</tr>
				<tr>
					<th colspan="2">
						<a href="/noticeUpdate?noticeNo=${nvd.n.noticeNo }" class="btn btn-outline-primary btn-sm">수정하기</a>
						<a href="/noticeDelete?noticeNo=${nvd.n.noticeNo }" class="btn btn-outline-primary btn-sm">삭제하기</a><!-- 간단히 실습 과제임 -->
						<a href="/noticeList" class="btn btn-outline-primary btn-sm">목록으로</a>
					</th>
				</tr>
			</table>
		</div>
		<!-- 댓글 -->
		<!-- 댓글 쓰기  -->
		<c:if test="${not empty sessionScope.member1 }">
			<div class="comment-write" style="text-align:center; width:80%; margin:0 auto;">
				<form action="/noticeCommentInsert" method="post">
					<!-- 숨겨서 전달해야할 정보를 type="hidden"으로 전달 -->
					<input type="hidden" name="noticeCommentAuthor" value="${sessionScope.member1.memberId }">
					<input type="hidden" name="noticeRef" value="${nvd.n.noticeNo }">
					<input type="hidden" name="noticeCommentLevel" value="1"><!-- 댓글인지 대댓글인지 구분 -->
					<input type="hidden" name="noticeCommentRef" value="0"><!-- value를 비워두면 자바 컴파일 오류 발생(int 는 null이 될 수 없음) -->
					<table class="table">
						<tr>
							<td width="85%">
								<textarea rows="1" class="form-control" name="noticeCommentContent"></textarea>
							</td>
							<td width="15%">
								<button type="submit" class="btn btn-primary">댓글등록</button>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</c:if>
		<!-- 댓글 및 대댓글 수정 및 삭제 -->
		<!-- 댓글 수정 및 삭제 form -->
		<div class="comment-wrapper" style="text-align:center; width:80%; margin:0 auto;">
			<form action="/noticeCommentUpdate" method="post">
				<!-- 숨겨서 전달해야할 정보를 type="hidden"으로 전달 -->
				<input type="hidden" name="noticeCommentAuthor" value="${sessionScope.member1.memberId }">
				<input type="hidden" name="noticeRef" value="${nvd.n.noticeNo }">
				<input type="hidden" name="noticeCommentRef" value="0"><!-- value를 비워두면 자바 컴파일 오류 발생(int 는 null이 될 수 없음) -->
				<table class="table">
					<tr>
						<th>작성자</th><th>내용</th><th>작성일</th><th></th>
					</tr>
					<c:forEach items="${nvd.list }" var="nc">
						<c:if test="${nc.noticeCommentLevel == 1 }">
							<tr>
								<td width="10%">
									${nc.noticeCommentAuthor }
									<input type="hidden" name="noticeCommentLevel" value="${nc.noticeCommentLevel }"><!-- 댓글인지 대댓글인지 구분 -->
								</td>
								<td>
									<span>${nc.noticeCommentContent }</span>
									<input type="text" name="noticeCommentContent" style="display:none;" value="${nc.noticeCommentContent }">
								</td>
								<td>${nc.noticeCommentDate }</td>
								<td>
									<c:if test="${not empty sessionScope.member1 }">
										<button type="button" class="btn btn-primary btn-sm insrt">댓글 달기</button>
										<c:if test="${sessionScope.member1.memberId == nc.noticeCommentAuthor }">
											<button type="button" class="btn btn-primary btn-sm modi">수정</button>
											<input type="hidden" name="noticeCommentNo" value="${nc.noticeCommentNo }"><!-- 쿼리문에 필요  -->
											<button type="button" class="btn btn-primary btn-sm del">삭제</button>
										</c:if>
									</c:if>
								</td> <!-- button "td" ends  -->
							</tr> <!-- button "tr" ends -->
						</c:if>
						<c:forEach items="${nvd.list }" var="ncc">
							<c:if test="${ncc.noticeCommentLevel == 2 && (ncc.noticeCommentRef == nc.noticeCommentNo) }">
								<tr>
									
									<td width="10%">
										${ncc.noticeCommentAuthor }
										<input type="hidden" name="noticeCommentLevel" value="${ncc.noticeCommentLevel }"><!-- 댓글인지 대댓글인지 구분 -->
									</td>
									<td>
										<span>${ncc.noticeCommentContent }</span>
										<input type="text" name="noticeCommentContent" style="display:none;" value="${ncc.noticeCommentContent }">
									</td>
									<td>${ncc.noticeCommentDate }</td>
									<td>
										<c:if test="${not empty sessionScope.menber1 }">
											<button type="button" class="btn btn-primary btn-sm insrt">댓글 달기</button>
											<c:if test="${sessionScope.member1.memberId == ncc.noticeCommentAuthor }">
												<button type="button" class="btn btn-primary btn-sm modi">수정</button>
												<input type="hidden" name="noticeCommentNo" value="${ncc.noticeCommentNo }"><!-- 쿼리문에 필요  -->
												<button type="button" class="btn btn-primary btn-sm del">삭제</button>
											</c:if>
										</c:if>
									</td> <!-- button "td" ends  -->
								</tr> <!-- button "tr" ends -->
							</c:if>
						</c:forEach>
					</c:forEach>
				</table>
			</form>	
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
			$('.table-bordered tr:last th a:lt(2)').css('display','none');
			if(${sessionScope.member1.memberId eq 'admin'}) {
				$('.table-bordered tr:last th a:lt(2)').css('display','inline');
			}
			
			console.log($('.modi')); /* test log */
			$('.modi').click(function(){
				var $span = $(this).parent().siblings().eq(1).children().first();
				var $input = $(this).parent().siblings().eq(1).children().last();
				var $commentLevel = $(this).parent.siblings().first().children().first();
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
				$upperTr = $(this).parent().parent();
				$trtd = $("<tr><td></td><td></td><td></td><td></td></tr>");
				$upperTr.after($trtd);
				$upperTr.next().children().eq(0).html('${sessionScope.member1.memberId }');
				$upperTr.next().children().eq(1).append("<textarea rows='1'class='form-control' name='noticeCommentContent'></textarea>");
				$upperTr.next().children().eq(2).html("${ncc.noticeCommentDate }");
				$upperTr.next().children().eq(3).append("<button type='submit' class='btn btn-primary btn-sm insrt'>대댓글 달기</button>");
			});
		});
	</script>
</body>
</html>