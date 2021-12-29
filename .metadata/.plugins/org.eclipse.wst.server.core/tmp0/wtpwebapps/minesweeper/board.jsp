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
				<c:choose>
					<c:when test="${f:length(boards) > 0}">
						<c:forEach items="${boards }" var="board">
							<tr class="tr, list_tr" onclick="location.href='ProcessBoardDetail?idx='+${board.idx}">
								<td class="td">${board.idx }</td>
								<td class="td">${board.title }</td>
								<td class="td">${board.id }</td>
								<td class="td">${board.date }</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr class="tr, list_tr" onclick="">
							<td class="td" colspan="4">조회된 결과가 없습니다.</td>
						</tr>
					</c:otherwise>
				</c:choose>

			</tbody>
		</table>
		<div id="sysbtn" style="text-align: right;">
			<button id="menu_login" class="styled" style="border-radius: 0px; border: 3px solid rgb(107, 106, 106);" type="button" onclick="location.href='ProcessboardAdd'">등록</button>
		</div>
	</div>
</body>
</html>