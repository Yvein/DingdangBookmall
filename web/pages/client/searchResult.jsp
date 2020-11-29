<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>叮当书城 搜索结果</title>
    <%--静态包含 base--%>
    <%@include file="/pages/common/base.jsp"%>
    <link rel="stylesheet" type="text/css" href="static/css/bootstrap.min.css">
    <link rel="stylesheet" href="static/css/font-awesome.min.css">
    <script src="static/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="static/css/mall.css">
</head>
<body>
<%--静态包含 nav--%>
<%@include file="/pages/common/nav.jsp"%>

<%--静态包含 搜索框--%>
<%@include file="/pages/common/search.jsp"%>

<div class="container">
    <div class="nav-side">
        <ul>
            <li><span class="nav-side-item">小说</span></li>
            <li><span class="nav-side-item">文学</span></li>
            <li><span class="nav-side-item">艺术与摄影</span></li>
            <li><span class="nav-side-item">传记</span></li>
            <li><span class="nav-side-item">励志与成功</span></li>
            <li><span class="nav-side-item">考试</span></li>
            <li><span class="nav-side-item">经济管理</span></li>
            <li><span class="nav-side-item">教材教辅与参考书</span></li>
            <li><span class="nav-side-item">少儿</span></li>
            <li><span class="nav-side-item">孕产育儿</span></li>
            <li><span class="nav-side-item">家庭教育</span></li>
            <li><span class="nav-side-item">时尚</span></li>
            <li><span class="nav-side-item">娱乐</span></li>
            <li><span class="nav-side-item">健康与养生</span></li>
            <li><span class="nav-side-item">家居休闲</span></li>
            <li><span class="nav-side-item">旅游与地图</span></li>
            <li><span class="nav-side-item">动漫与绘本</span></li>
            <li><span class="nav-side-item">烹饪美食与酒</span></li>
            <li><span class="nav-side-item">英语与其他外语</span></li>
            <li><span class="nav-side-item">婚恋与两性</span></li>
            <li><span class="nav-side-item">计算机与互联网</span></li>
            <li><span class="nav-side-item">社会科学</span></li>
            <li><span class="nav-side-item">法律</span></li>
            <li><span class="nav-side-item">心理学</span></li>
            <li><span class="nav-side-item">历史</span></li>
            <li><span class="nav-side-item">国学</span></li>
            <li><span class="nav-side-item">哲学与宗教</span></li>
            <li><span class="nav-side-item">政治与军事</span></li>
            <li><span class="nav-side-item">医学</span></li>
            <li><span class="nav-side-item">科学与自然</span></li>
            <li><span class="nav-side-item">科技</span></li>
            <li><span class="nav-side-item">体育与运动</span></li>
            <li><span class="nav-side-item">辞典与工具书</span></li>
            <li><span class="nav-side-item">杂志新阅</span></li>
            <li><span class="nav-side-item">进口原版</span></li>
        </ul>
    </div>

    <div class="r_content">
        <!-- 商品显示区域 -->
        <div class="content">
            <!-- 秒杀 -->
            <div class="seckill">
                <!-- 头部 -->
                <div class="seckill-head">
                    <div class="seckill-text">
                        <span class="seckill-title">搜索结果</span>
<%--                        <span class="seckill-remarks">总有你想不到的低价</span>--%>
                    </div>
                </div>
                <!-- 内容 -->
                <c:forEach items="${requestScope.page.items}" var="book">
                <div class="item-row">
                    <div class="item-show-info">
                        <div class="item-show-img">
                            <img src="${book.imgPath}">
                        </div>
                        <div class="item-show-detail">
                            <span>${book.name}</span>
                        </div>
                        <div class="item-show-num">
                                ${book.author}
                        </div>
                        <div class="item-show-price">
                            <span>
                                <i class="fa fa-rmb text-danger"></i>
                                <span class="seckill-price text-danger">${book.discount}</span>
                            </span>
                        </div>
                    </div>
                </div>
                </c:forEach>
            </div>

            <%--静态包含 分页条--%>
            <%@include file="/pages/common/page_num.jsp"%>

        </div>
    </div>
</div>

<%--静态包含 页脚--%>
<%@include file="/pages/common/footer.jsp"%>

</body>
<script src="static/js/mall.js"></script>
</html>