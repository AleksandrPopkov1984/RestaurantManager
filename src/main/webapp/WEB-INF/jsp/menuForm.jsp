<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>

<section>
    <jsp:useBean id="menu" type="ru.popkov.restaurantmanager.to.MenuTo" scope="request"/>
    <h3>Add new menu</h3>
    <hr/>
    <form method="post"
          action="admin/restaurants/menus?restaurantId=${menu.restaurant.id}">
        <input type="hidden" name="id" value="${menu.id}">
        <dl>
            <dt>Date</dt>
            <dd><input type="date" value="${menu.date}" name="date" required></dd>
        </dl>
        <button type="submit">Save</button>
        <button onclick="window.history.back()" type="button">Cancel</button>
    </form>
</section>
</body>
</html>