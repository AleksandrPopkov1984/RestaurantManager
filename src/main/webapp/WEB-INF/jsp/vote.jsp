<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>

<section>
    <h3>
        <c:choose>
            <c:when test="${isPermittedTime == false}">
                It is not permitted time for changing your vote.
                Please, vote again until 11-00.
            </c:when>
            <c:otherwise>
                <jsp:useBean id="vote" type="ru.popkov.restaurantmanager.model.Vote" scope="request"/>
                <c:choose>
                    <c:when test="${updated == false}">
                        Your vote of restaurant "${vote.restaurant.name}" has been accepted.
                    </c:when>
                    <c:otherwise>
                        Your vote has been changed to restaurant "${vote.restaurant.name}."
                    </c:otherwise>
                </c:choose>
            </c:otherwise>
        </c:choose>
    </h3>
    <br/>
    <form method="get" action="${pageContext.request.contextPath}/user/restaurants">
        <button type="submit">Ok</button>
    </form>
</section>
</body>
</html>