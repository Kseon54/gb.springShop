<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products</title>
    <style>
        table {
            border-spacing: 7px 11px; /* Расстояние между ячейками */
        }
    </style>
</head>
<body>
<a href="<c:url value="/product/add"/>">Add product</a>
<table>
    <tr>
        <th>Id</th>
        <th>Title</th>
        <th>Cost</th>
        <th>Manufacturer</th>
        <th>Date add</th>
    </tr>

    <%--@elvariable id="products" type="java.util.List"--%>
    <c:forEach items="${products}" var="product">
        <tr>
            <td><c:out value="${product.id}"/></td>
            <td><c:out value="${product.title}"/></td>
            <td><c:out value="${product.cost}"/></td>
            <td><c:out value="${product.manufacturer.name}"/></td>
            <td><c:out value="${product.date}"/></td>
            <td>
                    <input type="submit" value="Update"
                           onclick="location.href = '<c:url value="/product/${product.id}/updateForm"/>';"/>
            </td>
            <td>
                <c:if test="${'ACTIVE' == product.status}">
                    <input type="submit" value="Disable"
                           onclick="location.href = '<c:url value="/product/${product.id}/disable"/>';"/>
                </c:if>
                <c:if test="${'DISABLE' == product.status}">
                    <input type="submit" value="Active"
                           onclick="location.href = '<c:url value="/product/${product.id}/active"/>';"/>
                </c:if>
            </td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
