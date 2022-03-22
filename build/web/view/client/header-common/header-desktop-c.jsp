<%-- 
    Document   : header-desktop-c
    Created on : Feb 2, 2022, 10:16:31 PM
    Author     : tuan anh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:url value = "/view/client/assets" var="url"/>

<div class="container-menu-desktop">
    <!-- Topbar -->
    <div class="top-bar">
        <div class="content-topbar flex-sb-m h-full container">
            <div class="left-top-bar">
                Free shipping for standard order over $100
            </div>

            <div class="right-top-bar flex-w h-full">
                <a href="#" class="flex-c-m trans-04 p-lr-25">
                    Help & FAQs
                </a>
                <c:if test="${sessionScope.account.usname != null}">
                    <a href="${pageContext.request.contextPath}/member/myaccount" class="flex-c-m trans-04 p-lr-25">
                        ${sessionScope.account.usname}
                    </a>
                    <a href="${pageContext.request.contextPath}/logout" class="flex-c-m trans-04 p-lr-25">
                        Logout
                    </a>
                </c:if>

                <c:if test="${sessionScope.account.usname == null}">
                    <a href="${pageContext.request.contextPath}/member/myaccount" class="flex-c-m trans-04 p-lr-25">
                        My Account
                    </a>
                </c:if>

                <a href="#" class="flex-c-m trans-04 p-lr-25">
                    EN
                </a>

                <a href="#" class="flex-c-m trans-04 p-lr-25">
                    USD
                </a>
            </div>
        </div>
    </div>

    <div class="wrap-menu-desktop">
        <nav class="limiter-menu-desktop container">

            <!-- Logo desktop -->		
            <a href="${pageContext.request.contextPath}" class="logo">
                <img src="${url}/images/icons/logo-01.png" alt="IMG-LOGO">
            </a>

            <!-- Menu desktop -->
            <jsp:include page="menu-desktop-c.jsp" flush="true" />

            <!-- Icon header -->
            <div class="wrap-icon-header flex-w flex-r-m">
                <div class="icon-header-item cl2 hov-cl1 trans-04 p-l-22 p-r-11 js-show-modal-search">
                    <i class="zmdi zmdi-search"></i>
                </div>
                <c:set var="count" value="${0}" />
                <c:forEach items="${sessionScope.cart}" var="map">
                    <c:set var="count" value="${count + map.value.iquantity}" />
                </c:forEach>
                <div class="icon-header-item cl2 hov-cl1 trans-04 p-l-22 p-r-11 icon-header-noti js-show-cart" data-notify="${count}">
                    <i class="zmdi zmdi-shopping-cart"></i>
                </div>

                <a href="#" class="dis-block icon-header-item cl2 hov-cl1 trans-04 p-l-22 p-r-11 icon-header-noti" data-notify="0">
                    <i class="zmdi zmdi-favorite-outline"></i>
                </a>
            </div>
        </nav>
    </div>	
</div>