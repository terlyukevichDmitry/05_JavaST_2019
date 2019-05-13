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
    <link rel="stylesheet" href="${ctx}/css/review.css" type="text/css"/>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
          integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf"
          crossorigin="anonymous">
    <link rel="shortcut icon" href="images/image-icon.ico" type="image/x-icon">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
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
                <a href="#" class="menu_link"><i class="fas fa-newspaper"></i> About</a>
                <a href="#" class="menu_link"><i class="fas fa-phone"></i> Contact</a>
                <c:url value="/review" var="reviewURL"/>
                <a href="${reviewURL}" class="menu_link"><i class="fas fa-list"></i> Review</a>
            </div>
            <c:choose>
                <c:when test="${user.role.name.equals('administrator')}">
                    <div class="btn-group">
                        <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Action
                        </button>
                        <div class="dropdown-menu">
                            <c:url value="/profile" var="profileURL"/>
                            <a href="${profileURL}" class="dropdown-item">Profile</a>
                            <c:url value="/myQuests" var="myQuestsURL"/>
                            <a href="${myQuestsURL}" class="dropdown-item">My quests</a>
                            <c:url value="/createQuest" var="createQuestURL"/>
                            <a href="${createQuestURL}" class="dropdown-item">Create Quest</a>
                            <c:url value="/showUsers" var="searchUserURL"/>
                            <a href="${searchUserURL}" class="dropdown-item">Users</a>
                            <c:url value="/removeUser" var="removeUserURL"/>
                            <a href="${removeUserURL}" class="dropdown-item">Remove User</a>
                            <div class="dropdown-divider"></div>
                            <c:url value="/logout" var="logout"/>
                            <a href="${logout}" class="dropdown-item">Log out</a>
                        </div>
                    </div>
                </c:when>
                <c:when test="${user.role.name.equals('client')}">
                    <div class="btn-group">
                        <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Action
                        </button>
                        <div class="dropdown-menu">
                            <c:url value="/profile" var="profileURL"/>
                            <a href="${profileURL}" class="dropdown-item">Profile</a>
                            <c:url value="/myQuests" var="myQuestsURL"/>
                            <a href="${myQuestsURL}" class="dropdown-item">My quests</a>
                            <div class="dropdown-divider"></div>
                            <c:url value="/logout" var="logout"/>
                            <a href="${logout}" class="dropdown-item">Log out</a>
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
            <a href="${questsURL}" class="btn btn-warning btn-lg">Best Quests</a>
        </div>
    </div>
</div>


<%--@elvariable id="review" type="java.util.List"--%>
<c:forEach var="elem" items="${review}" varStatus="status">
<div class="containerS">
<img src="${pageContext.request.contextPath}/${elem.client.filePath}" alt="Avatar" style="width:90px">
<p><span><c:out value="${ elem.client.surname }"/> <c:out value="${ elem.client.name }"/></span><c:out value="${ elem.date }"/></p>
<tr>
<th><c:out value="${ elem.message }"/> </th><br>
<c:if test="${user.role.name.equals('administrator')}">
<c:url value="/removeReview" var="removeReviewURL"/>
<form action="${removeReviewURL}" method="post">
<br>
<input type="hidden" name="getReviewId" value="${elem.getId()}">
<td><input type="submit" value=" Remove review " class="btn btn-info"></td>
</form>
</c:if>
</div>
</c:forEach>

<c:url value="/review" var="reviewURL"/>
<nav aria-label="Статьи по Bootstrap 4">
    <ul class="pagination justify-content-center">
        <c:if test="${current_page != 1}">
        <li class="page-item"><a class="page-link" href="${reviewURL}?page=${current_page - 1}">Previous</a></li>
        </c:if>
        <c:forEach begin="1" end="${num_of_pages}" var="i" step="1" varStatus="status">
        <li class="page-item">
                <c:choose>
                    <c:when test="${current_page eq i}">
                        <a class="page-link" href="#">${i}</a>
                    </c:when>
                    <c:otherwise>
                        <a class="page-link" href="${reviewURL}?page=${i}">${i}></a>
                    </c:otherwise>
                </c:choose>
        </li>
        </c:forEach>
        <c:if test="${current_page lt num_of_pages}">
        <li class="page-item"><a class="page-link" href="${reviewURL}?page=${current_page + 1}">Next</a></li>
        </c:if>
    </ul>
</nav>
</body>
</html>