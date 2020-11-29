<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>编辑图书</title>
	<%--静态包含 base--%>
	<%@include file="/pages/common/base.jsp"%>
	<link type="text/css" rel="stylesheet" href="static/css/style.css" >
	<style type="text/css">
		h1 {
			text-align: center;
			margin-top: 200px;
		}

		h1 a {
			color:red;
		}

		input {
			text-align: center;
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
	<form action="manager/bookServlet" method="post">
		<input type="hidden" name="action" value="${param.method}" />
		<input type="hidden" name="pageNow" value="${param.pageNow}" />
		<table>
			<tr>
				<td>名称</td>
				<td>作者</td>
				<td>折扣价</td>
				<td>原价</td>
				<td colspan="2">操作</td>
			</tr>
			<tr>
				<td><input name="name" type="text" value="${requestScope.book.name}"/></td>
				<td><input name="author" type="text" value="${requestScope.book.author}"/></td>
				<td><input name="discount" type="text" value="${requestScope.book.discount}"/></td>
				<td><input name="price" type="text" value="${requestScope.book.price}"/></td>
				<input type="hidden" name="id" type="text" value="${requestScope.book.id}"/>
				<td><input type="submit" value="提交"/></td>
			</tr>
		</table>
	</form>
</div>

<%--静态包含 页脚--%>
<%@include file="/pages/common/footer.jsp"%>

</body>
</html>