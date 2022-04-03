<%--
  Created by IntelliJ IDEA.
  User: Evgeniy
  Date: 01.04.2022
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<h1>Product List:</h1>
<ul>
    <c:forEach var="product" items="${products}">
        <li>${product.toString()}</li>
        <br>
    </c:forEach>
</ul>
<br>
<c:url var="addProductUrl" value="/products/add"/>
<a href="${addProductUrl}">Add Product</a>

<h4>Products: ${products}</h4>
</body>
</html>
