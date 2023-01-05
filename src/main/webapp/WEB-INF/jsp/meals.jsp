<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<hr/>

<section>
    <br>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <c:forEach items="${requestScope.meals}" var="meal" end="0">
            <a href="admin/restaurants/menus/menu/create?menuId=${meal.menu.id}">Add
                meal</a>
        </c:forEach>
    </sec:authorize>
    <br/>
    <br/>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Price</th>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <th>Update</th>
                <th>Delete</th>
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
                        <a href="admin/restaurants/menus/menu/update?menuId=${meal.menu.id}&id=${meal.id}">Update</a>
                    </td>
                    <td>
                        <a href="admin/restaurants/menus/menu/delete?menuId=${meal.menu.id}&id=${meal.id}">Delete</a>
                    </td>
                </sec:authorize>
            </tr>
        </c:forEach>
    </table>
    <br>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <form method="get" action="admin/restaurants/menus">
            <input type="hidden" name="restaurantId" id="restaurantId" value="${restaurantId}"/>
            <button type="submit">Back</button>
        </form>
    </sec:authorize>
    <sec:authorize access="hasRole('ROLE_USER')">
        <form method="get" action="user/restaurants/">
            <button type="submit">Back</button>
        </form>
    </sec:authorize>
</section>
</body>
</html>