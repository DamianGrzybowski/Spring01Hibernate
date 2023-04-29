<%--
  Created by IntelliJ IDEA.
  User: Damian Grzybowski
  Date: 29.04.2023
  Time: 12:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All publishers</title>
</head>
<body>
<c:forEach var="publisher" items="${publishers}">
Name: ${publisher.name} <a href="/publisherForm/update?id=${publisher.id}">Update</a><br>
</c:forEach>

</body>
</html>
