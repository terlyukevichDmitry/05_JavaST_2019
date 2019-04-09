<%@ taglib prefix="fmt"   uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<fmt:setBundle basename="text" scope="session"/>
<!DOCTYPE html>
<html>
    <head>
        <title>Parser result</title>
        <link rel="stylesheet" href="css/style.css" type="text/css"/>
    </head>
    <script>
        function goBack() {
        window.history.back()
        }
    </script>
    <body>
    <div align="center">
        <div style="font-size: 72px;
color:red;">
            <fmt:message key="fileError"/><br>
        </div>
        <div style="font-size: 30px">
            <fmt:message key="error"/><br><br>
     </div>
    </div>
        <a href="#" class="myButton" onclick="goBack()"><fmt:message key="button"/></a><br><br>
    </body>
</html>