<%--
  Created by IntelliJ IDEA.
  User: Ein
  Date: 2020/11/23
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName()
            + ":" + request.getServerPort() +request.getContextPath() + "/";
%>
<!--base标签，固定相对路径跳转结果-->
<base href="<%=basePath%>">

