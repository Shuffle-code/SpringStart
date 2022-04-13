<%--
  Created by IntelliJ IDEA.
  User: Evgeniy
  Date: 01.04.2022
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product</title>
</head>
<body>
<h2>Cart with product: ${addCartProduct}</h2>
<%--<h2> Product title: ${product.title}</h2>--%>
<%--<h2> Product price: ${product.price}</h2>--%>

<h2> Product title: ${product.title}</h2>
<h2> Product price: ${product.price}</h2>


<c:url var="deleteUrl" value="/products/delete">
    <c:param name="id" value="${product.id}"/>
</c:url>

<a href="${deleteUrl}">DELETE</a>

</body>
</html>
