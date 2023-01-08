<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<hr/>

<section>
    <h2 class="header_h2"><spring:message code="admin.page"/></h2>
    <br/>
    <form method="get" action="admin/users">
        <button type="submit" class="admin_buttons"><spring:message code="admin.users"/></button>
        <spring:message code="admin.usersText"/>
    </form>
    <br/>
    <form method="get" action="admin/restaurants">
        <button type="submit" class="admin_buttons"><spring:message code="admin.restaurants"/></button>
        <spring:message code="admin.restaurantsText"/>
</section>
</body>
</html>
