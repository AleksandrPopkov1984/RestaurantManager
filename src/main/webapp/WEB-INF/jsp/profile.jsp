<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Profile</title>
</head>
<body>
<section>
    <h3><a href="${pageContext.request.contextPath}">Home</a></h3>
    <hr/>
    <jsp:useBean id="user" type="ru.popkov.restaurantmanager.to.UserTo" scope="request"/>
    <h2>${register ? 'Register' : 'Update'}</h2>
    <form method="post" action="${pageContext.request.contextPath}/profile/register">
        <input type="hidden" name="id" value="${user.id}">
        <dl>
            <dt>Surname</dt>
            <dd><input type="text" value="${user.surname}" name="surname" required></dd>
        </dl>
        <dl>
            <dt>Name</dt>
            <dd><input type="text" value="${user.name}" name="name" required></dd>
        </dl>
        <dl>
            <dt>Email</dt>
            <dd><input type="email" value="${user.email}" name="email" required></dd>
        </dl>
        <dl>
            <dt>Password</dt>
            <dd><input type="text" value="${user.password}" name="password" title="from 5 to 32 characters" required>
            </dd>
        </dl>
        <button type="submit">Save</button>
        <button onclick="window.history.back()" type="button">Cancel</button>
    </form>
</section>
</body>
</html>
