<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Admins</title>
</head>
<body>
<section>
    <h3><a href="${pageContext.request.contextPath}">Home</a></h3>
    <hr/>
    <br/>

    <form method="post" action="users">
        <button type="submit">Users</button>
        Show list of users
    </form>
    <br/>
    <form method="post" action="menus">
        <button type="submit">Menus</button>
        Show list of menus
    </form>
    <br/>
    <form method="post" action="restaurants">
        <button type="submit">Restaurants</button>
        Show list of restaurants
    </form>
</section>
</body>
</html>
