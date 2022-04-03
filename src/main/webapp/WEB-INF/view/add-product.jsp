<%--
  Created by IntelliJ IDEA.
  User: Evgeniy
  Date: 01.04.2022
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add Product</title>
</head>
<body>

<form:form action="add" modelAttribute="product">
    <form:hidden path="id" value="${product.id}"/>
    Title: <form:input path="title"/>
    <br>
    Cost: <form:input path="price"/>
    <br>
    <input type="submit" value="Save"/>
</form:form>
</body>

</html>
