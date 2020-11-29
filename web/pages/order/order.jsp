<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>我的订单</title>
	<%--静态包含 base--%>
	<%@include file="/pages/common/base.jsp"%>
	<link type="text/css" rel="stylesheet" href="static/css/style.css" >
	<style type="text/css">
		h1 {
			text-align: center;
			margin-top: 200px;
		}
	</style>
</head>

<body>
<%--静态包含 nav--%>
<%@include file="/pages/common/nav.jsp"%>

<div id="header">
	<img class="logo_img" alt="" src="../../static/img/logo.gif" >
	<span class="wel_word">我的订单</span>
</div>

<div id="main">
	<c:if test="${requestScope.orders.size()>0}">
	<table>
		<tr id="title">
			<td>订单编号</td>
			<td>下单时间</td>
			<td>总金额</td>
			<td>状态</td>
		</tr>
		<c:forEach items="${requestScope.orders}" var="order">
		<tr>
			<td><span class="cart_span"><a href="orderServlet?action=orderDetail&orderId=${order.orderId}">${order.orderId}</a></span></td>
			<td>${order.createTime}</td>
			<td>${order.price}</td>
			<c:if test="${order.status==0}">
				<td>未发货</td>
			</c:if>
			<c:if test="${order.status==1}">
				<td><a href="orderServlet?action=receipt&orderId=${order.orderId}">确认收货</a></td>
			</c:if>
			<c:if test="${order.status==2}">
				<td>已收货</td>
			</c:if>
		</tr>
		</c:forEach>
	</table>
	</c:if>
	<c:if test="${requestScope.orders.size()<=0}">
		<h1>暂无订单信息&nbsp<a href="index.jsp">去购物</a></h1>
	</c:if>
</div>

<%--静态包含 页脚--%>
<%@include file="/pages/common/footer.jsp"%>
</body>
</html>