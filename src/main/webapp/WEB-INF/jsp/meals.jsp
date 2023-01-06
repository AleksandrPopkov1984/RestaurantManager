<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<hr/>

<section>
    <br>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <c:forEach items="${requestScope.meals}" var="meal" end="0">
            <a href="admin/restaurants/menus/menu/create?menuId=${meal.menu.id}">
                <spring:message code="meal.add"/></a>
        </c:forEach>
    </sec:authorize>
    <br/>
    <br/>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Id</th>
            <th><spring:message code="meal.name"/></th>
            <th><spring:message code="meal.price"/></th>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <th><spring:message code="meal.update"/></th>
                <th><spring:message code="meal.delete"/></th>
            </sec:authorize>
        </tr>
        </thead>
        <c:forEach items="${requestScope.meals}" var="meal">
            <jsp:useBean id="meal" type="ru.popkov.restaurantmanager.to.MealTo"/>
            <tr>
                <td>${meal.id}</td>
                <td>${meal.name}</td>
                <td>${meal.price}</td>
                <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <td>
                        <a href="admin/restaurants/menus/menu/update?menuId=${meal.menu.id}&id=${meal.id}"><spring:message code="meal.update"/></a>
                    </td>
                    <td>
                        <a href="admin/restaurants/menus/menu/delete?menuId=${meal.menu.id}&id=${meal.id}"><spring:message code="meal.delete"/></a>
                    </td>
                </sec:authorize>
            </tr>
        </c:forEach>
    </table>
    <br>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <form method="get" action="admin/restaurants/menus">
            <input type="hidden" name="restaurantId" id="restaurantId" value="${restaurantId}"/>
            <button type="submit"><spring:message code="common.back"/></button>
        </form>
    </sec:authorize>
    <sec:authorize access="hasRole('ROLE_USER')">
        <form method="get" action="user/restaurants/">
            <button type="submit"><spring:message code="common.back"/></button>
        </form>
    </sec:authorize>
</section>
</body>
</html>