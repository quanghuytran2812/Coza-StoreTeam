<%-- 
    Document   : menu-mobile
    Created on : Jan 28, 2022, 3:29:55 PM
    Author     : tuan anh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:url value = "/view/client/assets" var="url"/>

<div class="menu-mobile">
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

        <c:if test="${sessionScope.account.usname != null}">
            <li><a href="${pageContext.request.contextPath}/member/view/client/myaccount" >
                    ${sessionScope.account.usname}
                </a> |
                <a href="${pageContext.request.contextPath}/view/client/logout" >
                    Logout
                </a>
            </li>
        </c:if>

        <c:if test="${sessionScope.account.usname == null}">
            <li> <a href="${pageContext.request.contextPath}/member/view/client/myaccount" >
                    My Account
                </a> </li>
            </c:if>

        <li>
            <a href="contact.html">Help & FAQs</a>
        </li>

        <li>
            <a href="contact.html">Track Order</a>
        </li>
    </ul>
</div>