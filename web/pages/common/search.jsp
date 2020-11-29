<%--
  Created by IntelliJ IDEA.
  User: Ein
  Date: 2020/11/26
  Time: 23:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 搜索框 -->
<div class="search">
    <div class="search-body">
        <div class="input-group">
            <form action="client/bookServlet?action=pageByName" method="post">
                <input
                        type="text"
                        class="form-control"
                        id="myInput"
                        placeholder="输入你想要的商品"
                        name="keyword"
                        value="${requestScope.page.keyword}"
                />
                <button type="submit" class="btn-search btn"><i class="fa fa-search"></i></button>
            </form>
        </div>
    </div>
</div>
