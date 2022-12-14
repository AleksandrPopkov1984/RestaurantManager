<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<section>
    <h3><a href="${pageContext.request.contextPath}">Home</a></h3>
    <hr/>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Id</th>
            <th>Surname</th>
            <th>Name</th>
            <th>Email</th>
            <th>Password</th>
            <th>Enabled</th>
            <th>Registered</th>
            <th>Roles</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <c:forEach items="${requestScope.users}" var="user">
            <jsp:useBean id="user" type="ru.popkov.restaurantmanager.to.UserTo"/>
            <tr>
                <td>${user.id}</td>
                <td>${user.surname}</td>
                <td>${user.name}</td>
                <td>${user.email}</td>
                <td>${user.password}</td>
                <td>${user.enabled}</td>
                <td>${user.registered}</td>
                <td>${user.roles}</td>
                <td><a href="${pageContext.request.contextPath}/users/update?id=${user.id}">Update</a></td>
                <td><a href="${pageContext.request.contextPath}/users/delete?id=${user.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>