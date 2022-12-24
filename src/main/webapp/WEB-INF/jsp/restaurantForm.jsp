<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<body>

<section>
    <jsp:useBean id="restaurant" type="ru.popkov.restaurantmanager.to.RestaurantTo" scope="request"/>
    <h3>${restaurant.id == null ? 'Add new restaurant' : 'Update restaurant'}</h3>
    <hr/>
    <form method="post" action="${pageContext.request.contextPath}/admin/restaurants">
        <input type="hidden" name="id" value="${restaurant.id}">
        <dl>
            <dt>Name</dt>
            <dd><input type="text" value="${restaurant.name}" name="name" required></dd>
        </dl>
        <button type="submit">Save</button>
        <button onclick="window.history.back()" type="button">Cancel</button>
    </form>
</section>
</body>
</html>