<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>My super project!</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" href="http://localhost:8080/sigIn/css/signup.css" type="text/css"/>
    <link href="https://fonts.googleapis.com/css?family=Play" rel="stylesheet"/>
    <link rel="shortcut icon" href="images/image-icon.png" type="image/x-icon">

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
        <form action="http://localhost:8080/sigIn/controller" method="post">
            <h2 style="color: #ffffff;">Sign Up</h2>
            <input type="text" name="username" placeholder="Username" required><br><br>
            <input type="password" name="password" placeholder="Password" required><br><br>
            <input type="password" name="password" placeholder="Confirm Password" required><br><br>
            <input type="button" value="Sign Up" onclick="myFunction()"><br><br>
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
        </form>
        Already have account? <a href="http://localhost:8080/sigIn/jsp/sigIn.jsp" style="text-decoration: blink; font-family: 'Play', sans-serif; color: yellow;">&nbsp;Log in</a>
    </div>
</body>
</html>