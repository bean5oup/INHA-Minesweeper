<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	function init2(){
		console.log(${msg});
		if("${msg}" != '' )
			$("#error").show();
	}
</script>
<meta charset="utf-8">
<title>Sign In</title>
<link href="css/style.css?ver=1.3" rel="stylesheet" type="text/css" />
</head>
<body bgcolor="gray" onload="init(); init2();">
<%@ include file="menu.jsp"%>
<% 
	try{
	if(session.getAttribute("sessionId").toString().equals("root")){ %>
			<script>$("#menu_admin").show();
			</script>
<%
		}
	} catch(Exception e){
	}
%>

<form action="UserLogin" method="post">
<div style="margin: auto; text-align: center; border: 1px solid rgb(143, 145, 250); width: 50%; height: 150%;">
	<div class='alert-danger' id="error" style="display:none" >
				"아이디와 비밀번호를 확인해 주세요"
	</div>
	<span>
		<input class="id_pw" type="text" id="id" name="id" placeholder="아이디" maxlength="20">
	</span><br>
	<span>
		<input class="id_pw" type="password" id="pw" name="pw" placeholder="비밀번호" maxlength="20">
	</span><br>
	<span>
		<input class="id_pw_submit" type="submit" value="로그인">
	</span><br><br>
	
	<a href="" style="color: white; text-decoration: none; display: none;">아이디 찾기</a> | 
	<a href="" style="color: white; text-decoration: none; display: none;">비밀번호 찾기</a> |
	<a href="join.jsp" style="color: white; text-decoration: none;">회원가입</a>
</div>
</form>
</body>
</html>