<%--
  Created by IntelliJ IDEA.
  User: Ein
  Date: 2020/11/23
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif" >
    <span class="wel_word">后台管理系统</span>
    <div>
        <%--请求manager/BookServlet地址，调用list方法--%>
        <a href="manager/bookServlet?action=page">图书管理</a>&nbsp;&nbsp;
        <a href="orderServlet?action=showOrder">订单管理</a>&nbsp;&nbsp;
    </div>
</div>