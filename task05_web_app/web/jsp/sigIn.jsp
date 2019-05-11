<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<c:set var="url">${pageContext.request.requestURL}</c:set>
<c:set var="ctx"
       value="${fn:substring(url, 0, fn:length(url) - fn:length(pageContext.request.requestURI))}${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <title>My super project!</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" href="${ctx}/css/signin.css" type="text/css"/>
    <link href="https://fonts.googleapis.com/css?family=Play" rel="stylesheet"/>
    <link rel="shortcut icon" href="images/image-icon.ico" type="image/x-icon">

</head>
<body>
    <div class="signIn">
        <c:url value="/login" var="loginURL"/>
        <form action="${loginURL}" method="post">
            <h2 style="color:white">Log In</h2>
            <input type="text" name="login" placeholder="Username" required><br><br>
            <input type="password" name="password" placeholder="Password" required><br><br>
            <input type="reset" value="Reset"><br><br>
            <input type="submit" value="Log in"><br>
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
        <c:url value="/signup" var="signupURL"/>
        Don't have account?<a href="${signupURL}"> Sign Up</a>
    </div>
</body>
</html>