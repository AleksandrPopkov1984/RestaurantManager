<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>

<section>
    <jsp:useBean id="meal" type="ru.popkov.restaurantmanager.to.MealTo" scope="request"/>
    <h3>${meal.id == null ? 'Add new meal' : 'Update meal'}</h3>
    <hr/>
    <form method="post" action="admin/restaurants/menus/menu?menuId=${meal.menu.id}">
        <input type="hidden" name="id" value="${meal.id}">
        <dl>
            <dt>Name</dt>
            <dd><input type="text" value="${meal.name}" name="name" required></dd>
        </dl>
        <dl>
            <dt>Price</dt>
            <dd><input type="number" value="${meal.price}" name="price" required></dd>
        </dl>
        <button type="submit">Save</button>
        <button onclick="window.history.back()" type="button">Cancel</button>
    </form>
</section>
</body>
</html>