<%--
  Created by IntelliJ IDEA.
  User: Damian Grzybowski
  Date: 16.04.2023
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Student Form</title>
</head>
<body>
<form:form method="post" action="/student" modelAttribute="student">
    FirstName: <form:input path="firstName"/><br>
    LastName: <form:input path="lastName"/><br>
    Gender: <br>
    M <form:radiobutton path="gender" value="M"/> W <form:radiobutton path="gender" value="W"/><br>
    Country: <br>
    <form:select path="country">
        <form:option value="-" label="--Please Select--"/>
        <form:options items="${countries}"/>
    </form:select><br>
    Notes: <br>
    <form:textarea path="notes"/><br>
    MailingList: <form:checkbox path="mailingList"/><br>
    Programming skills: <br>
    <form:select path="programmingSkills" multiple="true">
        <form:options items="${programmingSkills}"/>
    </form:select><br>
    Hobbies: <br>
    <form:checkboxes path="hobbies" items="${hobbies}"/><br>
    <input type="submit">

</form:form>

</body>
</html>
