
<%@page contentType="text/html; charset=UTF-8"%>

<html>
<head>
<title>書籍管理メニュー画面</title>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/view/css/menu.css">
</head>
<body>
	<%@ include file="/common/header.jsp"%>

	<%@ include file="/common/userInfo.jsp"%>
	<hr class="m_hr">
	<p id="m_title" >menu</p>
	<hr class="m_hr"
		>
	<div id="m_div" >
		<table style="margin: auto; border: 1;">
			<tr>
				<td class="m_td"><a href="<%=request.getContextPath()%>/list">【書籍一覧】</a></td>
			</tr>
			<tr>
				<td class="m_td"><a href="<%=request.getContextPath()%>/view/insert.jsp">【書籍登録】</a></td>
			</tr>
			<tr>
				<td class="m_td"><a href="<%=request.getContextPath()%>/showCart">【カート状況確認】
				</a ></td>
			</tr>
			<tr>
				<td class="m_td"><a href="<%=request.getContextPath()%>/insertIniData">【初期データ登録（データがない場合のみ）】</a></td>
			</tr>
			<tr>
				<td class="m_td"><a href="<%=request.getContextPath()%>/showOrderedItem">【購入状況確認】</a></td>
			</tr>
			<tr>
				<td class="m_td"><a href="<%=request.getContextPath()%>/logout">【ログアウト】</a></td>
			</tr>
		</table>
	</div>

	<%@ include file="/common/footer.jsp"%>
</body>
</html>