<%@page import="jdk.nashorn.internal.ir.RuntimeNode.Request"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String message = (String) request.getAttribute("message");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>書籍管理システムWeb版Ver.2.0</title>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/view/css/login.css">
</head>
<body>


	<%@ include file="/common/header.jsp"%>
	<h1>test</h1>
	<hr id="l_hr">

	<div id="l_table">

		<form action="<%=request.getContextPath()%>/login" method="POST">


			<table>
				<tr>
					<td class="l_td">ユーザー</td>
					<td><input name="id"></td>
				</tr>
				<tr>
					<td class="l_td">パスワード</td>
					<td><input name="pass"></td>
				</tr>
				<tr>
					<td colspan="2" id="l_btn"><input type="submit" value="ログイン"></td>
				</tr>
			</table>

			<%
				if (message != null) {
			%>
			<%=message%>
			<%
				}
			%>



		</form>

	</div>

	<h1>ashfiofjdoidfjopl</h1>>
	<%@ include file="/common/footer.jsp"%>


</body>
</html>