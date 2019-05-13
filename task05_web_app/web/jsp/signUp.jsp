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
    <link rel="stylesheet" href="${ctx}/css/signup.css" type="text/css"/>
    <link href="https://fonts.googleapis.com/css?family=Play" rel="stylesheet"/>
    <link rel="shortcut icon" href="images/image-icon.ico" type="image/x-icon">
    <style>
        #msg {
            visibility: hidden;
            min-width: 250px;
            background-color: yellow;
            color: #000;
            text-align: center;
            border-radius: 2px;
            padding: 16px;
            margin-right: 122px;
            position: fixed;
            z-index: 1;
            right: 30%;
            top: 30px;
            font-size: 17px;
        }

        #msg.show {
            visibility: visible;
            -webkit-animation: fadein 0.5s, fadeout 0.5s 2.5s;
            animation: fadein 0.5s, fadeout 0.5s 2.5s;
        }

        @-webkit-keyframes fadein {
            from {top:0;opacity: 0;}
            to{top: 30px;opacity: 1}
        }

        @keyframes fadein {
            from {top:0;opacity: 0;}
            to{top: 30px;opacity: 1}
        }

        @-webkit-keyframes fadeout {
            from {top:30px;opacity: 1;}
            to{top: 0;opacity: 0}
        }

        @keyframes fadeout {
            from {top:30px;opacity: 1;}
            to{top: 0;opacity: 0}
        }

    </style>
</head>
<body>
    <div class="signUp">
        <c:url value="/signup" var="signupURL"/>
        <form action="${signupURL}" method="post">
            <h2 style="color: #ffffff;">Sign Up</h2>
            <div class="block-left">
                <input type="text" name="name" placeholder="First name" required><br><br><br>
                <input type="text" name="email" placeholder="@mail" required><br><br><br>
                <input type="text" name="login" placeholder="Username" required>
            </div>
            <div class="block-right">
                <input type="text" name="surname" placeholder="Second name" required><br><br><br>
                <input type="date" name="dateOfBirth" placeholder="Write date of birth" required><br><br><br>
                <input type="password" name="password" placeholder="Password" required>
            </div>
            <div class="block-op">
                <input type="text" name="patronymic" placeholder="Patronymic" required><br><br><br>
                <input type="text" name="phone" placeholder="Phone number" required><br><br><br>
                <input type="password" name="confirm" placeholder="Confirm Password" required>
            </div>
            <input type="submit" value="Sign Up" onclick="myFunction()"><br>
            <div id="msg">
                Congratulations!!! You sign up successfully!!!
            </div><br><br>
            <script>
                function myFunction() {
                    var x = document.getElementById("msg");
                    x.className = "show";
                    setTimeout(function () {
                        x.className = x.className.replace("show", "");
                    }, 3000);
                }
            </script>
            <div style="color:#60c9a8; font-size: 18px;">
                ${createInfo}
            </div>
            <c:url value="/login" var="loginURL"/>
            Already have account?<a href="${loginURL}"> Sign In</a>
        </form>

    </div>
</body>
</html>