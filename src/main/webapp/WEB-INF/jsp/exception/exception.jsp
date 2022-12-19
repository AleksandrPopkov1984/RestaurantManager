<%@ page isErrorPage="true" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<body>
<h2>Application error:</h2>
<br/><br/>
<table border="1" cellpadding="8" cellspacing="0">
    <thead>
    <tr>
        <th>URL</th>
        <th>Detail</th>
    </tr>
    </thead>
    <tr>
        <td>${errorInfo.url}</td>
        <td>${errorInfo.detail}</td>
    </tr>
</table>
</section>
</body>
</html>