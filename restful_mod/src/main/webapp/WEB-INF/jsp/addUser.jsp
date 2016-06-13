<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Spring mvc form handling -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>Main page</title>
</head>
<body>

<h1>This is the main page</h1>

<form:form action="addUser" method="post" commandName="userForm">
    Username : <form:input path="name" />
    <input type="submit" value="submit">
</form:form>

</body>
</html>
