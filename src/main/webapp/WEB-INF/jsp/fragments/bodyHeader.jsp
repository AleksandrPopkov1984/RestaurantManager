<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<sec:authorize access="hasRole('ROLE_ADMIN')">
    <div class="header">
        <a href="admin/restaurants"><spring:message code="header.restaurants"/></a> |
        <a href="admin/users"><spring:message code="header.users"/></a> |
        <a href=""><spring:message code="header.home"/></a> |
        <a href="profile"><spring:message code="header.profile"/></a> |
        <a href="logout"><spring:message code="header.logout"/></a>
    </div>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_USER')">
    <div class="header">
        <a href="user/restaurants"><spring:message code="header.restaurants"/></a> |
        <a href="profile"><spring:message code="header.profile"/></a> |
        <a href="logout"><spring:message code="header.logout"/></a>
    </div>
</sec:authorize>