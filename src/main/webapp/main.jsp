<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %> --%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:set var="number" value="2"/>
<c:set var="result" value="${number + 25}"/>
<p>result = ${result}</p>
<%-- <c:remove var="number"/> --%>
<c:if test="${not empty number}">
    <p>found</p>
</c:if>

<c:choose>
    <c:when test="${number == 1}">
        <p>equals 1</p>
    </c:when>
    <c:when test="${number == 2}">
        <p>equals 2</p>
    </c:when>
    <c:otherwise>
        <p>not equals 1 or 2</p>
    </c:otherwise>
</c:choose>

        <c:url var="linkURL" value="http://yandex.ru"/>
        This is the <a href="${linkURL}">link</a>
        <br>
        <c:url var="linkURL" value="http://yandex.ru">
            <c:param name="parameter" value="15"/>
        </c:url>
        This is the <a href="${linkURL}">link</a>
    <ol>
        <c:forEach var="cook" items="${cookie}">
            <li>
                <p><c:out value="${cook.value.name}"/></p>
                <p><c:out value="${cook.value.name}"/></p>
            </li>
        </c:forEach>
    </ol>

</body>
</html>
