<%@ taglib prefix="ctg" uri="customtags" %>
<%@ taglib prefix="m" uri="customMenu" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="url">${pageContext.request.requestURL}</c:set>
<c:set var="ctx"
       value="${fn:substring(url, 0, fn:length(url) - fn:length(pageContext.request.requestURI))}${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en_US">
<head>
    <title>JukeBox Quest</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="${ctx}/css/home/header.css" type="text/css"/>
    <link rel="stylesheet" href="${ctx}/css/home/base.css" type="text/css"/>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
          integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf"
          crossorigin="anonymous">
    <link rel="shortcut icon" href="../images/image-icon.ico" type="image/x-icon">
    <link rel="stylesheet" href="http://bootstraptema.ru/plugins/2015/bootstrap3/bootstrap.min.css" />

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
                <a href="#" class="menu_link"><i class="fas fa-home"></i> Home</a>
                <a href="#" class="menu_link"><i class="fas fa-newspaper"></i> About</a>
                <a href="#" class="menu_link"><i class="fas fa-phone"></i> Contact</a>
            </div>
            <c:choose>
                <c:when test="${user.role.name.equals('administrator')}">
                    <div class="dropdown">
                        <button class="mainmenubtn">Main Menu</button>
                        <div class="dropdown-child">
                            <c:url value="/profile" var="profileURL"/>
                            <a href="${profileURL}">Profile</a>
                            <c:url value="/myQuests" var="myQuestsURL"/>
                            <a href="${myQuestsURL}">My quests</a>
                            <c:url value="/showUsers" var="searchUserURL"/>
                            <a href="${searchUserURL}">Users</a>
                            <c:url value="/removeUser" var="removeUserURL"/>
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
                            <c:url value="/myQuests" var="myQuestsURL"/>
                            <a href="${myQuestsURL}">My quests</a>
                            <c:url value="/logout" var="logout"/>
                            <a href="${logout}">Log out</a>
                        </div>
                    </div>
                </c:when>
                <c:otherwise>
                    <c:url value="/login" var="loginURL"/>
                    <a href="${loginURL}" class="menu_link"><i class="fas fa-sign-in-alt"></i> Log in</a>
                </c:otherwise>
            </c:choose>
        </div>
        <div class="header_slogan">
            <h1 class="h_slogan">Here you can find the best quests.</h1><br>
            <c:url value="/quests" var="questsURL"/>
            <a href="${questsURL}" class="h_slogan_btn">Best Quests</a>
        </div>
    </div>
</div>

<%--@elvariable id="userQuests" type="java.util.List"--%>
<c:forEach var="elem" items="${userQuests}" varStatus="status">
    <div class="main">
        <div class="container">
            <div class="row">
                <tr>
                    <div class="col-1-3">
                        <%--<td ><img width="100%" height="100%" src="${pageContext.request.contextPath}/${elem.image.filePath}"/></td>--%>
                    </div>
                    <div style="text-align: center;">
                        <div class="col-2-3" <c:if test="${user.role.name.equals('client')}">style="background-color: coral"</c:if> >
                            DATE place name: <td><c:out value="${ elem.date }"/> </td><br><br>
                            CLIENT place name: <td><c:out value="${ elem.client }"/> </td><br><br>
                            QUEST_PLACE place name: <td><c:out value="${ elem.questPlace }"/> </td><br><br>
                            <c:url value="/removeOrder" var="removeOrderURL"/>
                            <form action="${removeOrderURL}" method="post">
                                <input type="hidden" name="idToRemove" value="${elem.getId()}">
                                <input type="submit" value="Remove quest">
                            </form>
                        </div>
                    </div>
                </tr>
            </div>
        </div>
    </div>
    <hr/>
</c:forEach>




<div>
    SUKAAAAaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
</div>
</body>
</html>