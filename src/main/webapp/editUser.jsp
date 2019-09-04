<%@ page import="com.junald.model.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kos
  Date: 13.01.2019
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% User user = (User) request.getAttribute("user"); %>
<%=user.getId()%>
<form action="edit" method="post">
    <fieldset>
        <div>
            <label for="name">User name</label> <input id="name" type="text" name="name" value="<%=user.getName()%>">
        </div>
        <div>
            <label for="password">Student Password</label> <input type="text" id="password" name="password"
                                                                  value="<%=user.getPassword()%>"/>
        </div>
        <div>
            <label for="login">Student Login</label> <input type="text" name="login" id="login"
                                                            value="<%=user.getLogin()%>"/>
        </div>
        <div>
            <td>Role:</td>
            <td><input type="radio" name="role" value="user" checked>user</input><br>
                <input type="radio" name="role" value="admin">admin</input>
            </td>
        </div>
        <div>
            <button type="submit" name="id" value="<%=user.getId()%>">Submit</button>
        </div>

    </fieldset>
</form>
</body>
</html>
