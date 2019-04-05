<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
<a href="#" class="myButton" onclick="goBack()">Go Back</a><br><br>

<table border="2" width="95%" cellpadding="7" bgcolor="#191970">
        <span style="color: black ">
                <tr align="center" bgcolor="#ff1493">
                        <th>Тип Поездки</th>
                        <th>Страна</th>
                        <th>Кол-во дней</th>
                        <th>Кол-во ночей</th>
                        <th>Вид перевозки</th>
                        <th>Кол-во звезд</th>
                        <th>Тип питания</th>
                        <th>Кол-во комнат</th>
                        <th>Наличие телевизора</th>
                        <th>Наличие интернета</th>
                        <th>Наличие кондиционера</th>
                        <th>Кол-во денег</th>
                        <th>Тип валюты</th>
                        <th>Дата начала</th>
                        <th>Дата окончания</th>
                        <th>ID</th>
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
</table>
</body>
</html>