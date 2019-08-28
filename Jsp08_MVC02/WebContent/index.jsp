<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8");%>
<% response.setContentType("text/html; charset=UTF-8");%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<a href="mvc.do?command=list">list</a>
	<br/>
	
	<a href="selectall">목록</a><br/>
	<a href="/selectall">목록2</a><br/>
	<a href="./selectall">목록3</a><br/>
	<a href="<%=request.getContextPath() %>/selectall">목록4</a><br/>
	
</body>
</html>