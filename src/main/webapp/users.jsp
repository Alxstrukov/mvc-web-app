<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 14.08.2023
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<c:choose>
    <c:when test="${not empty users}">
        <h2>Users:</h2>
        <c:forEach var="user" items="${users}">
            <p>${user.id} ${user.name} ${user.email}</p>
        </c:forEach>
    </c:when>
    <c:otherwise>
        <p>${message}</p>
    </c:otherwise>
</c:choose>
</body>
</html>
