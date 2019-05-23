<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>다중파일 업로드 테스트</h3>
	<h4>
		commons-fileupload-1.2.2.jar<br>
		commons-io-2.1.jar 라이브러리 사용
	</h4>
	<h4>
		업로드 크기 제한 없음(추측)<br>
		최대크키 2GB/ 1.4GB까지 테스트 완료<br>
		다중업로드 가능<br>
	</h4>
	<hr>
	<form action="/multiUpload" method="post" enctype="multipart/form-data">
		파일 업로드 : <input type="file" name="photo" multiple="multiple"><br>
		내용 : <input type="text" name="description"><br>
		<input type="submit" value="전송">
	</form>
</body>
</html>