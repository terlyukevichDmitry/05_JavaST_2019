<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page isErrorPage="true" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:set var="url">${pageContext.request.requestURL}</c:set>
<c:set var="ctx"
       value="${fn:substring(url, 0, fn:length(url) - fn:length(pageContext.request.requestURI))}${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>404</title>
</head>
<body>

<style>
    #beastainer{padding:20px 0 20px 20px;position:relative}
    #beast404re{left:231px;top:68px;animation-name:crazyrighteye}
    #beast404le,#beast404re{position:absolute;animation-delay:2s;animation-duration:7s;animation-iteration-count:infinite;animation-play-state:running}
    #beast404le{left:125px;top:65px;-webkit-animation-name:crazylefteye;animation-name:crazylefteye}
    @keyframes crazyrighteye {
        0%{left:231px;top:68px}
        10%,20%{left:212px;top:62px}
        40%{left:239px;top:64px}
        50%{left:240px;top:80px}
        60%{left:215px;top:73px}
        100%,70%{left:231px;top:68px}
    }
    @keyframes crazylefteye {
        0%{left:125px;top:65px}
        10%,20%{left:118px;top:56px}
        40%{left:148px;top:62px}
        50%{left:145px;top:72px}
        60%{left:121px;top:70px}
        100%,70%{left:125px;top:65px}
    }
</style>

<div id="beastainer">
    <img id="beast404le" src="https://developer.cdn.mozilla.net/static/img/beast-404_LE.f1435cace4b4.png" alt="left eye">
    <img id="beast404re" src="https://developer.cdn.mozilla.net/static/img/beast-404_RE.2e53f96c5abb.png" alt="right eye">
    <img class="beast 404" src="https://developer.cdn.mozilla.net/static/img/beast-404.ce38fcf80386.png" alt="">
</div>


<div style="margin-left: 500px;">
    <c:out value="${pageContext.exception.message}" />

    Request from <c:out value="${pageContext.errorData.requestURI}"/> is failed
    <br/>
    Servlet name or type: <c:out value="${pageContext.errorData.servletName}"/>
    <br/>
    Status code: <c:out value="${pageContext.errorData.statusCode}"/>
    <br/>
    Exception: <c:out value="${pageContext.errorData.throwable}"/>
    <input type="submit" value="go back">
</div>




</body>
</html>