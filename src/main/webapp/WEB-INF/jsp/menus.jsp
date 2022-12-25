<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Menus</title>
</head>
<body>
<section>
    <h3><a href="${pageContext.request.contextPath}">Home</a></h3>
    <hr/>
        <a href="${pageContext.request.contextPath}/admin/restaurants/menus/create?restaurantId=${restaurantId}">Add
            menu</a>
    <br/>
    <br/>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Id</th>
            <th>Date</th>
            <th>Restaurant</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <c:forEach items="${requestScope.menus}" var="menu">
            <jsp:useBean id="menu" type="ru.popkov.restaurantmanager.to.MenuTo"/>
            <tr>
                <td>${menu.id}</td>
                <td>${menu.date}</td>
                <td>${menu.restaurant.name}</td>
                <td><a href="${pageContext.request.contextPath}/admin/restaurants/menus/menu?menuId=${menu.id}">Show
                    meals</a></td>
                <td>
                    <a href="${pageContext.request.contextPath}/admin/restaurants/menus/delete?restaurantId=${menu.restaurant.id}&id=${menu.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <form method="get" action="${pageContext.request.contextPath}/admin/restaurants">
        <button type="submit">Ok</button>
    </form>
</section>
</body>
</html>