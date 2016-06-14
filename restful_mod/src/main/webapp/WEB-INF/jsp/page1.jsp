<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Page 1</title>
    <style>
        .main {
            width: 80%;
            background-color: darkseagreen;
            margin: 0 auto;
        }
        ul {
            margin: 0 auto;
        }
        .note {
            background-color: aquamarine;
            border: 2px solid darkblue;
        }
    </style>
</head>
<body>

<div class="main">
    <h1>Your notes</h1>
    <ul>
        <c:forEach var="note" items="${user.notes}">
            <li class="note"><c:out value="${note.content}"/><c:out value="${note.id}"/></li>
        </c:forEach>
    </ul>

    <a href="/api/createnote">Create note</a>


</div>
</body>
</html>
