<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Restaurants</title>
    <base href="${pageContext.request.contextPath}/">
</head>
<body>
<section>
    <h3><a href="${pageContext.request.contextPath}">Home</a></h3>
    <hr/>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <c:forEach items="${requestScope.restaurants}" var="restaurant">
            <jsp:useBean id="restaurant" type="ru.popkov.restaurantmanager.to.RestaurantTo"/>
            <tr>
                <td>${restaurant.id}</td>
                <td>${restaurant.name}</td>
                <td><a href="users/meals?restaurantId=${restaurant.id}">Open Food</a></td>
                <td><a href="${pageContext.request.contextPath}/users/vote?id=${restaurant.id}">Vote</a></td>
            </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>