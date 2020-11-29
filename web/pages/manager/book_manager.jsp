<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>图书管理</title>
	<%--静态包含 base--%>
	<%@include file="/pages/common/base.jsp"%>
	<link type="text/css" rel="stylesheet" href="static/css/style.css" >
	<link rel="stylesheet" type="text/css" href="static/css/bootstrap.min.css">
<%--	<link rel="stylesheet" href="static/css/font-awesome.min.css">--%>
<%--	<script src="static/js/jquery.js"></script>--%>
	<script src="static/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="static/js/jquery-1.7.2.js"></script>

	<script type="text/javascript">

		$(function () {
			//给删除按钮绑定确认事件
			$("a.deleteClass").click(function () {
				//alert($(this).parent());
				//alert($(this).parent().parent());
				/**
				 * confirm提示框
				 * 有两个按钮，确认和取消
				 * true-确认 false-取消
				 */
				return confirm("你确定要删除【"+ $(this).parent().parent().find("td:first").text() +"】吗？");
			});
		});

	</script>
</head>
<body>
<%--静态包含 nav--%>
<%@include file="/pages/common/nav.jsp"%>

<%--静态包含 manager_header--%>
<%@include file="/pages/common/manager_header.jsp"%>

<div id="main">
	<table>
		<tr id="title">
			<td>名称</td>
			<td>作者</td>
			<td>折扣价</td>
			<td>原价</td>
			<td colspan="2">操作</td>
		</tr>

		<c:forEach items="${requestScope.page.items}" var="book">
			<tr>
				<td>${book.name}</td>
				<td>${book.author}</td>
				<td>${book.discount}</td>
				<td>${book.price}</td>
				<td><a href="manager/bookServlet?action=getBook&id=${book.id}&method=update&pageNow=${requestScope.page.pageNow}">修改</a></td>
				<td><a class= "deleteClass" href="manager/bookServlet?action=delete&id=${book.id}&pageNow=${requestScope.page.pageNow}">删除</a></td>
			</tr>
		</c:forEach>


		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td colspan="2"><a href="pages/manager/book_edit.jsp?method=add&pageNow=${requestScope.page.pageNum}">添加图书</a></td>
		</tr>

	</table>

	<%--静态包含 分页条--%>
	<%@include file="/pages/common/page_num.jsp"%>
</div>

<%--静态包含 页脚--%>
<%@include file="/pages/common/footer.jsp"%>
</body>
</html>