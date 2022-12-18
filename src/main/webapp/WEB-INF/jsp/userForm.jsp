<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<body>

<section>
    <jsp:useBean id="user" type="ru.popkov.restaurantmanager.to.UserTo" scope="request"/>
    <h3>${user.id == null ? 'Add new user' : 'Update user'}</h3>
    <hr/>
    <form method="post" action="${pageContext.request.contextPath}/admin/users">
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
            <dd><input type="text" value="${user.password}" name="password" title="from 5 to 25 characters" required></dd>
        </dl>
        <dl>
            <dt>Enabled</dt>
            <dd><input type="text" value="${user.enabled}" name="enabled" required>
            </dd>
        </dl>
        <button type="submit">Save</button>
        <button onclick="window.history.back()" type="button">Cancel</button>
    </form>
</section>
</body>
</html>