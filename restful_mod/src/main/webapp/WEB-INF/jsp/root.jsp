<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Root</title>
    <style>
        .note {
            background-color: beige;
            margin: 10px;
        }
    </style>
</head>
<body>

${pageContext.request.remoteUser} - User logged in is : <%= request.getRemoteUser()%>

<h3>Your notes</h3>
<c:forEach var="note" items="${user.notes}">
    <div class="note">
        Title : <c:out value="${note.title}"/><br/>
        Content : <c:out value="${note.content}"/><br/>
        Id : <c:out value="${note.id}"/><br/>
    </div>
</c:forEach>

<hr>

<a href="/api/createnote">Create note</a><br/>
<form action="/api/deletenote" method="post">
    Note id to delete : <input type="text" name="id"><br/>
    <input type="submit" value="Delete">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" class="form-control" />
</form>
<a href="/logout">Log out</a>

<hr>

</body>
</html>
