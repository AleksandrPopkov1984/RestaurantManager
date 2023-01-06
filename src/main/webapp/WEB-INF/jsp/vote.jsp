<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>

<section>
    <h3>
        <c:choose>
            <c:when test="${isPermittedTime == false}">
                <spring:message code="vote.notPermittedTime"/> ${threshold}.
            </c:when>
            <c:otherwise>
                <jsp:useBean id="vote" type="ru.popkov.restaurantmanager.model.Vote" scope="request"/>
                <c:choose>
                    <c:when test="${updated == false}">
                        <spring:message code="vote.acceptPart1"/> "${vote.restaurant.name}" <spring:message code="vote.acceptPart2"/>
                    </c:when>
                    <c:otherwise>
                        Your vote has been changed to restaurant "${vote.restaurant.name}".
                    </c:otherwise>
                </c:choose>
            </c:otherwise>
        </c:choose>
    </h3>
    <br/>
    <form method="get" action="user/restaurants">
        <button type="submit"><spring:message code="vote.ok"/></button>
    </form>
</section>
</body>
</html>