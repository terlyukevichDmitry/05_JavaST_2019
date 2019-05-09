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
    <c:url value="/removeUser" var="removeURL"/>
    <form action="${removeURL}" method="post">
        <h2 style="color:white">Remove Person</h2>
        <input type="text" name="login" placeholder="Username" required><br><br>
        <input type="reset" value="Reset"><br><br>
        <a><input type="submit" value="Remove"></a><br>
        <div style="color:#60c9a8; font-size: 18px;">
            ${errorLoginPassMessage}
            ${wrongAction}
            ${nullPage}
        </div>
        <br>
    </form>
    <c:url value="/home" var="homeURL"/>
    <a href="${homeURL}" style="text-align: center">Go on home page</a>
</div>
</body>
</html>