<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	function init2(){
		if("${msg}" != '' )
			alert("${msg}");
	}
	function fn_addBoard(){
		document.board.action = 'AddBoard';
		document.board.submit();
		
	}
</script>
<link href="css/style.css?ver=1.9" rel="stylesheet" type="text/css" />
<style>
.table,
.tr,
.td {
	text-align: center;
	border: 0px solid rgb(143, 145, 250);
	font-weight: bold;
	margin-left:auto; 
    margin-right:auto;
    border-spacing: 0px;
}

.td{
	border: 3px solid rgb(143, 145, 250);
	width: 30px;
	height: 30px;
	border-radius: 0px;
	border-spacing: 0px;	
	font-size: x-large;
}
.list_tr:hover{
	color: rgb(143, 145, 250);
}
.input{
	 width: 98%; 
	 height:85%; 
	 background-color: transparent;
	 font-size: large;
}
.input:focus{
	outline: none;
}
</style>
<meta charset="utf-8">
<title>Board</title>
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
<form id="board" name="board" method="post" action="AddBoard">
	<div style="text-align: center;">
		<table border=0 class="table" style="width: 100%;">
			<colgroup>
				<col width="8%" />
				<col width="*" />
				<col width="15%" />
				<col width="20%" />
			</colgroup>
			<thead>
				<tr class="tr">
					<th class="td" scope="col">글번호</th>
					<th class="td" scope="col">제목</th>
					<th class="td" scope="col">ID</th>
					<th class="td" scope="col">작성일</th>
				</tr>
			</thead>
			<tbody>
				<tr class="tr">
					<td name="idx" class="td"> </td>
					<td class="td, list_tr"><input name="title" class="input" type="text" maxlength=50 value=" "></td>
					<td name="id" class="td">${sessionId }</td>
					<td name="date" class="td"> </td>
				</tr>
				<tr>
					
					<td class="td" colspan="4" style="height: 500px;">
					<textarea form="board" id="content" name="content" class="input" style="height:95%; background-color: white;"
					 maxlength=500> </textarea></td>
				</tr>
			</tbody>
		</table>
		<div id="sysbtn" style="text-align: right;">
			<button id="menu_login" class="styled" style="border-radius: 0px; border: 3px solid rgb(107, 106, 106);" type="button" onclick="location.href='ProcessBoard'">목록</button>
			<button id="menu_login" class="styled" style="border-radius: 0px; border: 3px solid rgb(107, 106, 106);" type="button" onclick="fn_addBoard()">등록</button>
		</div>
	</div>
</form>
</body>
</html>