<%-- 
    Document   : menu-mobile-c
    Created on : Feb 2, 2022, 10:17:31 PM
    Author     : tuan anh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:url value = "/view/client/assets" var="url"/>

<div class="menu-mobile">
    <ul class="topbar-mobile">
        <li>
            <div class="left-top-bar">
                Free shipping for standard order over $100
            </div>
        </li>

        <li>
            <div class="right-top-bar flex-w h-full">
                <a href="#" class="flex-c-m p-lr-10 trans-04">
                    Help & FAQs
                </a>

                <c:if test="${sessionScope.account.usname != null}">
                    <a href="${pageContext.request.contextPath}/member/myaccount" class="flex-c-m p-lr-10 trans-04">
                        ${sessionScope.account.usname}
                    </a>
                    <a href="${pageContext.request.contextPath}/logout" class="flex-c-m p-lr-10 trans-04">
                        Logout
                    </a>
                </c:if>

                <c:if test="${sessionScope.account.usname == null}">
                    <a href="${pageContext.request.contextPath}/member/myaccount" class="flex-c-m p-lr-10 trans-04">
                        My Account
                    </a>
                </c:if>

                <a href="#" class="flex-c-m p-lr-10 trans-04">
                    EN
                </a>

                <a href="#" class="flex-c-m p-lr-10 trans-04">
                    USD
                </a>
            </div>
        </li>
    </ul>

    <ul class="main-menu-m">
        <li>
            <a href="${pageContext.request.contextPath}">Home</a>
        </li>

        <li>
            <a href="${pageContext.request.contextPath}/product/list">Shop</a>
        </li>

        <li>
            <a href="shoping-cart.html" class="label1 rs1" data-label1="hot">Features</a>
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
