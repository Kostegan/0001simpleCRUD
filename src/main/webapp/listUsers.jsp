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
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="userDataSet">
        <tr>
            <td><c:out value="${userDataSet.id}"/></td>
            <td><c:out value="${userDataSet.name}"/></td>
            <td><c:out value="${userDataSet.password}"/></td>
            <td><c:out value="${userDataSet.login}"/></td>
            <td><a
                    href="edit?userId=<c:out value="${userDataSet.id}"/>">Update</a></td>
            <td><a
                    href="delete?userId=<c:out value="${userDataSet.id }"/>">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p>
    <a href="addUser.jsp">Add User</a>
</p>
</body>
</html>