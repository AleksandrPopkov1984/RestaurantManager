<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>

<section>
    <jsp:useBean id="user" type="ru.popkov.restaurantmanager.to.UserTo" scope="request"/>
    <h3><spring:message code="${user.id == null ? 'user.addText' : 'user.updateText'}"/></h3>
    <hr/>
    <form method="post" action="admin/users">
        <input type="hidden" name="id" value="${user.id}">
        <dl>
            <dt><spring:message code="user.surname"/></dt>
            <dd><input type="text" value="${user.surname}" name="surname" required></dd>
        </dl>
        <dl>
            <dt><spring:message code="user.name"/></dt>
            <dd><input type="text" value="${user.name}" name="name" required></dd>
        </dl>
        <dl>
            <dt><spring:message code="user.email"/></dt>
            <dd><input type="email" value="${user.email}" name="email" required></dd>
        </dl>
        <dl>
            <dt><spring:message code="user.password"/></dt>
            <dd><input type="password" value="${user.password}" name="password" title="from 5 to 32 characters" required>
            </dd>
        </dl>
        <button type="submit"><spring:message code="common.save"/></button>
        <button onclick="window.history.back()" type="button"><spring:message code="common.cancel"/></button>
    </form>
</section>
</body>
</html>