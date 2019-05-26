<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<c:set var="url">${pageContext.request.requestURL}</c:set>
<c:set var="ctx"
       value="${fn:substring(url, 0, fn:length(url) - fn:length(pageContext.request.requestURI))}${pageContext.request.contextPath}"/>
<c:set var="current" value="${param.language}" scope="session"/>
<c:if test="${not empty current}">
    <fmt:setLocale value="${current}" scope="session"/>
</c:if>

<fmt:setBundle basename="browser" scope="session"/>
<!DOCTYPE html>
<html>
<head>
    <title>JukeBox Quest</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" href="${ctx}/css/signin.css" type="text/css"/>
    <link href="https://fonts.googleapis.com/css?family=Play" rel="stylesheet"/>
    <link rel="shortcut icon" href="images/smmNiFRJg98.jpg" type="image/png">
</head>
<body>
    <div class="signIn">
        <c:url value="/login" var="loginURL"/>
        <form action="${loginURL}" method="post">
            <h2 style="color:white"><fmt:message key="logIn"/></h2>
            <input type="text" name="login" placeholder="<fmt:message key="userNameLabel"/>" required><br><br>
            <input type="password" name="password" placeholder="<fmt:message key="passwordLabel"/>" required><br><br>
            <input type="reset" value="<fmt:message key="resetLabel"/>"><br><br>
            <input type="submit" value="<fmt:message key="signInLabel"/>"><br>
            <div style="font-size: 18px; color: #60c9a8;">
                ${signUpMessage}
            </div>
            <div style="color:red; font-size: 18px;">
                ${errorLoginPassMessage}
                ${notAccess}
            </div>
            <br>
        </form>
        <c:url value="/signup" var="signupURL"/>
        <fmt:message key="dontAccountLabel"/><a href="${signupURL}"> <fmt:message key="signUpLabel"/></a><br><br>
        <c:url value="/home" var="homeURL"/>
        <fmt:message key="goOnPage"/><a href="${homeURL}"> <fmt:message key="homePage"/></a>
    </div>
</body>
</html>