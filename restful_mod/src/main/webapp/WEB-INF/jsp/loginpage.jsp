<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Spring mvc form handling -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!--<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<c:if test="${param.error != null}">
    <c:out value="ERROR RIGHT HERE, RIGHT NOW"></c:out>
</c:if>

<div>
    <form action="/login" method="post">
        <fieldset>
            <legend>Please Login</legend>

            <label for="username">Username</label>
            <input type="text" id="username" name="username"/>
            <label for="password">Password</label>
            <input type="password" id="password" name="password"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <div class="form-actions">
                <button type="submit" class="btn">Log in</button>
            </div>
        </fieldset>
    </form>
</div>
</body>
</html>