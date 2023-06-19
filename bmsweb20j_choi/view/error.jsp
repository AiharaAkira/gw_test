<%@page contentType="text/html; charset=UTF-8"%>

<%
	String nullCheck = (String) request.getAttribute("nullCheck");
	String isbnIsNotNull = (String) request.getAttribute("isbnIsNotNull");
	String errorLinkText = (String) request.getAttribute("errorLinkText");
%>

<html>
<head>
<title>書籍管理メニュー画面</title>
<link type="text/css" rel="stylesheet"
	href="<%=request.getContextPath()%>/view/css/error.css">
</head>
<body>
	<%@ include file="/common/header.jsp"%>
	<h1 id="e_h1">○○エラー○○</h1>
	<%
		if (nullCheck != null) {
	%>
	<div class="e_div"><%=nullCheck%></div>
	<%
		}
	%>

	<%
		if (isbnIsNotNull != null) {
	%>
	<div class="e_div"><%=isbnIsNotNull%></div>
	<%
		}
	%>

	<%
		if (errorLinkText != null) {
	%>
	<div class="e_div">
		[ <a
			href="<%=request.getContextPath()%><%=request.getAttribute("errorLink")%>"><%=request.getAttribute("errorLinkText")%></a>]
	</div>
	<%
		}
	%>


	<%@ include file="/common/footer.jsp"%>
</body>
</html>