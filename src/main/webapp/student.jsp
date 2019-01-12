<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <title>Add New Student</title>
</head>
<body>
<form action="StudentController" method="post">
    <fieldset>
        <div>
            <label for="id">Student ID</label> <input type="text" id="id"
                                                             name="id" value="<c:out value="${student.id}" />"
                                                             readonly="readonly" placeholder="ID" />
        </div>
        <div>
            <label for="name">Student Name</label> <input type="text" id="name"
                                                             name="name" value="<c:out value="${student.name}" />"
                                                             placeholder="Name" />
        </div>
        <div>
            <label for="password">Student Password</label> <input type="text" id="password"
                                                           name="password" value="<c:out value="${student.password}" />"
                                                           placeholder="Password" />
        </div>
        <div>
            <label for="login">Student Login</label> <input type="text" name="login" id="login"
                                                      value="<c:out value="${student.login}" />" placeholder="Login" />
        </div>
        <div>
            <input type="submit" value="Submit" />
        </div>
    </fieldset>
</form>
</body>
</html>
