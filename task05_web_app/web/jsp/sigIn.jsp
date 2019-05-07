<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>My super project!</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" href="http://localhost:8080/sigIn/css/signin.css" type="text/css"/>
    <link href="https://fonts.googleapis.com/css?family=Play" rel="stylesheet"/>
    <link rel="shortcut icon" href="images/image-icon.ico" type="image/x-icon">
</head>
<body>
    <div class="signIn">
        <c:url value="/login.html" var="loginURL"/>
        <form action="${loginURL}" method="post">
            <h2 style="color:white">Log In</h2>
            <input type="hidden" name="command" value="login" />
            <input type="text" name="login" placeholder="Username" required><br><br>
            <input type="password" name="password" placeholder="Password" required><br><br>
            <input type="reset" value="Reset"><br><br>
            <a><input type="submit" value="Log in"></a><br>
            <div style="color:#60c9a8; font-size: 18px;">
                ${errorLoginPassMessage}
                ${wrongAction}
                ${nullPage}
            </div>
            <br>
            <div class="container">
                <a href="#" style="margin-right: 0; font-size: 13px; font-family: Tahoma, Geneva, sans-serif;">Resent password</a>
            </div><br>
        </form>
        <p style="text-align: center">Don't have account?</p>
        <c:url value="/signupPath.html" var="signupPathURL"/>
        <form action="${signupPathURL}" method="post">
            <a><input type="submit" value="Sign Up"></a>
        </form>
    </div>
</body>
</html>