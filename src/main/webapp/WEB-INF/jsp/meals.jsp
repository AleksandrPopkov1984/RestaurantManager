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
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Name</th>
            <th>Price</th>
        </tr>
        </thead>
        <c:forEach items="${requestScope.meals}" var="meal">
            <jsp:useBean id="meal" type="ru.popkov.restaurantmanager.to.MealTo"/>
            <tr>
                <td>${meal.name}</td>
                <td>${meal.price}</td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <button onclick="window.history.back()" type="button">Ok</button>
</section>
</body>
</html>