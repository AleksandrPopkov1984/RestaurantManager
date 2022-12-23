<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Meals</title>
</head>
<body>
<section>
    <h3><a href="${pageContext.request.contextPath}">Home</a></h3>
    <hr/>
    <br>
    <c:forEach items="${requestScope.meals}" var="meal" end="0">
        <a href="${pageContext.request.contextPath}/admin/restaurants/menus/menu/create?menuId=${meal.menu.id}">Add meal</a>
    </c:forEach>
    <br/>
    <br/>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Price</th>
            <th>Update</th>
            <th>Delete</th>
        </tr>
        </thead>
        <c:forEach items="${requestScope.meals}" var="meal">
            <jsp:useBean id="meal" type="ru.popkov.restaurantmanager.to.MealTo"/>
            <tr>
                <td>${meal.id}</td>
                <td>${meal.name}</td>
                <td>${meal.price}</td>
                <td><a href="${pageContext.request.contextPath}/admin/restaurants/menus/menu/update?menuId=${meal.menu.id}&id=${meal.id}">Update</a></td>
                <td><a href="${pageContext.request.contextPath}/admin/restaurants/menus/menu/delete?menuId=${meal.menu.id}&id=${meal.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <button onclick="window.history.back()" type="button">Ok</button>
</section>
</body>
</html>