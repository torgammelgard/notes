<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Spring mvc form handling -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Login Page</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
    <script>
        $(document).ready(function () {
            // TODO show error message div with message if login error exists.
        });
    </script>
</head>
<body>


<h1>Login</h1>
<div id="error"></div>

<form:form action="/login" method="post" commandName="userForm">
    <form:input path="name" type="text" placeholder="Username"/>
    <form:input path="password" type="password" placeholder="Password"/>
    <input type="submit" value="Submit">
</form:form>

<a href="/createUser">Create new user</a>

</body>
</html>
