<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/9/10
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<h1>网站有以下功能：</h1>
<a href="${pageContext.request.contextPath}/product/add">商品添加</a>
<a href="${pageContext.request.contextPath}/product/update">商品修改</a>
<a href="${pageContext.request.contextPath}/product/delete">商品删除</a>
<a href="${pageContext.request.contextPath}/product/list">商品列表</a>
</body>
</html>
