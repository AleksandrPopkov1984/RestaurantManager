<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<hr/>

<section>
    <h2>${register ? 'Register' : 'Update'}</h2>
    <form method="post" action="${register ? 'profile/register' : 'profile'}">
        <input type="hidden" name="id" value="${userTo.id}">
        <dl>
            <dt>Surname</dt>
            <dd><input type="text" value="${userTo.surname}" name="surname" required></dd>
        </dl>
        <dl>
            <dt>Name</dt>
            <dd><input type="text" value="${userTo.name}" name="name" required></dd>
        </dl>
        <dl>
            <dt>Email</dt>
            <dd><input type="email" value="${userTo.email}" name="email" required></dd>
        </dl>
        <dl>
            <dt>Password</dt>
            <dd><input type="password" value="${userTo.password}" name="password" title="from 5 to 32 characters" required>
            </dd>
        </dl>
        <button type="submit">Save</button>
        <button onclick="window.history.back()" type="button">Cancel</button>
    </form>
</section>
</body>
</html>
