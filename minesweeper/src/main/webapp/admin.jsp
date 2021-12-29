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
	border: 3px solid rgb(143, 145, 250);
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
<title>Admin</title>
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

 <table border=3 class="table">
 		<caption style="font-size: xx-large;">User</caption>
        <thead>
            <tr class="tr">
                <th class="td">ID</th>
                <th class="td">PW</th>
                <th class="td">NICKNAME</th>
                <th class="td">Mail</th>
                <th class="td" colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${users}" var="user">
                <tr class="tr">
                    <td class="td"><c:out value="${user.id}" /></td>
                    <td class="td"><c:out value="${user.pw}" /></td>
                    <td class="td"><c:out value="${user.nickname}" /></td>
                    <td class="td"><c:out value="${user.mail}" /></td>
                    <td class="td"><a href="DeleteUser?userId=<c:out value="${user.id}"/>" style="text-decoration: none; color: red;">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>