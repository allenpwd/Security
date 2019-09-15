<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/9/10
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
你好，${username}<br/>
<h1>网站有以下功能：</h1>
<sec:authorize access="hasAuthority('PRODUCT_LIST')">
    <a href="${pageContext.request.contextPath}/product/list">商品列表</a>
</sec:authorize>
<sec:authorize access="hasAuthority('PRODUCT_ADD')">
    <a href="${pageContext.request.contextPath}/product/add">商品添加</a>
</sec:authorize>
<sec:authorize access="hasAuthority('PRODUCT_UPDATE')">
    <a href="${pageContext.request.contextPath}/product/update">商品修改</a>
</sec:authorize>
<sec:authorize access="hasAuthority('PRODUCT_DELETE')">
    <a href="${pageContext.request.contextPath}/product/delete">商品删除</a>
</sec:authorize>
</body>
</html>
