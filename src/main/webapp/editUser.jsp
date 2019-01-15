<%@ page import="com.junald.model.Student" %>
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
<% Student student = (Student) request.getAttribute("users"); %>
<form action="edit" method="post">
    <fieldset>
        <div>
            <label for="name">Student Name</label> <input type="text" id="name"
                                                          name="name" value="<%=student.getName()%>"/>
        </div>
        <div>
            <label for="password">Student Password</label> <input type="text" id="password" name="password"
                                                                  value="<%=student.getPassword()%>"/>
        </div>
        <div>
            <label for="login">Student Login</label> <input type="text" name="login" id="login"
                                                            value="<%=student.getLogin()%>"/>
        </div>
        <div>
            <input type="submit" value="Submit"/>
        </div>
    </fieldset>
</form>
</body>
</html>
