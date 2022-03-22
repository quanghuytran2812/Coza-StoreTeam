<%-- 
    Document   : mainHeader-c
    Created on : Feb 2, 2022, 10:16:56 PM
    Author     : tuan anh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:url value = "/view/client/assets" var="url"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Coza Store - A sense of style</title>

        <!--===============================================================================================-->
        <link rel="icon" type="image/png" href="${url}/images/icons/favicon.png" />
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="${url}/vendor/bootstrap/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="${url}/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="${url}/fonts/iconic/css/material-design-iconic-font.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="${url}/fonts/linearicons-v1.0.0/icon-font.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="${url}/vendor/animate/animate.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="${url}/vendor/css-hamburgers/hamburgers.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="${url}/vendor/animsition/css/animsition.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="${url}/vendor/select2/select2.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="${url}/vendor/daterangepicker/daterangepicker.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="${url}/vendor/slick/slick.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="${url}/vendor/MagnificPopup/magnific-popup.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="${url}/vendor/perfect-scrollbar/perfect-scrollbar.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="${url}/css/util.css">
        <link rel="stylesheet" type="text/css" href="${url}/css/main.css">
        <!--===============================================================================================-->

    </head>

    <body class="animsition">

        <!-- Header -->
        <header class="header-v4">

            <!--start header desktop common-->
            <jsp:include page="header-desktop-c.jsp" flush="true" />
            <!--end header desktop common-->
            
            <!--start header moblie common-->
            <jsp:include page="header-mobile-c.jsp" flush="true" />
            <!--end header mobile common-->
            
            <!--start menu moblie common-->
            <jsp:include page="menu-mobile-c.jsp" flush="true" />
            <!--end menu moblie common-->
            
            <!--start search-->
            <jsp:include page="../header/search.jsp" flush="true" />
            <!--end search-->

        </header>
        <!--end header-->

    </body>
