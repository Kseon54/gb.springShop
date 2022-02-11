<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add product</title>
</head>
<body>
<form action="<c:url value="/product/addProduct"/>" method="get">
    <p>Title: <input type="text" name="title"/></p>
    <p>Cost: <input type="number" name="cost"/></p>
    <p> Manufacturer: <select name="manufacturerId">
        <c:forEach items="${manufacturers}" var="manufacturer">
            <option value="<c:out value="${manufacturer.id}"/>"><c:out value="${manufacturer.name}"/></option>
        </c:forEach>
    </select>
    </p>
    <p><input type="submit" value="Add"/> <input type="reset" value="Reset"/></p>
</form>
</body>
</html>
