<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>My super project!</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" href="http://localhost:8080/sigIn/css/login.css" type="text/css"/>
    <link href="https://fonts.googleapis.com/css?family=Play" rel="stylesheet"/>
    <link rel="shortcut icon" href="images/image-icon.png" type="image/x-icon">

</head>
<body>
    <div class="signIn">
        <form action="http://localhost:8080/sigIn/controller" method="post">
            <h2 style="color:white">Log In</h2>
            <input type="text" name="username" placeholder="Username" required><br><br>
            <input type="password" name="password" placeholder="Password" required><br><br>
            <input type="reset" value="Reset">
            <a><input type="submit" value="Log in"></a><br><br>
            <div class="container">
                <a href="#" style="margin-right: 0; font-size: 13px; font-family: Tahoma, Geneva, sans-serif;">Resent password</a>
            </div><br><br><br><br><br>
        </form>
        Don't have account? <a href="http://localhost:8080/sigIn/jsp/signUp.jsp">&nbsp;Sign Up</a>
    </div>
</body>
</html>