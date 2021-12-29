<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.bean3oup.setting.SettingBoard" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>MineSweeper</title>
<link href="css/style.css?ver=1.2" rel="stylesheet" type="text/css" />
<script src="js/game.js?ver=1.2"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body bgcolor="gray" oncontextmenu='return false' onload="init()">
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

<%
	int level = Integer.parseInt(request.getParameter("level"));
	int row, col, mine;
	if(level == 1){
		row = 9; col = 9;
		mine = 10;
	}
	else if(level == 2){
		row = 16; col = 16;	
		mine = 40;
	}
	else if(level == 3){
		row = 16; col = 30;	
		mine = 99;
	}
	else{
		row = 55; col = 55;
		mine = 100;
		
		if(request.getParameter("row") != null)
			row = Integer.parseInt(request.getParameter("row"));
		if(request.getParameter("col") != null)
			col = Integer.parseInt(request.getParameter("col"));
		if(request.getParameter("mine") != null){
			mine = Integer.parseInt(request.getParameter("mine"));
			if(mine > row * col)
				mine = row * col;
		}
		%>
		<form action="game.jsp">
			<input type="hidden" name="level" value=<%= level %>>
			<input class="styled" type="number" name="col" min="1" max="55" placeholder="가로<%= col %>" required="required">
			<input class="styled" type="number" name="row" min="1" max="100" placeholder="세로<%= row %>" required="required">
			<input class="styled" type="number" name="mine" min="1" max="5500" placeholder="지뢰<%= mine %>" required="required">
			<button class="styled" type="submit">업데이트</button>
		</form>
		<%
	}	
	SettingBoard set = new SettingBoard();
	
	String board = set.setBoard(row, col);
	ArrayList<Integer> minepos = set.setMine(mine, col * row);
%>
<%
	int navi_width = 34 * col;
	if(navi_width < 34 * 3)
		navi_width = 34 * 3;
%>
<div style="text-align: center;">
<div style="display: inline-block; text-align: center; width: <%= navi_width %>px; height: 68px; border: 1px solid rgb(143, 145, 250);">
	<div style="display: inline-block; float: left; margin: 3px;">
		<input class="styled" style="width: 90px; height: 64px; float: left;" id="leftmine" type="submit" value=<%= mine %>>
	</div>
	<div style="display: inline-block; margin: 3px;">
		<form action="game.jsp">
			<input type="hidden" name="level" value=<%= level %>>
			<input class="styled" style="height: 64px" type="submit" value="초기화">
		</form>
	</div>
	<div style="display: inline-block; float: right; margin: 3px;">
		<input class="styled" style="width: 90px; height: 64px; float: right;" id="time" type="submit" value=0 name=0>
	</div>
</div>
<%= board %>
</div>
<script>
	setMineAtBoard(<%= minepos%>);
	tableEvent();
</script>
</body>
</html>