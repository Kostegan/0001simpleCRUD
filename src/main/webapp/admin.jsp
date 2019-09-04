<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Show All Students</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>Student ID</th>
        <th>Name</th>
        <th>Password</th>
        <th>Login</th>
        <th>Role</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td><c:out value="${user.id}"/></td>
            <td><c:out value="${user.name}"/></td>
            <td><c:out value="${user.password}"/></td>
            <td><c:out value="${user.login}"/></td>
            <td><c:out value="${user.role}"/></td>
            <td><a
                    href="edit?id=<c:out value="${user.id}"/>">Update</a></td>
            <td><a
                    href="delete?userId=<c:out value="${user.id }"/>">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p>
    <a href="addUser.jsp">Add User</a>
</p>
</body>
</html>