<%--
  Created by IntelliJ IDEA.
  User: Damian Grzybowski
  Date: 16.04.2023
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Book update</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<form:form method="post" action="/bookForm/update" modelAttribute="bookToUpdate">
    <label for="title">Title</label>
    <form:input path="title" id="title"/><br>
    <form:errors path="title" cssClass="error"/><br>

    <label for="rating">Rating</label>
    <form:input path="rating" type="number" id="rating"/><br>
    <form:errors path="rating" cssClass="error"/><br>

    <label for="description">Description</label>
    <form:input path="description" id="description"/><br>
    <form:errors path="description" cssClass="error"/><br>

    <label for="publishers">Publishers</label>
    <form:select path="publisher.id" items="${publishers}" itemLabel="name" itemValue="id" id="publishers"/><br>
    <form:errors path="publisher" cssClass="error"/><br>

    <input type="submit">
</form:form>


</body>
</html>
