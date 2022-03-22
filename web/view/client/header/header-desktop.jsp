<%-- 
    Document   : header-desktop
    Created on : Jan 28, 2022, 3:29:03 PM
    Author     : tuan anh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:url value = "/view/client/assets" var="url"/>

<div class="container-menu-desktop trans-03">
    <div class="wrap-menu-desktop">
        <nav class="limiter-menu-desktop p-l-45">

            <!-- Logo desktop -->
            <a href="${pageContext.request.contextPath}" class="logo">
                <img src="${url}/images/icons/logo-02.png" alt="IMG-LOGO">
            </a>

            <!-- Menu desktop -->
            <jsp:include page="menu-desktop.jsp" flush="true" />

            <!-- Icon header -->
            <div class="wrap-icon-header flex-w flex-r-m h-full">

                <div class="flex-c-m h-full p-r-24 bor6">
                    <div class="icon-header-item cl0 hov-cl1 trans-04 p-lr-11  js-show-modal-search">
                        <i class="zmdi zmdi-search"></i>
                    </div>
                </div>

                <div class="flex-c-m h-full p-r-25 bor6">
                    <c:set var="count" value="${0}" />
                    <c:forEach items="${sessionScope.cart}" var="map">
                        <c:set var="count" value="${count + map.value.iquantity}" />
                    </c:forEach>
                    <div class="icon-header-item cl0 hov-cl1 trans-04 p-lr-11 icon-header-noti js-show-cart"
                         data-notify="${count}">
                        <i class="zmdi zmdi-shopping-cart"></i>
                    </div>
                </div>

                <div class="flex-c-m h-full p-lr-19">
                    <div class="icon-header-item cl0 hov-cl1 trans-04 p-lr-11 js-show-sidebar">
                        <i class="zmdi zmdi-menu"></i>
                    </div>
                </div>
            </div>
        </nav>
    </div>
</div>
