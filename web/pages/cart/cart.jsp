<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>购物车</title>
	<%--静态包含 base--%>
	<%@include file="/pages/common/base.jsp"%>
	<link type="text/css" rel="stylesheet" href="static/css/style.css" >
	<script type="text/javascript" src="static/js/jquery-1.7.2.js"></script>
	<style type="text/css">
		#main h1{
			text-align: center;
			margin-top: 190px;
			margin-bottom: 190px;
		}
		h1 {
			text-align: center;
			margin-top: 100px;
			margin-bottom: 100px;
		}
		h1 a { color:#8c8c8c;}
		input{
			width:35px;
			text-align: center;
		}
	</style>
	<script type="text/javascript">
		$(function () {
			//给删除按钮绑定确认事件
			$("a.deleteItem").click(function () {
				var itemName = $(this).attr("itemName");
				return confirm("你确定要删除【"+ itemName +"】吗？");
			});
			//给清空购物车绑定确认事件
			$("a.clear").click(function () {
				return confirm("你确定要清空购物车吗？");
			});
			//给修改数量绑定onchange事件
			$(".updateCount").change(function () {
				var itemId = $(this).attr("itemId");
				var count = this.value;
				var basePath = $(this).attr("basePath");
				location.href= basePath + "cartServlet?action=updateCount&id=" + itemId + "&count=" + count;
			});
		});
	</script>
</head>

<body>
<%--静态包含 nav--%>
<%@include file="/pages/common/nav.jsp"%>

<div id="header">
	<span class="wel_word">购物车</span>
	<span class="cart_span"><a class="clear" href="cartServlet?action=clearItem">清空购物车</a></span>
</div>
	<c:if test="${sessionScope.cart.totalCount > 0}">
	<div class="main">
		<table>
			<c:forEach items="${sessionScope.cart.items}" var="entry">
			<tr>
				<div class="cart_item">
					<div class="cart_img">
						<img src="${entry.value.imgPath}">
					</div>
					<div class="cart_intro">
						<span id="cart_span" class="cart_span">${entry.value.name}</span>
						<input
								itemId="${entry.value.id}"
								basePath="<%=basePath%>"
								class="updateCount"
								type="number"
								value="${entry.value.count}"
						>|
						<span class="cart_span"><a itemName="${entry.value.name}" class= "deleteItem" href="cartServlet?action=deleteItem&id=${entry.value.id}">删除</a></span>
					</div>
					<div class="cart_price">￥${entry.value.price}</div>
				</div>
				<hr>
			</tr>
			</c:forEach>
		</table>
	</div>
	<div class="cart_info">
		<span class="cart_span" id="xiaoji">小计（${sessionScope.cart.totalCount}件商品）:</span>
		<span class="cart_span" id="price">￥${sessionScope.cart.totalPrice}</span>

		<button id="jiezhang"><a href="orderServlet?action=createOrder">去结算</a></button>
	</div>
	</c:if>
	<c:if test="${sessionScope.cart.totalCount <= 0 or sessionScope.cart == null}">
		<div id="main">
			<h1>您的购物车内暂无商品&nbsp<a href="index.jsp">去购物</a></h1>
		</div>
	</c:if>

<%--静态包含 页脚--%>
<%@include file="/pages/common/footer.jsp"%>
</body>
</html>