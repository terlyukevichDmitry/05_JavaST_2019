<%@ taglib prefix="ctg" uri="customtags" %>
<%@ taglib prefix="m" uri="customMenu" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page isELIgnored="false" %>
<c:set var="url">${pageContext.request.requestURL}</c:set>
<c:set var="ctx"
       value="${fn:substring(url, 0, fn:length(url) - fn:length(pageContext.request.requestURI))}${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en_US">
<head>
    <title>JukeBox Quest</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="${ctx}/css/home/header.css" type="text/css"/>
    <link rel="stylesheet" href="${ctx}/css/quest/quest.css" type="text/css"/>
    <link rel="stylesheet" href="${ctx}/css/profile.css" type="text/css"/>
    <link rel="stylesheet" href="${ctx}/css/home/base.css" type="text/css"/>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
          integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf"
          crossorigin="anonymous">
    <link rel="shortcut icon" href="images/image-icon.ico" type="image/x-icon">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="http://bootstraptema.ru/plugins/2015/bootstrap3/bootstrap.min.css" />
    <link rel="stylesheet" href="http://bootstraptema.ru/plugins/font-awesome/4-4-0/font-awesome.min.css" />
    <script src="http://bootstraptema.ru/plugins/jquery/jquery-1.11.3.min.js"></script>
    <script src="http://bootstraptema.ru/plugins/2015/b-v3-3-6/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
          integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf"
          crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>

    <script type="javascript">
        $("#elem").show('slow');
        setTimeout(function() { $("#elem").hide('slow'); }, 2000);
    </script>
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
            </div>
            <c:choose>
                <c:when test="${user.role.name.equals('administrator')}">
                    <div class="btn-group">
                        <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Action
                        </button>
                        <div class="dropdown-menu" style="opacity: 0.8">
                            <c:url value="/profile" var="profileURL"/>
                            <a href="${profileURL}" class="dropdown-item">Profile</a>
                            <c:url value="/myQuests" var="myQuestsURL"/>
                            <a href="${myQuestsURL}" class="dropdown-item">My quests</a>
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
                        <div class="dropdown-menu" style="opacity: 0.8">
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
        <div class="header_slogan" style="opacity: 0.8">
            <h1 class="h_slogan">Here you can find the best quests.</h1><br>
            <c:url value="/quests" var="questsURL"/>
            <a href="${questsURL}" class="btn btn-warning btn-lg">Best Quests</a>
        </div>
    </div>
</div>

<%--@elvariable id="client" type="by.epam.site.entity.Client"--%>
<c:set var="elem" value="${client}" />
<div>
<div class="container">
    <div id="main">
        <div class="row" id="real-estates-detail">
            <div class="col-lg-3 col-md-3 col-xs-8">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <header class="panel-title">
                            <div class="text-center">
                                <strong>Site user</strong>
                            </div>
                        </header>
                    </div>
                    <div class="panel-body">
                        <div class="text-center" id="author">
                            <img width="80%" height="80%" src="${pageContext.request.contextPath}/${elem.filePath}"/>
                            <h3><c:out value="${ elem.name }"/> <c:out value="${ elem.surname }"/></h3>
                            <small class="label label-warning">Republic of Belarus</small>
                            <p>Put on a happy face!</p>
                            <p class="sosmed-author">
                                <a href=""><i style="font-size: 30px;" class="fab fa-instagram" title="Instagram"></i></a>
                                <a href=""><i style="font-size: 30px;" class="far fa-question-circle" title="Ask"></i></a>
                                <a href=""><i style="font-size: 30px;" class="fab fa-vk" title="VK"></i></a>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-8 col-md-8 col-xs-12">
                <div class="panel">
                    <div class="panel-body">
                        <ul id="myTab" class="nav nav-pills">
                            <li class="active"><a href="#detail" data-toggle="tab">About Person</a></li>
                            <li class=""><a href="#contact" data-toggle="tab">Change information about person</a></li>
                            <li class=""><a href="#data"  data-toggle="tab">Change password</a></li>
                        </ul>
                        <div id="myTabContent" class="tab-content">
                            <hr>
                            <div class="tab-pane fade active in" id="detail">
                                <h4>Profile history</h4>
                                <table class="table table-th-block">
                                    <tbody>
                                    <tr><td class="active">First name:</td><td><c:out value="${ elem.name }"/></td></tr>
                                    <tr><td class="active">Second name:</td><td><c:out value="${ elem.surname }"/></td></tr>
                                    <tr><td class="active">Patronymic:</td><td><c:out value="${ elem.patronymic }"/></td></tr>
                                    <tr><td class="active">Date of birth</td><td><c:out value="${ elem.dateOfBirth }"/></td></tr>
                                    <tr><td class="active">Person email:</td><td><c:out value="${ elem.email }"/></td></tr>
                                    <tr><td class="active">Person phone number:</td><td><c:out value="${ elem.phone }"/></td></tr>
                                    </tbody>
                                    <p style="background:#000; color:#fff;" id="elem">Result</p>
                                </table>
                            </div>
                            <div class="tab-pane fade" id="contact">
                                <p></p>
                                <c:url value="/changeValue" var="changeValueURL"/>
                                <form action="${changeValueURL}" role="form" method="post">
                                    <div class="form-group">
                                        <label>Name</label>
                                        <input type="text" name="changeName" class="form-control rounded" placeholder="Write new name">
                                    </div>
                                    <div class="form-group">
                                        <label>Surname</label>
                                        <input type="text" name="changeSurname" class="form-control rounded" placeholder="Write new surname">
                                    </div>
                                    <div class="form-group">
                                        <label>Patronymic</label>
                                        <input type="text" name="changePatronymic" class="form-control rounded" placeholder="Write new patronymic">
                                    </div>
                                    <div class="form-group">
                                        <label>Date of birth</label>
                                        <input type="text" name="changeDateOfBirth" class="form-control rounded" placeholder="Write new date of birth">
                                    </div>
                                    <div class="form-group">
                                        <label>E-mail</label>
                                        <input type="email" name="changeEmail" class="form-control rounded" placeholder="Write new E-mail address">
                                    </div>
                                    <div class="form-group">
                                        <label>Phone number</label>
                                        <input type="text" name="changePhoneNumber" class="form-control rounded" placeholder="Write new phone number">
                                    </div>
                                    <div class="form-group">
                                        <input type="submit" class="btn btn-success" data-original-title="" title="" value="Change">
                                    </div>
                                </form>
                            </div>
                            <div class="tab-pane fade" id="data">
                                <p></p>
                                <c:url value="/changePassword" var="changePasswordURL"/>
                                <form action="${changePasswordURL}" role="form" method="post">
                                    <div class="form-group">
                                        <label>Password</label>
                                        <input type="password" name="changePassword" class="form-control rounded" placeholder="Write new name" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Confirm Password</label>
                                        <input type="password" name="changeConfirm" class="form-control rounded" placeholder="Write new surname" required>
                                    </div>
                                    <div class="form-group">
                                        <input type="submit" class="btn btn-success" data-original-title="" title="" value="Change">
                                    </div>
                                    <div style="color:#60c9a8; font-size: 18px;">
                                        ${errorPassword}
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div><!-- /.main -->
</div>

</body>
</html>