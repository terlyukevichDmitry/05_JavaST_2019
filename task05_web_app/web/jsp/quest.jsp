<%@ taglib prefix="ctg" uri="customtags" %>
<%@ taglib prefix="m" uri="customMenu" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en_US">
<head>
    <title>JukeBox Quest</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="http://localhost:8080/sigIn/css/home/header.css" type="text/css"/>
    <link rel="stylesheet" href="http://localhost:8080/sigIn/css/quest/quest.css" type="text/css"/>
    <link rel="stylesheet" href="http://localhost:8080/sigIn/css/home/base.css" type="text/css"/>
    <link rel="stylesheet" href="http://bootstraptema.ru/plugins/2015/bootstrap3/bootstrap.min.css" />
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
          integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf"
          crossorigin="anonymous">
    <link rel="shortcut icon" href="images/image-icon.ico" type="image/x-icon">
    <style>
        .mainmenubtn {
            background-color: red;
            color: white;
            border: none;
            cursor: pointer;
            padding:20px;
            margin-top:20px;
        }
        .dropdown {
            position: relative;
            display: inline-block;
        }
        .dropdown-child {
            display: none;
            background-color: black;
            min-width: 200px;
        }
        .dropdown-child a {
            color: white;
            padding: 20px;
            text-decoration: none;
            display: block;
        }
        .dropdown:hover .dropdown-child {
            display: block;
        }
    </style>
</head>
<body>
<div class="header">
    <div class="header_texture"></div>
    <div class="header_mask">
        <svg width="100%" height="100%" viewBox="0 0 100 100"
             preserveAspectRatio="none">
            <path d="M0 100 L 0 0 C 25 100 75 100 100 0 L 100 100" fill="#fff"></path>
        </svg>
    </div>
    <div class="container">
        <div class="header_navbar">
            <div class="header_logo">
                <h1 class="logo_title">JukeBOX</h1>
            </div>
            <div class="header_menu">
                <c:url value="/home" var="homeURL"/>
                <a href="${homeURL}" class="menu_link"><i class="fas fa-home"></i> Home</a>
            </div>
            <c:choose>
                <c:when test="${user.role.name.equals('administrator')}">
                    <div class="dropdown">
                        <button class="mainmenubtn">Main Menu</button>
                        <div class="dropdown-child">
                            <c:url value="/profile" var="homeURL"/>
                            <a href="${homeURL}">Profile</a>
                            <c:url value="/showUsers" var="searchUserURL"/>
                            <a href="${searchUserURL}">Users</a>
                            <c:url value="/removePath" var="removeUserURL"/>
                            <a href="${removeUserURL}">Remove User</a>
                            <c:url value="/logout" var="logout"/>
                            <a href="${logout}">Log out</a>
                        </div>
                    </div>
                </c:when>
                <c:when test="${user.role.name.equals('client')}">
                    <div class="dropdown">
                        <button class="mainmenubtn">Main Menu</button>
                        <div class="dropdown-child">
                            <c:url value="/profile" var="profileURL"/>
                            <a href="${profileURL}">Profile</a>
                            <input type="hidden" name="command" value="logout" />
                            <c:url value="/logout" var="logout"/>
                            <form action="${logout}" method="post">
                                <a><input type="submit" value="Log out"></a>
                            </form>
                        </div>
                    </div>
                </c:when>
                <c:otherwise>
                    <c:url value="/signIn" var="signInURL"/>
                    <a href="${signInURL}" class="menu_link"><i class="fas fa-sign-in-alt"></i> Log in</a>
                </c:otherwise>
            </c:choose>
        </div>
        <div class="header_slogan">
            <h1 class="h_slogan">Here you can find the best quests.</h1><br>
            <a class="h_slogan_btn">Best Quests</a>
        </div>
    </div>
</div>

<div class="main">
    <div class="container">
        <div class="row">
            <tr>
                <div class="col-1-3">
                </div>
                <div style="text-align: center;">
                    <div class="col-2-3">
                        <c:url value="/searchByParameter" var="searchByParameterURL"/>
                        <form action="${searchByParameterURL}" method="post">
                        <input type="text" name="searchName" placeholder="Input parameter">
                        <input type="submit" value="Search">
                        </form>
                    </div>
                </div>
            </tr>
        </div>
    </div>
</div>

<%--@elvariable id="questPlaces" type="java.util.List"--%>
<c:forEach var="elem" items="${questPlaces}" varStatus="status">
<div class="main">
    <div class="container">
        <div class="row">
            <tr>
            <div class="col-1-3">
                <td ><img width="100%" height="100%" src="${pageContext.request.contextPath}/${elem.image.filePath}"/></td>
            </div>
                <div style="text-align: center;">
            <div class="col-2-3">
                Quest place name: <td><c:out value="${ elem.name }"/> </td><br><br>
                Phone number: <td><c:out value="${ elem.phone }"/> </td><br><br>
                Quest address: <td><c:out value="${ elem.address }"/> </td><br><br>
                Quest name: <td><c:out value="${ elem.quest.title }"/> </td><br><br>
                Quest level: <td><c:out value="${ elem.quest.level }"/> </td><br><br>
                Maximum number of people in this quest: <td><c:out value="${ elem.quest.maxPeople }"/> </td><br><br>
                <c:url value="/bookQuest" var="bookQuestURL"/>
                <form action="${bookQuestURL}" method="post">
                <td><input type="submit" value="Book a quest"></td>
                </form>
            </div>
                </div>
            </tr>
        </div>
    </div>
</div>
    <hr/>
</c:forEach>

</body>
</html>