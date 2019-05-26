<%@ taglib prefix="ctg" uri="customtags" %>
<%@ taglib prefix="m" uri="customMenu" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="url">${pageContext.request.requestURL}</c:set>
<c:set var="ctx"
       value="${fn:substring(url, 0, fn:length(url) - fn:length(pageContext.request.requestURI))}${pageContext.request.contextPath}"/>
<c:set var="current" value="${param.language}" scope="session"/>
<c:if test="${not empty current}">
    <fmt:setLocale value="${current}" scope="session"/>
</c:if>

<fmt:setBundle basename="browser" scope="session"/>
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
    <link rel="shortcut icon" href="images/smmNiFRJg98.jpg" type="image/png">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>
<c:if test="${model}">
    <div id="myModalBox" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">Modal Window Header</h4>
                </div>
                <div class="modal-body">
                        ${modelText}Please continue do something else.
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
    <script>
        $(document).ready(function() {
            $("#myModalBox").modal('show');
        });
    </script>
</c:if>
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
                <a href="${homeURL}" class="menu_link"><i class="fas fa-home"></i> <fmt:message key="homeLabel"/></a>
                <a href="#" class="menu_link"><i class="fas fa-newspaper"></i> <fmt:message key="aboutLabel"/></a>
                <a href="#contact" class="menu_link"><i class="fas fa-phone"></i> <fmt:message key="contactLabel"/></a>
                <c:url value="/review" var="reviewURL"/>
                <a href="${reviewURL}" class="menu_link"><i class="fas fa-list"></i> <fmt:message key="reviewLabel"/></a>
            </div>

            <div class="btn-group">
                <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <fmt:message key="languageLabel"/>
                </button>
                <div class="dropdown-menu">
                    <form class="dropdown-item">
                        <input type="hidden" name="language" value="en_US">
                        <input type="submit" class="dropdown-item" value="<fmt:message key="english"/>"/>
                    </form>
                    <form class="dropdown-item">
                        <input type="hidden" name="language" value="ru_RU">
                        <input type="submit" class="dropdown-item" value="<fmt:message key="russian"/>"/>
                    </form>
                    <form class="dropdown-item">
                        <input type="hidden" name="language" value="be_BY">
                        <input type="submit" class="dropdown-item" value="<fmt:message key="belarusian"/>"/>
                    </form>
                </div>
            </div>
            <c:choose>
                <c:when test="${user.role.name.equals('administrator')}">
                    <div class="btn-group">
                        <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <fmt:message key="actionLable"/>
                        </button>
                        <div class="dropdown-menu">
                            <c:url value="/profile" var="profileURL"/>
                            <a href="${profileURL}" class="dropdown-item"><fmt:message key="prof"/></a>
                            <c:url value="/createQuest" var="createQuestURL"/>
                            <a href="${createQuestURL}" class="dropdown-item"><fmt:message key="createQuestLabel"/></a>
                            <c:url value="/showOrders" var="showOrdersURL"/>
                            <a href="${showOrdersURL}" class="dropdown-item"><fmt:message key="ordersLabel"/></a>
                            <c:url value="/showUsers" var="showUsersURL"/>
                            <a href="${showUsersURL}" class="dropdown-item"><fmt:message key="usersLabel"/></a>
                            <c:url value="/removeUser" var="removeUserURL"/>
                            <a href="${removeUserURL}" class="dropdown-item"><fmt:message key="removeUserLabel"/></a>
                            <div class="dropdown-divider"></div>
                            <c:url value="/logout" var="logout"/>
                            <a href="${logout}" class="dropdown-item"><fmt:message key="logOut"/></a>
                        </div>
                    </div>
                </c:when>
                <c:when test="${user.role.name.equals('client')}">
                    <div class="btn-group">
                        <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <fmt:message key="actionLable"/>
                        </button>
                        <div class="dropdown-menu">
                            <c:url value="/profile" var="profileURL"/>
                            <a href="${profileURL}" class="dropdown-item"><fmt:message key="prof"/></a>
                            <c:url value="/myQuests" var="myQuestsURL"/>
                            <a href="${myQuestsURL}" class="dropdown-item"><fmt:message key="myQuest"/></a>
                            <div class="dropdown-divider"></div>
                            <c:url value="/logout" var="logout"/>
                            <a href="${logout}" class="dropdown-item"><fmt:message key="logOut"/></a>
                        </div>
                    </div>
                </c:when>
                <c:otherwise>
                    <c:url value="/login" var="loginURL"/>
                    <a href="${loginURL}" class="menu_link"><i class="fas fa-sign-in-alt"></i><fmt:message key="logIn"/></a>
                </c:otherwise>
            </c:choose>
        </div>
        <div class="header_slogan">
            <h1 class="h_slogan"><fmt:message key="header"/></h1><br>
            <c:url value="/quests" var="questsURL"/>
            <a href="${questsURL}" class="btn btn-warning btn-lg"><fmt:message key="allQuests"/></a>
        </div>
    </div>
</div><br><br>

<%--@elvariable id="oldPlace" type="by.epam.site.entity.QuestPlace"--%>
<c:set var="updateElem" value="${oldPlace}" />
<div class="container">
    <div class="col-lg-8 col-md-8 col-xs-12">
        <div class="panel">
            <div class="panel-body">
                    <hr>
                        <table class="table table-th-block">
                            <c:url value="/updateQuestInfo" var="updateQuestInfoURL"/>
                            <form action="${updateQuestInfoURL}" method="post" enctype="multipart/form-data">
                                <h4><fmt:message key="changeQuestPlaceInfoLabel"/>:</h4>
                                <table class="table table-th-block">
                                    <tbody>
                                    <label><fmt:message key="changeQuestAddressLabel"/>:</label><br>
                                    <input type="text" maxlength="254" name="addressName" class="form-control rounded" placeholder="<fmt:message key="newAddressLabel"/>" value="${updateElem.address}" required><br>
                                    <label><fmt:message key="changeNameLabel"/>:</label>
                                    <input type="text" maxlength="32" name="placeName" class="form-control border-valid" placeholder="<fmt:message key="newNameLabel"/>" value="${updateElem.name}" required><br>
                                    <label><fmt:message key="changePhoneLabel"/>:</label>
                                    <input type="tel" maxlength="9" name="phoneNumber" class="form-control border-valid" placeholder="xxxxxxxxx" pattern="[0-9]{9}" value="${updateElem.phone}" required>
                                    <hr>

                                    <h4><fmt:message key="changeQuestInfoLabel"/>:</h4>
                                    <label><fmt:message key="changeTitleLabel"/>:</label>
                                    <input type="text" maxlength="32" name="title" class="form-control border-valid" placeholder="<fmt:message key="changeTitleLabel"/>" value="${updateElem.quest.title}" required><br>
                                    <label><fmt:message key="changeLevelLabel"/>:</label>
                                    <input type="number" maxlength="1" name="level" class="form-control" placeholder="<fmt:message key="changeLevelLabel"/>" value="${updateElem.quest.level}" required><br>
                                    <label><fmt:message key="changeMaxPeopleLabel"/>:</label>
                                    <input type="number" maxlength="1" name="maxOfPeople" class="form-control" placeholder="<fmt:message key="changeMaxPeopleLabel"/>" value="${updateElem.quest.maxPeople}" required><br>
                                    <div class="md-form amber-textarea active-amber-textarea">
                                        <i class="fas fa-pencil-alt prefix"></i><label for="form22">&nbsp;&nbsp;<fmt:message key="changeDesctiptionLabel"/>:</label>
                                        <textarea id="form22" name="description" class="md-textarea form-control" rows="3">${updateElem.quest.description}</textarea>
                                    </div><br>
                                    <label for="exampleFormControlFile1"><fmt:message key="changePhotoLabel"/></label><br>
                                    <input name="fileLoader" accept=".jpg" type="file" class="btn btn-dark" id="exampleFormControlFile1" required><br><br>
                                    <input type="hidden" name="oldInfoId" value="${oldPlace.id}">
                                    <button class="btn btn-success" type="submit"><fmt:message key="updateInfoLabel"/></button><br><br>
                                    <div style="color: #ff7b7b; font-size: 18px;">
                                        ${crashMessage}
                                    </div>
                                    </tbody>
                                </table>
                            </form>
                        </table>
                </div>
            </div>
        </div>
    </div>
<br><br><br>
<!-- Footer -->
<footer class="page-footer font-small unique-color-dark">

    <div style="background-color: #6351ce;">
        <div class="container">
            <div class="row py-2 d-flex align-items-center">

                <div class="col-md-6 col-lg-5 text-center text-md-left mb-4 mb-md-0">
                    <h6 class="mb-0"><fmt:message key="sotialNetworks"/></h6>
                </div>

                <div class="col-md-6 col-lg-7 text-center text-md-right">
                    <a href="https://vk.com/mtpji1ons" style="color: black;" class="tw-ic"><i class="fab fa-vk white-text mr-4"> </i></a>
                    <a href="https://www.instagram.com/dimaterlyuke/" style="color: black;" class="ins-ic"><i class="fab fa-instagram white-text"> </i></a>
                </div>
            </div>
        </div>
    </div>

    <div class="container text-center text-md-left" style="background-color: #83a6ed;">
        <div class="row mt-3">
            <div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4" style="margin-top: 10px;">
                <h6 class="text-uppercase font-weight-bold">JukeBox</h6>
                <hr class="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">
                <p><fmt:message key="orderAQuestLabel"/></p>

            </div>
            <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4" style="margin-top: 10px;">

                <h6 class="text-uppercase font-weight-bold"><fmt:message key="typeQuestLabel"/></h6>
                <hr class="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">
                <p>Supernatural</p>
                <p>Gravitation</p>
                <p>Tower mage</p>

            </div>
            <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4" style="margin-top: 10px;">
                <h6 class="text-uppercase font-weight-bold"><fmt:message key="usefulLinksLabel"/></h6>
                <hr class="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">
                <p><a href="https://e.mail.ru/messages/inbox/?back=1">Mail</a></p>
            </div>
            <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4" style="margin-top: 10px;" id="contact">

                <h6 class="text-uppercase font-weight-bold"><fmt:message key="contactLabel"/></h6>
                <hr class="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">
                <p><i class="fas fa-home mr-3"></i> <fmt:message key="countryLabel"/>, <fmt:message key="cityLabel"/>, BY</p>
                <p><i class="fas fa-envelope mr-3"></i> lanselot2000_@mail.ru</p>
                <p><i class="fas fa-phone mr-3"></i> + 375 29 861 97 83</p>
            </div>
        </div>
    </div>
    <div class="footer-copyright text-center py-3" style="background-color: #161c27; color: #998d7e">© 2019 <fmt:message key="copyrightLabel"/>:
        <a href="https://mdbootstrap.com/education/bootstrap/" style="color: #f7f7f8"> JukeBox.com</a>
    </div>
</footer>
</body>
</html>