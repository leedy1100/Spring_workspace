<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form:form method="post" enctype="multipart/form-data" modelAttribute="uploadFile" action="upload">
		<h3>업로드 할 파일 선택</h3>
		파일 : <input type="file" name="file"/><br/>
		<p style="color: red; font-weight: bold;">
			<form:errors path="file" />
		</p><br/>
		설명 : <br/>
		<textarea rows="10" cols="40" name="desc"></textarea><br/>
		<input type="submit" value="전송"/>
	</form:form>
	<!-- form:errors = Errors, BindingResult를 사용할 때 command 객체의 특정 filled에서 발생하는 에러 메시지 출력 -->
</body>
</html>

<!-- 
form tag의 enctype 속성
1. application/www-form-urlencoded : (default) 모든 문자들을 encoding
2. multipart/form-data : file upload 가능 (post)
3. text/plain : encoding 하지 않음
 -->










