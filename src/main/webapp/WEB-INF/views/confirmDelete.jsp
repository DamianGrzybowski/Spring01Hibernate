<%--
  Created by IntelliJ IDEA.
  User: Damian Grzybowski
  Date: 16.04.2023
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirm Delete</title>
</head>
<body>
<a href="/bookForm/delete?id=${bookToDelete.id}">Potwierdź</a><br>
<a href="/bookForm/all">Anuluj</a>

</body>
</html>
