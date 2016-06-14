<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Spring mvc form handling -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Create user</title>
</head>
<body>

<h1>Create a new note</h1>

<form:form commandName="noteForm" action="/api/createnote" method="post">
    Title:<form:input path="title"/>
    Content:<form:textarea path="content"/>
    <input hidden type="text" value="${pageContext.request.remoteUser}" name="username">
    <input type="submit" value="submit"/>
</form:form>

</body>
</html>
