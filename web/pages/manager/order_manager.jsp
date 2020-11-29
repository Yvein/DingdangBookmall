<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>订单管理</title>
	<%--静态包含 base--%>
	<%@include file="/pages/common/base.jsp"%>
	<link type="text/css" rel="stylesheet" href="static/css/style.css" >
</head>
<body>
<%--静态包含 nav--%>
<%@include file="/pages/common/nav.jsp"%>

<%--静态包含 manager_header--%>
<%@include file="/pages/common/manager_header.jsp"%>

<div id="main">
	<table>
		<tr id="title">
			<td>订单编号</td>
			<td>生成时间</td>
			<td>总金额</td>
			<td>用户</td>
			<td>状态</td>
		</tr>
		<c:forEach items="${requestScope.orders}" var="order">
		<tr>
			<td name="orderId">${order.orderId}</td>
			<td>${order.createTime}</td>
			<td>${order.price}</td>
			<td>${order.userId}</td>
			<c:if test="${order.status==0}">
			<td><a href="orderServlet?action=deliver&orderId=${order.orderId}">立即发货</a></td>
			</c:if>
			<c:if test="${order.status==1}">
				<td>已发货</td>
			</c:if>
			<c:if test="${order.status==2}">
				<td>已收货</td>
			</c:if>
		</tr>
		</c:forEach>
	</table>
</div>

<%--静态包含 页脚--%>
<%@include file="/pages/common/footer.jsp"%>
</body>
</html>