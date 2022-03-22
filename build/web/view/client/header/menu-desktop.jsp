<%-- 
    Document   : menu-desktop
    Created on : Jan 28, 2022, 3:29:49 PM
    Author     : tuan anh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:url value = "/view/client/assets" var="url"/>

<div class="menu-desktop">
    <ul class="main-menu">
        <li>
            <a href="${pageContext.request.contextPath}">Home</a>
        </li>

        <li>
            <a href="${pageContext.request.contextPath}/product/list">Shop</a>
        </li>

        <li class="label1" data-label1="hot">
            <a href="shoping-cart.html">Features</a>
        </li>

        <li>
            <a href="blog.html">Blog</a>
        </li>

        <li>
            <a href="about.html">About</a>
        </li>

        <li>
            <a href="contact.html">Contact</a>
        </li>
    </ul>
</div>
