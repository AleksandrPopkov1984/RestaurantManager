<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<hr/>

<section>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <a href="admin/restaurants/create">Add restaurant</a>
        <br/>
        <br/>
    </sec:authorize>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Count of votes</th>
            <sec:authorize access="hasRole('ROLE_USER')">
                <th></th>
                <th></th>
            </sec:authorize>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <th></th>
                <th></th>
                <th></th>
            </sec:authorize>
        </tr>
        </thead>
        <c:forEach items="${requestScope.restaurants}" var="restaurant">
            <jsp:useBean id="restaurant" type="ru.popkov.restaurantmanager.to.RestaurantTo"/>
            <tr>
                <td>${restaurant.id}</td>
                <td>${restaurant.name}</td>
                <td>${restaurant.voteCount}</td>
                <sec:authorize access="hasRole('ROLE_USER')">
                    <td><a href="user/meals?restaurantId=${restaurant.id}">Open
                        Meals</a>
                    </td>
                    <td><a href="user/vote?restaurantId=${restaurant.id}">Vote</a>
                    </td>
                </sec:authorize>
                <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <td>
                        <a href="admin/restaurants/menus?restaurantId=${restaurant.id}">Open
                            menus</a></td>
                    <td>
                        <a href="admin/restaurants/update?id=${restaurant.id}">Update</a>
                    </td>
                    <td>
                        <a href="admin/restaurants/delete?id=${restaurant.id}">Delete</a>
                    </td>
                </sec:authorize>
            </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>