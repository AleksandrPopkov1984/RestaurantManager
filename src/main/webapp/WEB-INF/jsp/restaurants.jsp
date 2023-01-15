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
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <a href="admin/restaurants/create"><spring:message code="restaurant.add"/></a>
    </sec:authorize>
    <br/>
    <br/>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th><spring:message code="restaurant.name"/></th>
            <th><spring:message code="restaurant.count"/></th>
            <sec:authorize access="hasRole('ROLE_USER')">
                <th><spring:message code="restaurant.showMeals"/></th>
                <th><spring:message code="restaurant.vote"/></th>
            </sec:authorize>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <th><spring:message code="restaurant.showMenus"/></th>
                <th><spring:message code="restaurant.update"/></th>
                <th><spring:message code="restaurant.delete"/></th>
            </sec:authorize>
        </tr>
        </thead>
        <c:forEach items="${requestScope.restaurants}" var="restaurant">
            <jsp:useBean id="restaurant" type="ru.popkov.restaurantmanager.to.RestaurantTo"/>
            <tr>
                <td>${restaurant.name}</td>
                <td>${restaurant.voteCount}</td>
                <sec:authorize access="hasRole('ROLE_USER')">
                    <td><a href="user/meals?restaurantId=${restaurant.id}"><spring:message
                            code="restaurant.showMeals"/></a>
                    </td>
                    <td><a href="user/vote?restaurantId=${restaurant.id}"><spring:message code="restaurant.vote"/></a>
                    </td>
                </sec:authorize>
                <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <td>
                        <a href="admin/restaurants/menus?restaurantId=${restaurant.id}"><spring:message
                                code="restaurant.showMenus"/></a></td>
                    <td>
                        <a href="admin/restaurants/update?id=${restaurant.id}"><spring:message
                                code="restaurant.update"/></a>
                    </td>
                    <td>
                        <a href="admin/restaurants/delete?id=${restaurant.id}"><spring:message
                                code="restaurant.delete"/></a>
                    </td>
                </sec:authorize>
            </tr>
        </c:forEach>
    </table>
    <sec:authorize access="hasRole('ROLE_USER')">
        <br/>
        <br/>
        <a href="swagger-ui.html"><spring:message code="common.swagger"/></a>
    </sec:authorize>
</section>
</body>
</html>