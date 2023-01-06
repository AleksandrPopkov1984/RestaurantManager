<%@ page isErrorPage="true" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>

<div align="center">
    <h1><spring:message code="app.title"/></h1>
</div>
<c:if test="${not empty param.message}">
    <h3><font color="green"><spring:message code="login.registerInformation"/></font></h3>
</c:if>
<form method="post" action="spring_security_check">
    <p><label for="username"><spring:message code="login.login"/></label></p>
    <input type="text" id="username" name="username" value="${param.username}"/>
    <p><label for="password"><spring:message code="login.password"/></label></p>
    <input type="password" id="password" name="password">
    <div>
        <p>
            <input name="submit" type="submit" value="<spring:message code="login.submit"/>"/>
            <input name="reset" type="reset" value="<spring:message code="login.reset"/>"/>
        </p>
    </div>
</form>
<br/>
<br/>
<form method="get" action="profile/register">
    <button type="submit"><spring:message code="login.register"/></button>
</form>
<c:if test="${param.error}">
    <p><font color="red"><spring:message code="login.invalidData"/></font></p>
</c:if>
</body>
</html>