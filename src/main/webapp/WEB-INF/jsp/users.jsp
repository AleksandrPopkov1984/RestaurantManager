<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<section>
    <h3><a href="">Home</a></h3>
    <hr/>
    <a href="admin/users/create">Add user</a>
    <br/>
    <br/>
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
            <jsp:useBean id="user" type="ru.popkov.restaurantmanager.to.UserToWithFullData"/>
            <tr>
                <td>${user.id}</td>
                <td>${user.surname}</td>
                <td>${user.name}</td>
                <td><a href="mailto:${user.email}">${user.email}</a></td>
                <td>${user.password}</td>
                <td><a href="admin/users/enable?id=${user.id}">${user.enabled}</a>
                </td>
                <td><fmt:formatDate value="${user.registered}" pattern="dd-MM-yyyy"/></td>
                <td>${user.roles}</td>
                <td><a href="admin/users/update?id=${user.id}">Update</a></td>
                <td><a href="admin/users/delete?id=${user.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>