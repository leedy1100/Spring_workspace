<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<head>
	<title>Home</title>
</head>
<body>
<h1>
	EMP LIST  
</h1>

	<table border="1">
		<tr>
			<th>EMPNO</th>
			<th>ENMAE</th>
			<th>SAL</th>
			<th>DEPTNO</th>
		</tr>
		<c:choose>
		<c:when test="${empty list }">
			<tr>
				<td	colspan="4">
					값이 없습니다.
				</td>				
			</tr>
		</c:when>
		<c:otherwise>
			<c:forEach items="${list }" var="dto">
				<tr>
					<td>${dto.empno }</td>
					<td>${dto.ename }</td>
					<td>${dto.sal }</td>
					<td>${dto.deptno }</td>
				</tr>
			</c:forEach>
		</c:otherwise>
		</c:choose>
	</table>

</body>
</html>
