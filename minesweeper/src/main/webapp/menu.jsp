<%@ page contentType="text/html; charset=utf-8"%>
<link href="css/style.css?ver=1.7" rel="stylesheet" type="text/css" />
<script>
	function init(){
		if("${sessionId}" != ""){
			document.getElementById("menu_nickname").innerText = "[${sessionNickname}님]";
			document.getElementById("menu_login").innerText = "로그아웃";
			document.getElementById("menu_join").innerText = "회원수정";
			document.getElementById("menu_login").setAttribute("onclick", "location.href='UserLogout'");
			document.getElementById("menu_join").setAttribute("onclick", "location.href='update.jsp'");
		}
		else{
			document.getElementById("menu_nickname").innerText = "";
			document.getElementById("menu_login").innerText = "로그인";
			document.getElementById("menu_join").innerText = "회원가입";	
		}
		function logout(){
		     location.href = "UserLogout";
		}
}

</script>
<a href="./index.jsp"><h1 class="title-return" style="float: left; text-shadow: 1px 1px 1px #000;">MineSweeper</h1><br></a>
	<div style="text-align : right;">
			<div id="menu_nickname" style="display: inline; font-size: large; text-align: center; color: #fff;"></div>
		 	<button id="menu_admin" class="styled" style="display: none;" type="button" onclick="location.href='ProcessAdmin'">관리자페이지</button>
			<button id="menu_login" class="styled" type="button" onclick="location.href='login.jsp'">로그인</button>
			<button id="menu_join" class="styled" type="button" onclick="location.href='join.jsp'">회원가입</button>
	</div><br><br><br>
