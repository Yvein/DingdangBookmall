<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Ein
  Date: 2020/11/26
  Time: 1:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="page-num">
    <nav>
        <ul class="pagination">
            <c:if test="${requestScope.page.pageNow > 1}">
                <li>
                    <a href="${requestScope.page.url}&pageNow=1">
                        <span>首页</span>
                    </a>
                </li>
                <li>
                    <a href="${requestScope.page.url}&pageNow=${requestScope.page.pageNow - 1}">
                        <span>&laquo;</span>
                    </a>
                </li>
                <li>
                    <a href="${requestScope.page.url}&pageNow=${requestScope.page.pageNow - 1}">
                        <span>${requestScope.page.pageNow - 1}</span>
                    </a>
                </li>
            </c:if>

            <li class="active">
                <a href="${requestScope.page.url}&pageNow=${requestScope.page.pageNow}">${requestScope.page.pageNow}</a>
            </li>

            <c:if test="${requestScope.page.pageNow < requestScope.page.pageNum}">
                <li>
                    <a href="${requestScope.page.url}&pageNow=${requestScope.page.pageNow + 1}">
                        <span>${requestScope.page.pageNow + 1}</span>
                    </a>
                </li>
                <li>
                    <a href="${requestScope.page.url}&pageNow=${requestScope.page.pageNow + 1}">
                        <span>&raquo;</span>
                    </a>
                </li>
                <li>
                    <a href="${requestScope.page.url}&pageNow=${requestScope.page.pageNum}">
                        <span>末页</span>
                    </a>
                </li>
            </c:if>

        </ul>
    </nav>
</div>
