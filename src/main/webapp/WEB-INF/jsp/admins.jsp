<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<hr/>

<section>
    <h2>Admin page</h2>
    <br/>
    <form method="get" action="admin/users">
        <button type="submit">Users</button>
        Show list of users
    </form>
    <br/>
    <form method="get" action="admin/restaurants">
        <button type="submit">Restaurants</button>
        Show list of restaurants
    </form>
</section>
</body>
</html>
