<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Create Your Account</title>
<link href="css/style.css?ver=1.5" rel="stylesheet" type="text/css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	function fn_addMember(){
		document.newMember.action = 'UserController';
		$("#mail").val($("#mail1").val()+"@"+$("#mail2").val());
		document.newMember.submit();
	}
	
	function checkForm() {
		if (!document.newMember.id.value) {
			alert("아이디를 입력하세요.");
			return false;
		}
		if (!document.newMember.pw.value) {
			alert("비밀번호를 입력하세요.");
			return false;
		}
		if (document.newMember.pw.value != document.newMember.password_confirm.value) {
			alert("비밀번호를 동일하게 입력하세요.");
			return false;
		}
		if (!document.newMember.nickname.value) {
			alert("닉네임을 입력하세요.");
			return false;
		}
		if (!document.newMember.mail1.value) {
			alert("이메일을 입력하세요.");
			return false;
		}
		fn_addMember();
	}
	function init2(){
		if("${msg}" != '' )
			$("#error").show();
	}
		
</script>
</head>
<body bgcolor="gray" style="height:100%;" onload="init(); init2();">
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

<div style="margin: auto; text-align: center; border: 1px solid rgb(143, 145, 250); width: 50%; height: 150%;">
	<div class="container">
		<form name="newMember" class="form-horizontal"  action="UserController" method="post" onsubmit="return checkForm();">
			<div class='alert-danger' id="error" style="display:none" >
				"이미 존재하는 ID입니다."
			</div>
			<div class="form-group  row">
				<label class="col-sm-2 ">아이디</label>
				<div class="col-sm-3">
					<input name="id" type="text" class="form-control" placeholder="id" >
				</div>
			</div>
			<div class="form-group  row">
				<label class="col-sm-2">비밀번호</label>
				<div class="col-sm-3">
					<input name="pw" type="text" class="form-control" placeholder="pw" >
				</div>
			</div>
			<div class="form-group  row">
				<label class="col-sm-2">비밀번호확인</label>
				<div class="col-sm-3">
					<input name="password_confirm" type="text" class="form-control" placeholder="password confirm" >
				</div>
			</div>
			<div class="form-group  row">
				<label class="col-sm-2">닉네임</label>
				<div class="col-sm-3">
					<input name="nickname" type="text" class="form-control" placeholder="nickname" >
				</div>
			</div>
			<div class="form-group  row ">
				<label class="col-sm-2">이메일</label>
				<div class="col-sm-10">
					<input type="hidden" name="mail" id="mail">
					<input type="text" name="mail1" id="mail1" class="form-control" maxlength="50">@ 
					<select style="font-size: x-large;" name="mail2" id="mail2">
						<option>naver.com</option>
						<option>daum.net</option>
						<option>gmail.com</option>
						<option>nate.com</option>
					</select>
				</div>				
			</div>
			<div class="form-group  row">
				<div class="col-sm-offset-2 col-sm-10 ">
					<input type="button" onclick="checkForm()" class="id_pw_submit" value="등록 " > 
					<input type="reset" class="id_pw_submit " value="취소 " onclick="reset()" >
				</div>
			</div>
		</form>
	</div>
</div>
</body>
</html>