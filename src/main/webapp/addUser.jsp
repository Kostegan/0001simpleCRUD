<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kos
  Date: 13.01.2019
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="add" method="post">
    <fieldset>
        <div>
            <label for="name">Student Name</label> <input type="text" id="name"
                                                          name="name"
                                                          placeholder="Name"/>
        </div>
        <div>
            <label for="password">Student Password</label> <input type="text" id="password"
                                                                  name="password"
                                                                  placeholder="Password"/>
        </div>
        <div>
            <label for="login">Student Login</label> <input type="text" name="login" id="login"
                                                            placeholder="Login"/>
        </div>
        <div>
            <input type="submit" value="Submit"/>
        </div>
    </fieldset>
</form>
</body>
</html>
