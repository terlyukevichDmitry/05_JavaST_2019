<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt"   uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<table border="2" width="95%" cellpadding="7" bgcolor="#191970">
        <span style="color: black ">
                <tr align="center" bgcolor="#ff1493">
                        <th><fmt:message key="type"/></th>
                        <th><fmt:message key="country"/></th>
                        <th><fmt:message key="numberDays"/></th>
                        <th><fmt:message key="numberNights"/></th>
                        <th><fmt:message key="transport"/></th>
                        <th><fmt:message key="stars"/></th>
                        <th><fmt:message key="nutrition"/></th>
                        <th><fmt:message key="room"/></th>
                        <th><fmt:message key="tv"/></th>
                        <th><fmt:message key="wifi"/></th>
                        <th><fmt:message key="air"/></th>
                        <th><fmt:message key="money"/></th>
                        <th><fmt:message key="currency"/></th>
                        <th><fmt:message key="startTime"/></th>
                        <th><fmt:message key="finishDate"/></th>
                        <th><fmt:message key="id"/></th>
                </tr>
        </span>
    <%--@elvariable id="lst" type="java.util.List"--%>
    <c:forEach var="elem" items="${lst}" varStatus="status">
        <span>
                <tr bgcolor="#faebd7">
                        <td><c:out value="${ elem.type }"/></td>
                        <td><c:out value="${ elem.country }"/></td>
                        <td><c:out value="${ elem.numberDays }" /></td>
                        <td><c:out value="${ elem.numberNights }" /></td>
                        <td><c:out value="${ elem.transport }" /></td>
                        <td><c:out value="${ elem.hotelCharacteristics.stars }" /></td>
                        <td><c:out value="${ elem.hotelCharacteristics.nutrition }" /></td>
                        <td><c:out value="${ elem.hotelCharacteristics.room }" /></td>
                        <td><c:out value="${ elem.hotelCharacteristics.tv }" /></td>
                        <td><c:out value="${ elem.hotelCharacteristics.wifi }" /></td>
                        <td><c:out value="${ elem.hotelCharacteristics.airConditioning }" /></td>
                        <td><c:out value="${ elem.cost.value }" /></td>
                        <td><c:out value="${ elem.cost.currency }" /></td>
                        <td><c:out value="${ elem.dataStart }" /></td>
                        <td><c:out value="${ elem.dataFinish }" /></td>
                        <td><c:out value="${ elem.id }" /></td>
                </tr>
        </span>
    </c:forEach>
</table><br><br>
<a href="#" class="myButton" onclick="goBack()"><fmt:message key="button"/></a><br><br>
</body>
</html>