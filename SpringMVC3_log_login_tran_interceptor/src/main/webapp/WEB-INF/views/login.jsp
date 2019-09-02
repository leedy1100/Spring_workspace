<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">

	$(function(){
		$("#loginchk").hide();
	})
	
	function login(){
		var idVal = $("#id").val();
		var pwVal = $("#pw").val();
		
		if(idVal == "" || idVal == null){
			alert("ID를 다시한번 확인해 주세요.");
		}else if(pwVal == "" || pwVal == null){
			alert("PW를 다시한번 확인해 주세요.");
		}else{
			
			$("#loginchk").show();
			
			$.ajax({
				type:"post",
				url:"loginajax.do",
				data:"id="+idVal+"&pw="+pwVal,
				success:function(msg){
					alert(msg);
					if(msg.loginchk == true){
						location.href='list.do';
					}else{
						document.getElementById("loginchk").innerHTML="ID혹은 비밀번호를 확인해주세요.";
					}
				},
				error:function(){
					alert("로그인 실패");
				}
			})
			
		}
	}
	
</script>
</head>
<body>
	<h1>LOGIN</h1>
	
	<table>
		<tr>
			<th>ID</th>
			<td><input type="text" id="id"/></td>
		</tr>
		<tr>
			<th>PW</th>
			<td><input type="text" id="pw"/></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="Login" onclick="login()">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center" id="loginchk"></td>
			</tr>
	</table>
</body>
</html>