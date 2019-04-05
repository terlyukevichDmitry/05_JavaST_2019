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
</head>
<body>

    <h5>Счетчик времени от запуска приложения до нажатия кнопки</h5>
    <jsp:useBean id="calendar" class="java.util.GregorianCalendar"/>
    <form name="Simple" action="timeaction" method="POST">
        <input type="hidden" name="time" value="${calendar.timeInMillis}"/>
        <input type="submit" name="button" value="Посчитать время"/>
    </form>

<div align="center">
<p><b>Ваше имя:</b><br>
  <input type="text" size="40" name="hello">
  <h1>Super app!</h1>
<%--<form action="hekko" method="POST">--%>
      <%--<input type="radio" name="browser" value="dom" > DOMParser<br><br>--%>
      <%--<input type="radio" name="browser" value="sax"> SAXParser<br><br>--%>
      <%--<input type="radio" name="browser" value="stax"> StAXParser<br><br>--%>
    <%--<input type="submit" value="Submit">--%>
    <%--<p><%= getFormattedDate()%></p><br><br>--%>
<%--</form>--%>
</div>
</body>
</html>
<%!
    String getFormattedDate () {
        SimpleDateFormat simpleDateFormat
                = new SimpleDateFormat ("dd.MM.yyyy hh:mm:ss");
        return simpleDateFormat.format (new Date());
    }
%>

