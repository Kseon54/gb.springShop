<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update product</title>
</head>
<body>
<form action="<c:url value="/product/${product.id}/update"/>" method="get">
    <p>Title:
        <label>
            <input type="text" name="title" value="${product.title}"/>
        </label>
    </p>
    <p>Cost:
        <label>
            <input type="number" name="cost" value="${product.cost}"/>
        </label>
    </p>
    <p> Manufacturer:
        <label>
            <select name="manufacturerId">
                <c:forEach items="${manufacturers}" var="manufacturer">
                    <c:if test="${manufacturer == product.manufacturer}">
                        <option selected value="<c:out value="${manufacturer.id}"/>"><c:out
                                value="${manufacturer.name}"/></option>
                    </c:if>
                    <c:if test="${manufacturer != product.manufacturer}">
                        <option value="<c:out value="${manufacturer.id}"/>"><c:out
                                value="${manufacturer.name}"/></option>
                    </c:if>
                </c:forEach>
            </select>
        </label>
    </p>
    <p> Status:
        <label>
            <select name="status">
                <c:forEach items="${statuses}" var="status">
                    <c:if test="${status != product.status}">
                        <option><c:out value="${status}"/></option>
                    </c:if>
                    <c:if test="${status == product.status}">
                        <option selected><c:out value="${status}"/></option>
                    </c:if>
                </c:forEach>
            </select>
        </label>
    </p>
    <p><input type="submit" value="Update"/> <input type="reset" value="Reset"/></p>
</form>
</body>
</html>
