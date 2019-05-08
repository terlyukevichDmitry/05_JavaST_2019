<%@ taglib prefix="ctg" uri="customtags" %>
<%@ taglib prefix="m" uri="customMenu" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<!DOCTYPE html>
<html lang="en_US">
<head>
    <title>JukeBox Quest</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="http://localhost:8080/sigIn/css/home/header.css" type="text/css"/>
    <link rel="stylesheet" href="http://localhost:8080/sigIn/css/home/base.css" type="text/css"/>
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
                    <a href="#" class="menu_link"><i class="fas fa-home"></i> Home</a>
                    <a href="#" class="menu_link"><i class="fas fa-newspaper"></i> About</a>
                    <a href="#" class="menu_link"><i class="fas fa-phone"></i> Contact</a>
                </div>
                <c:choose>
                    <c:when test="${user.equals('administrator')}">
                        <div class="dropdown">
                            <button class="mainmenubtn">Main Menu</button>
                            <div class="dropdown-child">
                                <form>
                                    <a href="http://localhost:8080/sigIn/jsp/profile.jsp">Profile</a>
                                </form>
                                <c:url value="/showUsers.html" var="searchUserURL"/>
                                <a href="${searchUserURL}">Users</a>
                                <c:url value="/removePath.html" var="removeUserURL"/>
                                <a href="${removeUserURL}">Remove User</a>
                                <c:url value="/logout.html" var="logout"/>
                                <a href="${logout}">Log out</a>
                            </div>
                        </div>
                    </c:when>
                    <c:when test="${user.equals('client')}">
                        <div class="dropdown">
                            <button class="mainmenubtn">Main Menu</button>
                            <div class="dropdown-child">
                                <a href="http://localhost:8080/sigIn/jsp/profile.jsp">Profile</a>
                                <a href="http://www.вашдомен.ru/page2.html">Users</a>
                                <input type="hidden" name="command" value="logout" />
                                <c:url value="/logout.html" var="logout"/>
                                <form action="${logout}" method="post">
                                    <a><input type="submit" value="Log out"></a>
                                </form>
                            </div>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <c:url value="/signIn.html" var="signInURL"/>
                        <a href="${signInURL}" class="menu_link"><i class="fas fa-sign-in-alt"></i> Log in</a>
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="header_slogan">
                <h1 class="h_slogan">Here you can find the best quests.</h1><br>
                <c:url value="/questPlaces.html" var="questsURL"/>
                <a href="${questsURL}" class="h_slogan_btn">Best Quests</a>
            </div>
        </div>
</div>
</body>
</html>