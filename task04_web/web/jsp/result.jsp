<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html><head><title>Result Page</title></head>
<body>
<table>
<c:forEach var="elem" items="${lst}" varStatus="status">
    <tr>
        <%--<td><c:out value="${ elem }" /></td>--%>
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
</c:forEach>
</table>
</body>
</html>