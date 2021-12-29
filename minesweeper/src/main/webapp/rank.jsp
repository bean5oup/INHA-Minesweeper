<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
</style>
<meta charset="utf-8">
<title>Rank</title>
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
	<table border=0 class="table" style="display: inline;">
		<thead>
			<tr class="tr">
				<th class="td" colspan=3>LEVEL 1</th>
			</tr>
			<tr class="tr">
				<th class="td">ID</th>
				<th class="td">NICKNAME</th>
				<th class="td">TIME</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${level1s}" var="level1">
				<tr class="tr">
					<td class="td"><c:out value="${level1.id}" /></td>
					<td class="td"><c:out value="${level1.nickname}" /></td>
					<td class="td"><c:out value="${level1.time}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<table border=0 class="table" style="display: inline;">
 		<caption style="font-size: xx-large;">Rank</caption>
        <thead>
        	<tr class="tr">
                <th class="td" colspan=3>LEVEL 2</th>
            </tr>
            <tr class="tr">
                <th class="td">ID</th>
                <th class="td">NICKNAME</th>
                <th class="td">TIME</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${level2s}" var="level2">
            	<tr class="tr">
                    <td class="td"><c:out value="${level2.id}" /></td>
                    <td class="td"><c:out value="${level2.nickname}" /></td>
                    <td class="td"><c:out value="${level2.time}" /></td>
                    </tr>
            </c:forEach>
        </tbody>
    </table>
	<table border=0 class="table" style="display: inline;">
		<thead>
			<tr class="tr">
				<th class="td" colspan=3>LEVEL 3</th>
			</tr>
			<tr class="tr">
				<th class="td">ID</th>
				<th class="td">NICKNAME</th>
				<th class="td">TIME</th>
			</tr>
		</thead>
		<tbody>
            <c:forEach items="${level3s}" var="level3">
            <tr class="tr">
                    <td class="td"><c:out value="${level3.id}" /></td>
                    <td class="td"><c:out value="${level3.nickname}" /></td>
                    <td class="td"><c:out value="${level3.time}" /></td>
                    </tr>
            </c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>