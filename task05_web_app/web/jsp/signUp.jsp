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
    <title>My super project!</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" href="${ctx}/css/signup.css" type="text/css"/>
    <link href="https://fonts.googleapis.com/css?family=Play" rel="stylesheet"/>
    <link rel="shortcut icon" href="images/image-icon.ico" type="image/x-icon">
</head>
<body>
<div class="signUp">
    <c:url value="/signup" var="signupURL"/>
    <form action="${signupURL}" method="post">
        <h2 style="color: #ffffff;"><fmt:message key="signUpLabel"/></h2>
        <div class="block-left">
            <input type="text" name="name" placeholder="<fmt:message key="firstNameLabel"/>" required><br><br><br>
            <input type="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" name="email" placeholder="<fmt:message key="emailLabel"/>" required><br><br><br>
            <input type="text" name="login" placeholder="<fmt:message key="userNameLabel"/>" required>
        </div>
        <div class="block-right">
            <input type="text" name="surname" placeholder="<fmt:message key="secondNameLabel"/>" required><br><br><br>
            <input type="date" name="dateOfBirth" placeholder="<fmt:message key="writeDateOfBirthLabel"/>" required><br><br><br>
            <input type="password" name="password" placeholder="<fmt:message key="passwordLabel"/>" required>
        </div>
        <div class="block-op">
            <input type="text" name="patronymic" placeholder="<fmt:message key="patronymicLabel"/>" required><br><br><br>
            <input type="tel" pattern="[0-9]{9}" name="phone" placeholder="<fmt:message key="writePhoneLabel"/>" required><br><br><br>
            <input type="password" name="confirm" placeholder="<fmt:message key="confirmLabel"/>" required>
        </div><br><br>
        <input type="submit" value="<fmt:message key="signUpLabel"/>"><br>
        <div style="color:#60c9a8; font-size: 18px;">
            ${errorInfo}
        </div>
        <c:url value="/login" var="loginURL"/>
        <fmt:message key="messageAccountLabel"/><a href="${loginURL}"> <fmt:message key="signInLabel"/></a>
    </form>
</div>
</body>
</html>