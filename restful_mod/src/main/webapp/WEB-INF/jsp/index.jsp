<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Main</title>
</head>
<body>
<p>Message : ${message}</p>
<ul>
    <c:forEach var="user" items="${users}">
        <li><c:out value="${user.name}"/></li>
    </c:forEach>
</ul>
</body>
</html>
