<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update product</title>
</head>
<body>
<form action="<c:url value="/product/${product.id}/update"/>" method="get">
    <p>Title: <input type="text" name="title" value="${product.title}"/></p>
    <p>Cost: <input type="number" name="cost" value="${product.cost}"/></p>
    <p> Manufacturer: <select name="manufacturerId">
        <c:forEach items="${manufacturers}" var="manufacturer">
            <c:if test="anufacturer.id != product.manufacturer.id">
            <option value="<c:out value="${manufacturer.id}"/>"><c:out value="${manufacturer.name}"/></option>
            </c:if>
            <c:if test="${manufacturer == product.manufacturer}">
                <option selected value="<c:out value="${manufacturer.id}"/>"><c:out value="${manufacturer.name}"/></option>
            </c:if>
            <c:if test="${manufacturer != product.manufacturer}">
                <option value="<c:out value="${manufacturer.id}"/>"><c:out value="${manufacturer.name}"/></option>
            </c:if>
        </c:forEach>
    </select>
    </p>
    <p><input type="submit" value="Update"/> <input type="reset" value="Reset"/></p>
</form>
</body>
</html>
