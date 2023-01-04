<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<sec:authorize access="hasRole('ROLE_ADMIN')">
    <a href="admin/restaurants">Restaurants</a> |
    <a href="admin/users">Users</a> |
    <a href="">Home</a> |
    <a href="profile">Profile</a> |
    <a href="logout">Logout</a>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_USER')">
    <a href="user/restaurants">Restaurants</a> |
    <a href="profile">Profile</a> |
    <a href="logout">Logout</a>
</sec:authorize>