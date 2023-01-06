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
    <a href="admin/restaurants/menus/create?restaurantId=${restaurantId}">
        <spring:message code="menu.add"/></a>
    <br/>
    <br/>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Id</th>
            <th><spring:message code="menu.date"/></th>
            <th><spring:message code="menu.restaurant"/></th>
            <th><spring:message code="menu.showMeals"/></th>
            <th><spring:message code="menu.delete"/></th>
        </tr>
        </thead>
        <c:forEach items="${requestScope.menus}" var="menu">
            <jsp:useBean id="menu" type="ru.popkov.restaurantmanager.to.MenuTo"/>
            <tr>
                <td>${menu.id}</td>
                <td>${menu.date}</td>
                <td>${menu.restaurant.name}</td>
                <td><a href="admin/restaurants/menus/menu?menuId=${menu.id}"><spring:message code="menu.showMeals"/></a></td>
                <td>
                    <a href="admin/restaurants/menus/delete?restaurantId=${menu.restaurant.id}&id=${menu.id}">
                        <spring:message code="menu.delete"/></a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <form method="get" action="admin/restaurants">
        <button type="submit"><spring:message code="common.back"/></button>
    </form>
</section>
</body>
</html>