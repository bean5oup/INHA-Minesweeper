<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>MineSweeper</title>
<link href="css/style.css?ver=1.1" rel="stylesheet" type="text/css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">

</script>
</head>
<body bgcolor="gray" onload="init()">
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

<div style="text-align : center;">
    <div class="menu-box2">
        <a style="height: 50px; padding-top: 25px;" class="menu-box-anchor" href="ProcessRank" onclick="">
        순위 <br>※비로그인시 순위에 기록되지 않음
        </a>
    </div><br><br>
    <div class="menu-box">
        <a class="menu-box-anchor" href="game.jsp?level=1" onclick="">
        초급
        <br>
        (9x9)
        <br>
        (LEVEL1)
        </a>
    </div>
    <div class="menu-box">
        <a class="menu-box-anchor" href="game.jsp?level=2" onclick="">
        중급
        <br>
        (16x16)
        <br>
        (LEVEL2)
        </a>
    </div>
    <div class="menu-box">
        <a class="menu-box-anchor" href="game.jsp?level=3" onclick="">
        고급
        <br>
        (30x16)
        <br>
        (LEVEL3)
        </a>
    </div>
    <div class="menu-box">
        <a class="menu-box-anchor" href="game.jsp?level=4" onclick="">
        커스텀
        <br>
        ※순위에 기록되지 않음
        <br>
        <br>
        </a>
    </div>
    <br><br>
    <div class="menu-box2">
        <a style="height: 50px; padding-top: 25px;" class="menu-box-anchor" href="ProcessBoard" onclick="">
        게시판
        </a>
    </div>
</div>

</body>
</html>