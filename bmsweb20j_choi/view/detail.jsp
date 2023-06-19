<%@page import="bean.Book"%>
<%@page contentType="text/html; charset=UTF-8"%>
<%
	Book book = (Book) request.getAttribute("book");
%>

<html>
<head>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/view/css/detail.css">

<title>書籍管理メニュー画面</title>
</head>
<body>
	<%@ include file="/common/header.jsp"%>
	<table id="d_menu_tbl">
		<tr>
			<td class="d_menu_td">[<a
				href="<%=request.getContextPath()%>/view/menu.jsp">メニュー</a>]
			</td>
			<td class="d_menu_td">[<a
				href="<%=request.getContextPath()%>/list">書籍一覧</a>]
			</td>
			<td class="d_menu_td">[<a
				href="<%=request.getContextPath()%>/view/insert.jsp">書籍登録</a>]
			</td>
			<td id="d_menu_title" >書籍詳細画面</td>
			<td class="d_menu_td" >&nbsp;</td>
			<td class="d_menu_td" >&nbsp;</td>
		</tr>
	</table>
	<hr id="d_menu_hr">
	<div id="d_div" >
		<table id="d_tbl" >
			<tr>
				<td class="d_td"><form action="<%=request.getContextPath()%>/detail">
						<input  type="hidden" name="isbn" value="<%=book.getIsbn()%>"><input
							type="hidden" name="cmd" value="update"><input
							type="submit" class="d_btn" value="変">
					</form></td>
				<td class="d_td"><form action="<%=request.getContextPath()%>/delete">
						<input  type="hidden" name="isbn" value="<%=book.getIsbn()%>"><input
							type="submit" class="d_btn" value="削">
					</form></td>
			</tr>
			<tr>
				<td class="d_td1">ISBN</td>
				<td class="d_td2"><%=book.getIsbn()%></td>
			</tr>
			<tr>
				<td class="d_td1">TITLE</td>
				<td class="d_td2"><%=book.getTitle()%></td>
			</tr>
			<tr>
				<td class="d_td1">価格</td>
				<td class="d_td2">\<%=book.getPrice()%></td>
			</tr>
		</table>



	</div>
	<%@ include file="/common/footer.jsp"%>
</body>
</html>