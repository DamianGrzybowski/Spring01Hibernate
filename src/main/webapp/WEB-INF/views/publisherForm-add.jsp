<%--
  Created by IntelliJ IDEA.
  User: Damian Grzybowski
  Date: 29.04.2023
  Time: 12:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Publisher add form</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<form:form method="post" action="publisherForm" modelAttribute="publisher">

    <label for="name">Name</label>
    <form:input path="name" id="name"/><br>
    <form:errors path="name" cssClass="error"/><br>

    <label for="nip">Nip</label>
    <form:input path="nip" id="nip"/><br>
    <form:errors path="nip" cssClass="error"/><br>

    <label for="regon">Regon</label>
    <form:input path="regon" id="regon"/><br>
    <form:errors path="regon" cssClass="error"/><br>

    <input type="submit">



</form:form>

</body>
</html>
