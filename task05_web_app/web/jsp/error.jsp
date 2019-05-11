<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page isErrorPage="true" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:set var="url">${pageContext.request.requestURL}</c:set>
<c:set var="ctx"
       value="${fn:substring(url, 0, fn:length(url) - fn:length(pageContext.request.requestURI))}${pageContext.request.contextPath}"/>

<html>
    <head>
        <name>Error Page</name>
    </head>
<body>
<c:out value="${pageContext.exception.message}" />

    Request from <c:out value="${pageContext.errorData.requestURI}"/> is failed
    <br/>
    Servlet name or type: <c:out value="${pageContext.errorData.servletName}"/>
    <br/>
    Status code: <c:out value="${pageContext.errorData.statusCode}"/>
    <br/>
    Exception: <c:out value="${pageContext.errorData.throwable}"/>
</body>
</html>