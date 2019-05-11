<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt"   uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setBundle basename="messages" scope="session"/>
<c:set var="url">${pageContext.request.requestURL}</c:set>
<c:set var="ctx"
       value="${fn:substring(url, 0, fn:length(url) - fn:length(pageContext.request.requestURI))}${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <title>Parser result</title>
    <link rel="stylesheet" href="http://bootstraptema.ru/plugins/2015/bootstrap3/bootstrap.min.css" />
    <link rel="stylesheet" href="css/style.css" type="text/css"/>
</head>
<script>
    function goBack() {
        window.history.back()
    }
</script>

<body>
<table border="2" width="95%" cellpadding="7" bgcolor="#191970">
        <span style="color: black ">
                <tr align="center" bgcolor="#ff1493">
                    <th><fmt:message key="id"/></th>
                    <th><fmt:message key="login"/></th>
                    <th><fmt:message key="password"/></th>
                    <th><fmt:message key="role"/></th>
                </tr>
        </span>

    <%--@elvariable id="userList" type="java.util.List"--%>
    <c:forEach var="elem" items="${userList}" varStatus="status">
        <span>
                <tr bgcolor="#faebd7">
                    <td><c:out value="${ elem.id }" /></td>
                    <td><c:out value="${ elem.login }"/> </td>
                    <td><c:out value="${ elem.password }"/> </td>
                    <td><c:out value="${ elem.role }"/> </td>
                    <br>
                </tr>
        </span>
    </c:forEach>
</table><br><br>
<a href="#" class="myButton" onclick="goBack()"><fmt:message key="button"/></a><br><br>
</body>
</html>