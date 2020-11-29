<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>结算页面</title>
	<%--静态包含 base--%>
	<%@include file="/pages/common/base.jsp"%>
	<link type="text/css" rel="stylesheet" href="static/css/style.css" >
	<style type="text/css">
		h1 {
			text-align: center;
			margin-top: 200px;
			margin-bottom: 200px;
		}
	</style>
</head>

<body>
<%--静态包含 nav--%>
<%@include file="/pages/common/nav.jsp"%>

<div id="header">
	<img class="logo_img" alt="" src="static/img/logo.gif" >
	<span class="wel_word">结算</span>
</div>

<div id="main">
	<h1>您的订单已结算，订单编号为${sessionScope.orderId}</h1>
</div>

<%--静态包含 页脚--%>
<%@include file="/pages/common/footer.jsp"%>
</body>
</html>