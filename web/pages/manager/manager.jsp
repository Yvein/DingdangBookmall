<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>后台管理</title>
	<%--静态包含 base--%>
	<%@include file="/pages/common/base.jsp"%>
	<link type="text/css" rel="stylesheet" href="static/css/style.css" >
	<style type="text/css">
		h1 {
			text-align: center;
			margin-top: 190px;
			margin-bottom: 190px;
		}
	</style>
</head>
<body>

<!--顶部导航-->
<div class="nav">
	<ul>
		<li><a href="#">叮当书城</a></li>
		<li><a href="orderServlet?action=myOrder">我的订单</a></li>
		<li><a href="pages/manager/manager.jsp">后台管理</a></li>
		<li><a href="pages/cart/cart.jsp">购物车</a></li>
		<li class="login-signup"><span id="username">你好，admin</span>
			<a href="UserServlet?action=logout">注销 </a>
		</li>
	</ul>
</div>


<%--静态包含 manager_header--%>
<%@include file="/pages/common/manager_header.jsp"%>
	
<div id="main">
	<h1>你好，管理员 admin</h1>
</div>

<%--静态包含 页脚--%>
<%@include file="/pages/common/footer.jsp"%>

</body>
</html>