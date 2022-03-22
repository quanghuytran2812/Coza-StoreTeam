<%-- 
    Document   : header-moblie
    Created on : Jan 28, 2022, 3:29:43 PM
    Author     : tuan anh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:url value = "/view/client/assets" var="url"/>

<div class="wrap-header-mobile">
    <!-- Logo moblie -->
    <div class="logo-mobile">
        <a href="${pageContext.request.contextPath}"><img src="${url}/images/icons/logo-01.png" alt="IMG-LOGO"></a>
    </div>

    <!-- Icon header -->
    <div class="wrap-icon-header flex-w flex-r-m h-full m-r-15">
        <div class="flex-c-m h-full p-r-5">
            <c:set var="count" value="${0}" />
            <c:forEach items="${sessionScope.cart}" var="map">
                <c:set var="count" value="${count + map.value.iquantity}" />
            </c:forEach>
            <div class="icon-header-item cl2 hov-cl1 trans-04 p-lr-11 icon-header-noti js-show-cart"
                 data-notify="${count}">
                <i class="zmdi zmdi-shopping-cart"></i>
            </div>
        </div>
    </div>

    <!-- Button show menu -->
    <div class="btn-show-menu-mobile hamburger hamburger--squeeze">
        <span class="hamburger-box">
            <span class="hamburger-inner"></span>
        </span>
    </div>
</div>
