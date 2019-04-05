<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %><%--<%@ page import="java.text.SimpleDateFormat" %>--%>
<%--<%@ page import="java.util.Date" %>--%>
<%--<%@ page import="by.epam.xml.action.Action" %>&lt;%&ndash;--%>
  <%--Created by IntelliJ IDEA.--%>
  <%--User: Dima--%>
  <%--Date: 01.04.2019--%>
  <%--Time: 12:20--%>
  <%--To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>My super project!</title>
    <link rel="stylesheet" href="css/style.css" type="text/css"/>
</head>
    <body>
    <div align="center">
        <h1>Super app!</h1>
        <form action="parserAction" method="POST">
            <label class="container">DOMParser
                <input type="radio" name="browser" value="dom" checked>
                <span class="checkmark"></span>
            </label>
            <br>
            <label class="container">SAXParser
                <input type="radio" name="browser" value="sax" checked>
                <span class="checkmark"></span>
            </label>
            <br>
            <label class="container">StAXParser
                <input type="radio" name="browser" value="stax">
                <span class="checkmark"></span>
            </label>
            <br>
            <input type="submit" value="Submit" class="myButton">
            <p style="font-size: 22px"><%= getFormattedDate()%></p><br><br>
        </form>
    </div>
    </body>
</html>
<%!
    private String getFormattedDate() {
        SimpleDateFormat simpleDateFormat
                = new SimpleDateFormat ("dd.MM.yyyy hh:mm:ss");
        return simpleDateFormat.format (new Date());
    }
%>

