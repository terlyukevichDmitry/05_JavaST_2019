<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>My super project!</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" href="css/login.css" type="text/css"/>
    <link rel="stylesheet" href="css/signup.css" type="text/css"/>
    <link href="https://fonts.googleapis.com/css?family=Play" rel="stylesheet"/>
</head>
<body>

    <div class="signIn">
        <form action="http://localhost:8080/sigIn/controller" method="post">
            <h2 style="color:white">Log In</h2>
            <input type="text" name="username" placeholder="Username">
            <input type="password" name="password" placeholder="Password"><br><br>
            <a><input type="submit" value="Log in"></a><br><br>
            <div class="container">
                <a href="#" style="margin-right: 0; font-size: 13px; font-family: Tahoma, Geneva, sans-serif;">Resent password</a>
            </div><br><br><br><br><br>
            Don't have account? <a><input type="submit" name="signup" value="Sign Up"></a>
        </form>
    </div>

</body>
</html>