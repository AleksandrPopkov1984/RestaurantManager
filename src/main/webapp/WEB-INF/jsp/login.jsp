<%@ page isErrorPage="true" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>Login</title>
</head>
<body>

<div align="center">
    <h1>User login</h1>
</div>
<form method="post" action="spring_security_check">
    <p><label for="username">User:</label></p>
    <input type="text" id="username" name="username"/>
    <p><label for="password">Password:</label></p>
    <input type="password" id="password" name="password">
    <div>
        <p>
            <input name="submit" type="submit" value="Submit"/>
            <input name="reset" type="reset" value="Reset">
        </p>
    </div>
</form>
<c:if test="${param.error}">
    <p><font color="red">Invalid username / password</font></p>
</c:if>
</body>
</html>