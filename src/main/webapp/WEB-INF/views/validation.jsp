<%--
  Created by IntelliJ IDEA.
  User: Damian Grzybowski
  Date: 29.04.2023
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Validation</title>
</head>
<body>
<c:forEach var="v" items="${validations}">
    ${v.key} : ${v.value} <br>
</c:forEach>


</body>
</html>
