<%--
  Created by IntelliJ IDEA.
  User: Damian Grzybowski
  Date: 29.04.2023
  Time: 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Author form add</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<form:form method="post" action="/authorsForm" modelAttribute="author">

    <label for="firstName">First name</label>
    <form:input path="firstName" id="firstName"/><br>
    <form:errors path="firstName" cssClass="error"/><br>

    <label for="lastName">Last name</label>
    <form:input path="lastName" id="lastName"/><br>
    <form:errors path="lastName" cssClass="error"/><br>

    <label for="email">Email</label>
    <form:input path="email" id="email"/><br>
    <form:errors path="email" cssClass="error"/><br>

    <label for="pesel">Pesel</label>
    <form:input path="pesel" id="pesel"/><br>
    <form:errors path="pesel" cssClass="error"/><br>

    <input type="submit">

</form:form>

</body>
</html>
