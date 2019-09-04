<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kos
  Date: 13.02.2019
  Time: 12:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<p>Hello, <c:out value="${startUser.name}"/> </p>
<table>
    <thead>
    <tr>
        <th>Name:</th>
        <th>Login:</th>
        <th>Password:</th>
    </tr>
    </thead>
    <tbody>
        <tr>
            <td><c:out value="${startUser.name}"/></td>
            <td><c:out value="${startUser.login}"/></td>
            <td><c:out value="${startUser.password}"/></td>
            <td><c:out value="${startUser.role}"/></td>
        </tr>
    </tbody>
</table>
</body>
</html>
