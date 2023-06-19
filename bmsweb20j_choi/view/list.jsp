<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.Book"%>
<html>
	<head>
		<title>list</title>
		<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/view/css/list.css">
	</head>
	<body>
	<%@ include file="/common/header.jsp"%>


		<table id="l_menu_tbl" >
			<tr>
				<td class="l_menu_link" >[<a href="<%=request.getContextPath() %>/view/menu.jsp">メニュー</a>]</td>
				<td class="l_menu_link" >[<a href="<%=request.getContextPath() %>/view/insert.jsp">書籍登録</a>]</td>
				<td id="l_menu_title" >書籍一覧</td>
				<td class="l_menu_link2"  >&nbsp;</td>
				<td class="l_menu_link2"  >&nbsp;</td>
			</tr>
		</table>

		<hr id="l_menu_hr" >
		<div id="l_search_div" >

			<table id="l_search_tbl">
				<tr>
					<td>
						<form action="<%=request.getContextPath()%>/search">
							isbn：<input type=text size="30" name="isbn"></input>
							title：<input type=text size="30" name="title"></input>
							価格：<input type=text size="30" name="price"></input>
							<input type="submit" name="search" value="検"></input>
						</form>
					</td>
					<td>
						<form action="<%=request.getContextPath()%>/list">
							<input type="submit" name="searchall" value="全件表示"></input>
						</form>
					</td>
				</tr>
			</table>

			<table id="l_td" >
				<tr>
					<th class="l_th" >isbn</th>
					<th class="l_th" >title</th>
					<th class="l_th" >価格</th>
					<th class="l_th"  colspan="3">変更/削除/カートに入れる</th>
				</tr>
				<%
				ArrayList<Book> list =(ArrayList<Book>)request.getAttribute("book_list");
				if(list != null){
					for(int i=0;i<list.size();i++){
						Book books = (Book)list.get(i);
				%>
				<tr>
					<td class="l_td1" ><a href="<%=request.getContextPath() %>/detail?isbn=<%=books.getIsbn()%>&cmd=detail"><%=books.getIsbn()%></a></td>
					<td class="l_td1" ><%=books.getTitle()%></td>
					<td class="l_td1" >\<%=books.getPrice()%></td>
					<td id="l_td2" >
						<a href="<%=request.getContextPath() %>/detail?isbn=<%=books.getIsbn()%>&cmd=update">変更</a>
					</td>
					<td id="l_td3"  >
						<a href="<%=request.getContextPath()%>/delete?isbn=<%=books.getIsbn()%>" >削除</a>
					</td>
					<td id="l_td4" >
						<a href="<%=request.getContextPath()%>/insertIntoCart?isbn=<%=books.getIsbn()%>" >カートに入れる</a>
					</td>
				</tr>
				<%
					}
				}else{
				%>
				<tr>
					<td class="l_td5" >&nbsp;</td>
					<td class="l_td5" >&nbsp;</td>
					<td class="l_td5" >&nbsp;</td>
					<td class="l_td5" style="text-align:center; width:200px" colspan="2">&nbsp;</td>
				</tr>
				<%
				}
				%>
			</table>

		</div>


		<%@ include file="/common/footer.jsp"%>
	</body>
</html>