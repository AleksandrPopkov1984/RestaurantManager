<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<hr/>

<section>
    <h2><spring:message code="${register ? 'profile.register' : 'profile.update'}"/></h2>
    <form method="post" action="${register ? 'profile/register' : 'profile'}">
        <input type="hidden" name="id" value="${userTo.id}">
        <dl>
            <dt><spring:message code="profile.surname"/></dt>
            <dd><input type="text" value="${userTo.surname}" name="surname" required></dd>
        </dl>
        <dl>
            <dt><spring:message code="profile.name"/></dt>
            <dd><input type="text" value="${userTo.name}" name="name" required></dd>
        </dl>
        <dl>
            <dt><spring:message code="profile.email"/></dt>
            <dd><input type="email" value="${userTo.email}" name="email" required></dd>
        </dl>
        <dl>
            <dt><spring:message code="profile.password"/></dt>
            <dd><input type="password" value="${userTo.password}" name="password" title="from 5 to 32 characters" required>
            </dd>
        </dl>
        <button type="submit"><spring:message code="common.save"/></button>
        <button onclick="window.history.back()" type="button"><spring:message code="common.cancel"/></button>
    </form>
</section>
</body>
</html>