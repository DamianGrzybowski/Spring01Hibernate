<%--
  Created by IntelliJ IDEA.
  User: Damian Grzybowski
  Date: 16.04.2023
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All authors</title>
</head>
<body>
<c:forEach items="${authors}" var="author">
    First name: ${author.firstName}, Last name: ${author.lastName} <a href="/authorsForm/update?id=${author.id}">Update</a><br>
</c:forEach>


</body>
</html>
