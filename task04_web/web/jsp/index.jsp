<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%--<%@ page import="java.text.SimpleDateFormat" %>--%>
<%--<%@ page import="java.util.Date" %>--%>
<%--<%@ page import="by.epam.xml.action.Action" %>&lt;%&ndash;--%>
  <%--Created by IntelliJ IDEA.--%>
  <%--User: Dima--%>
  <%--Date: 01.04.2019--%>
  <%--Time: 12:20--%>
  <%--To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="fmt"   uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="current" value="${param.dd}" scope="session"/>
<c:if test="${not empty current}">
    <fmt:setLocale value="${current}" scope="session"/>
</c:if>
<fmt:setBundle basename="text" scope="session"/>
<!DOCTYPE html>
<html>
<head>
    <title>My super project!</title>
    <link rel="stylesheet" href="css/style.css" type="text/css"/>
</head>
    <body>
    <div align="center">
        <h1><fmt:message key="hello_message"/> </h1>

        <form action="#" method="POST">
            <label>
                <select name="dd">
                    <option value="ru_RU">Russian language</option>
                    <option value="en_US">English language</option>
                    <option value="be_BY">Belarus language</option>
                </select>
            </label>
            <input type="submit" class="myButton" value="<fmt:message key="button"/>"/>
        </form><br><br>

        <form action="http://localhost:8080/xmlParser/parserServlet" enctype="multipart/form-data" method="POST">
            <label class="container">DOMParser
                <input type="radio" name="browser" value="dom" checked>
                <span class="checkmark"></span>
            </label>
            <br>
            <label class="container">SAXParser
                <input type="radio" name="browser" value="sax">
                <span class="checkmark"></span>
            </label>
            <br>
            <label class="container">StAXParser
                <input type="radio" name="browser" value="stax">
                <span class="checkmark"></span>
            </label>
            <br>
            <input accept="file.xml" class="myButton" type="file" name="fileReader">
            <input type="submit" value="<fmt:message key="button"/>" class="myButton" >
            <p style="font-size: 22px"><%=getFormattedDate()%></p><br><br>
        </form>
    </div>
    </body>
</html>
<%!
    private String getFormattedDate() {
        SimpleDateFormat simpleDateFormat
                = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
        return simpleDateFormat.format (new Date());
    }
%>

