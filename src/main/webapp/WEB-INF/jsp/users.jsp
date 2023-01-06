<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<hr/>

<section>
    <a href="admin/users/create"><spring:message code="user.add"/></a>
    <br/>
    <br/>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Id</th>
            <th><spring:message code="user.surname"/></th>
            <th><spring:message code="user.name"/></th>
            <th><spring:message code="user.email"/></th>
            <th><spring:message code="user.password"/></th>
            <th><spring:message code="user.enabled"/></th>
            <th><spring:message code="user.registered"/></th>
            <th><spring:message code="user.roles"/></th>
            <th><spring:message code="user.update"/></th>
            <th><spring:message code="user.delete"/></th>
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
                <td><a href="admin/users/update?id=${user.id}"><spring:message code="user.update"/></a></td>
                <td><a href="admin/users/delete?id=${user.id}"><spring:message code="user.delete"/></a></td>
            </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>