<%@ page isErrorPage="true" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<section>
    <h3><spring:message code="enable.enableUser"/> ${user.id} ${user.surname} ${user.name}</h3>
    <jsp:useBean id="user" type="ru.popkov.restaurantmanager.to.UserTo" scope="request"/>
    <form method="post" action="admin/users/enabled?id=${user.id}">
        <input type="radio" id="true" name="radio_enabled" value="true" checked/><spring:message code="enable.true"/>
        <br/>
        <input type="radio" id="false" name="radio_enabled" value="false"/><spring:message code="enable.false"/>
        <br/>
        <br/>
        <button type="submit" value="Submit"><spring:message code="common.save"/></button>
        <button onclick="window.history.back()" type="button"><spring:message code="common.cancel"/></button>
    </form>
</section>
</body>
</html>