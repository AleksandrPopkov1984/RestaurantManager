<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>

<section>
    <jsp:useBean id="restaurant" type="ru.popkov.restaurantmanager.to.RestaurantTo" scope="request"/>
    <h3><spring:message code="${restaurant.id == null ? 'restaurant.addText' : 'restaurant.updateText'}"/></h3>
    <hr/>
    <form method="post" action="admin/restaurants">
        <input type="hidden" name="id" value="${restaurant.id}">
        <dl>
            <dt><spring:message code="restaurant.name"/></dt>
            <dd><input type="text" value="${restaurant.name}" name="name" required></dd>
        </dl>
        <br/>
        <button type="submit"><spring:message code="common.save"/></button>
        <button onclick="window.history.back()" type="button"><spring:message code="common.cancel"/></button>
    </form>
</section>
</body>
</html>