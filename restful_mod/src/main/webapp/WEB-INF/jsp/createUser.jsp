<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Spring mvc form handling -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>Create new user</title>
</head>
<body>

<h1>Create new user</h1>

<form:form action="createUser" method="post" commandName="userForm">
    Username : <form:input path="name" />
    Password : <form:input path="password" />
    <input type="submit" value="submit">
</form:form>



</body>
</html>
