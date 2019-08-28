<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
    
<% request.setCharacterEncoding("UTF-8");%>
<% response.setContentType("text/html; charset=UTF-8");%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>고른 글</h1>
	<table border="1">
		<tr>
			<th>작 성 자</th>
			<td>${dto.writer }</td>
		</tr>
		<tr>
			<th>제	목</th>
			<td>${dto.title }</td>
		</tr>
		<tr>
			<th>작 성 날 짜</th>
			<td>${dto.regdate }</td>
		</tr>
		<tr>
			<th>내	용</th>
			<td><textarea rows="10" cols="60" readonly="readonly">${dto.content }</textarea></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="수정" onclick="location.href='update.do?seq=${dto.seq }'"/>&nbsp;
				<input type="button" value="삭제" onclick="location.href='delete.do?seq=${dto.seq }'"/>&nbsp;
				<input type="button" value="목록" onclick="location.href='boardlist.do'"/>
			</td>
		</tr>
	</table>
		
</body>
</html>