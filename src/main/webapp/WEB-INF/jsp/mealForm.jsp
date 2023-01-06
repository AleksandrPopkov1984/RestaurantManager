<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>

<section>
    <jsp:useBean id="meal" type="ru.popkov.restaurantmanager.to.MealTo" scope="request"/>
    <h3><spring:message code="${meal.id == null ? 'meal.addText' : 'meal.updateText'}"/></h3>
    <hr/>
    <form method="post" action="admin/restaurants/menus/menu?menuId=${meal.menu.id}">
        <input type="hidden" name="id" value="${meal.id}">
        <dl>
            <dt><spring:message code="meal.name"/></dt>
            <dd><input type="text" value="${meal.name}" name="name" required></dd>
        </dl>
        <dl>
            <dt><spring:message code="meal.price"/></dt>
            <dd><input type="number" value="${meal.price}" name="price" required></dd>
        </dl>
        <button type="submit"><spring:message code="common.save"/></button>
        <button onclick="window.history.back()" type="button"><spring:message code="common.cancel"/></button>
    </form>
</section>
</body>
</html>