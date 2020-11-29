<%--
  Created by IntelliJ IDEA.
  User: Ein
  Date: 2020/11/23
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--顶部导航-->
<div class="nav">
    <ul>
        <li><a href="#">叮当书城</a></li>
        <li><a href="orderServlet?action=myOrder">我的订单</a></li>
        <li><a href="pages/manager/manager.jsp">后台管理</a></li>
        <li><a href="pages/cart/cart.jsp">购物车</a></li>
        <%--如果已经登录--%>
        <c:if test="${not empty sessionScope.user}">
            <li class="login-signup"><span id="username">你好，${sessionScope.user.username}</span>
                <a href="UserServlet?action=logout">注销 </a>
            </li>
        </c:if>
        <%--如果用户信息为空--%>
        <c:if test="${empty sessionScope.user}">
            <li class="login-signup">你好，请
                <a href="pages/user/login.jsp">登录 </a>
                <span class="text-color-red"><a href="pages/user/register.jsp">免费注册</a></span>
            </li>
        </c:if>


    </ul>
</div>
