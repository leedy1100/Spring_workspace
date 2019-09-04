<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	파일명 : ${fileobj.filename }<br/>
	설  명 : ${fileobj.desc }<br/>
	<form action="download" method="post">
		<input type="hidden" name="filename" value="${fileobj.filename }"/>
		<input type="submit" value="DOWNLOAD"/>
	</form>

<!-- 
mime(Mutipurpose Internet Mail Extension) type : 
	request header에 지정되는, 데이터가 어떤 종류의 stream인지를 나타내는 프로토콜
	
	ex) hwp
	<mime-mapping>
		<extension>hwp</extension>
		<mime-type>application/unknown</mime-type>
	</mime-mapping>	
	
	
 -->

</body>
</html>