<%--
  Created by IntelliJ IDEA.
  User: Damian Grzybowski
  Date: 16.04.2023
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Form</title>
</head>
<body>
<form:form action="/person" method="POST" modelAttribute="person">
    Login: <form:input path="login"/> <br>
    Password: <form:password path="password"/><br>
    Email: <form:input path="email"/><br>
    <input type="submit">
</form:form>

</body>
</html>
