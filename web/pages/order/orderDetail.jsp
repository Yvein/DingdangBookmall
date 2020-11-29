<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>叮当书城 订单详情</title>
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
    <span class="wel_word">订单详情</span>
    <span class="cart_span">订单编号：${requestScope.order.orderId}</span>&nbsp;&nbsp;
    <span class="cart_span">创建时间：${requestScope.order.createTime}</span>
</div>
<div class="main">
    <table>
        <c:forEach items="${requestScope.orderItems}" var="orderItem">
            <tr>
                <div class="cart_item">
                    <div class="cart_img">
                        <img src="${orderItem.imgPath}">
                    </div>
                    <div class="cart_intro">
                        <span id="cart_span" class="cart_span">${orderItem.name}</span>
                        <span class="cart_span">x${orderItem.count}</span>
                    </div>
                    <div class="cart_price">￥${orderItem.totalPrice}</div>
                </div>
                <hr>
            </tr>
        </c:forEach>
    </table>
</div>
<div class="cart_info">
    <span class="cart_span" id="xiaoji">共 ${requestScope.count} 件商品:</span>
    <c:if test="${requestScope.order.status==0}">
        <span class="cart_span" id="xiaoji">暂未发货</span>
    </c:if>
    <c:if test="${requestScope.order.status==1}">
        <span class="cart_span" id="xiaoji">已发货</span>
    </c:if>
    <c:if test="${requestScope.order.status==2}">
        <span class="cart_span" id="xiaoji">已确认收货</span>
    </c:if>
</div>

<%--静态包含 页脚--%>
<%@include file="/pages/common/footer.jsp"%>
</body>
</html>