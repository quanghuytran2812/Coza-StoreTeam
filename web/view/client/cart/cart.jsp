<%-- 
    Document   : cart
    Created on : Jan 28, 2022, 4:05:15 PM
    Author     : tuan anh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:url value = "/view/client/assets" var="url"/>

<div class="wrap-header-cart js-panel-cart">
    <div class="s-full js-hide-cart"></div>

    <div class="header-cart flex-col-l p-l-65 p-r-25">
        <div class="header-cart-title flex-w flex-sb-m p-b-8">
            <span class="mtext-103 cl2">
                Your Cart
            </span>

            <div class="fs-35 lh-10 cl2 p-lr-5 pointer hov-cl1 trans-04 js-hide-cart">
                <i class="zmdi zmdi-close"></i>
            </div>
        </div>

        <div class="header-cart-content flex-w js-pscroll">
            <ul class="header-cart-wrapitem w-full">

                <c:forEach items="${sessionScope.cart}" var="map" >
                    <li class="header-cart-item flex-w flex-t m-b-12">
                        <a href="${pageContext.request.contextPath}/member/cart/remove?pid=${map.value.product.pid}" class="header-cart-item-img">
                            <img src="${url}/images/${map.value.product.pimg}" alt="IMG">
                        </a>

                        <div class="header-cart-item-txt p-t-8">
                            <a href="#" class="header-cart-item-name m-b-18 hov-cl1 trans-04">
                                ${map.value.product.pname }
                            </a>

                            <span class="header-cart-item-info">
                                ${map.value.iquantity } x ${map.value.product.getDisPrice() }
                            </span>
                        </div>
                    </li>
                </c:forEach>

            </ul>

            <div class="w-full">
                <c:set var="total" value="${0}" />
                <c:forEach items="${sessionScope.cart}" var="map">
                    <c:set var="total" value="${total + map.value.iquantity * map.value.product.getDisPrice()}" />
                </c:forEach>
                <div class="header-cart-total w-full p-tb-40">
                    Total: $${total}
                </div>

                <div class="header-cart-buttons flex-w w-full">
                    <a href="${pageContext.request.contextPath}/member/cart"
                       class="flex-c-m stext-101 cl0 size-107 bg3 bor2 hov-btn3 p-lr-15 trans-04 m-r-8 m-b-10">
                        View Cart
                    </a>

                    <a href="${pageContext.request.contextPath}/member/order"
                       class="flex-c-m stext-101 cl0 size-107 bg3 bor2 hov-btn3 p-lr-15 trans-04 m-b-10">
                        Check Out
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>
