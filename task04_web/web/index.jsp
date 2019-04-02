<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 01.04.2019
  Time: 12:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>My super project!</title>
</head>
<body>
<p><b>Ваше имя:</b><br>
  <input type="text" size="40" name="hello">
<div>
  <h1>Super app!</h1>
</div>
<form action="HelloWorld" method="post">
    <%--DOM parser<input type="text" name="parserDom"/><br><br>--%>
    <%--SAX parser<input type="text" name="parserSax"/><br><br>--%>
    <%--StAX parser<input type="text" name="parserStax"/><br><br>--%>
      <input type="radio" name="browser" value="dom"> DOMParser<Br>
      <input type="radio" name="browser" value="sax"> SAXParser<Br>
      <input type="radio" name="browser" value="stax"> StAXParser<Br>
    <input type="submit" value="Submit">
</form>
<%--<br>--%>
<%--<input type="radio" name="browser" value="DOM"> DOMParser<Br>--%>
<%--<input type="radio" name="browser" value="SAX"> SAXParser<Br>--%>
<%--<input type="radio" name="browser" value="StAX"> StAXParser<Br>--%>
</body>
</html>
