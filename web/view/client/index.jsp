<%-- 
    Document   : index
    Created on : Jan 28, 2022, 3:01:38 PM
    Author     : tuan anh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:url value = "/view/client/assets" var="url"/>

<!--start main header-->
<jsp:include page="./header/mainHeader.jsp" flush="true" />
<!--end main header-->

<!--start side bar-->
<jsp:include page="./sider-bar/sider-bar.jsp" flush="true" />
<!--end side bar-->

<!--start cart-->
<jsp:include page="./cart/cart.jsp" flush="true" />
<!--end cart-->

<!--start slider-->
<jsp:include page="./banner-slider/slider.jsp" flush="true" />
<!--end slider-->

<!--start main header-->
<jsp:include page="./banner-slider/banner.jsp" flush="true" />
<!--end main header-->

<!--start product-->
<section class="bg0 p-t-23 p-b-130">
    <div class="container">
        <div class="p-b-10">
            <h3 class="ltext-103 cl5">
                Product Overview
            </h3>
        </div>

        <div class="flex-w flex-sb-m p-b-52">

            <div class="flex-w flex-l-m filter-tope-group m-tb-10">
                <button class="stext-106 cl6 hov1 bor3 trans-04 m-r-32 m-tb-5 how-active1" data-filter="*">
                    All Products
                </button>

                <c:forEach items="${cwelcome}" var="cw" >

                    <button class="stext-106 cl6 hov1 bor3 trans-04 m-r-32 m-tb-5" data-filter=".${cw.cname}">
                        ${cw.cname}
                    </button>

                </c:forEach>

            </div>


            <div class="flex-w flex-c-m m-tb-10">
                <div
                    class="flex-c-m stext-106 cl6 size-104 bor4 pointer hov-btn3 trans-04 m-r-8 m-tb-4 js-show-filter">
                    <i class="icon-filter cl2 m-r-6 fs-15 trans-04 zmdi zmdi-filter-list"></i>
                    <i class="icon-close-filter cl2 m-r-6 fs-15 trans-04 zmdi zmdi-close dis-none"></i>
                    Filter
                </div>

                <div class="flex-c-m stext-106 cl6 size-105 bor4 pointer hov-btn3 trans-04 m-tb-4 js-show-search">
                    <i class="icon-search cl2 m-r-6 fs-15 trans-04 zmdi zmdi-search"></i>
                    <i class="icon-close-search cl2 m-r-6 fs-15 trans-04 zmdi zmdi-close dis-none"></i>
                    Search
                </div>
            </div>

            <!-- Search product -->
            <div class="dis-none panel-search w-full p-t-10 p-b-15">
                <div class="bor8 dis-flex p-l-15">
                    <button class="size-113 flex-c-m fs-16 cl2 hov-cl1 trans-04">
                        <i class="zmdi zmdi-search"></i>
                    </button>

                    <input class="mtext-107 cl2 size-114 plh2 p-r-15" type="text" name="search-product"
                           placeholder="Search">
                </div>
            </div>

            <!-- Filter -->
            <div class="dis-none panel-filter w-full p-t-10">
                <div class="wrap-filter flex-w bg6 w-full p-lr-40 p-t-27 p-lr-15-sm">
                    <div class="filter-col1 p-r-15 p-b-27">
                        <div class="mtext-102 cl2 p-b-15">
                            Sort By
                        </div>

                        <ul>
                            <li class="p-b-6">
                                <a href="#" class="filter-link stext-106 trans-04">
                                    Default
                                </a>
                            </li>

                            <li class="p-b-6">
                                <a href="#" class="filter-link stext-106 trans-04">
                                    Popularity
                                </a>
                            </li>

                            <li class="p-b-6">
                                <a href="#" class="filter-link stext-106 trans-04">
                                    Average rating
                                </a>
                            </li>

                            <li class="p-b-6">
                                <a href="#" class="filter-link stext-106 trans-04 filter-link-active">
                                    Newness
                                </a>
                            </li>

                            <li class="p-b-6">
                                <a href="#" class="filter-link stext-106 trans-04">
                                    Price: Low to High
                                </a>
                            </li>

                            <li class="p-b-6">
                                <a href="#" class="filter-link stext-106 trans-04">
                                    Price: High to Low
                                </a>
                            </li>
                        </ul>
                    </div>

                    <div class="filter-col2 p-r-15 p-b-27">
                        <div class="mtext-102 cl2 p-b-15">
                            Price
                        </div>

                        <ul>
                            <li class="p-b-6">
                                <a href="#" class="filter-link stext-106 trans-04 filter-link-active">
                                    All
                                </a>
                            </li>

                            <li class="p-b-6">
                                <a href="#" class="filter-link stext-106 trans-04">
                                    $0.00 - $50.00
                                </a>
                            </li>

                            <li class="p-b-6">
                                <a href="#" class="filter-link stext-106 trans-04">
                                    $50.00 - $100.00
                                </a>
                            </li>

                            <li class="p-b-6">
                                <a href="#" class="filter-link stext-106 trans-04">
                                    $100.00 - $150.00
                                </a>
                            </li>

                            <li class="p-b-6">
                                <a href="#" class="filter-link stext-106 trans-04">
                                    $150.00 - $200.00
                                </a>
                            </li>

                            <li class="p-b-6">
                                <a href="#" class="filter-link stext-106 trans-04">
                                    $200.00+
                                </a>
                            </li>
                        </ul>
                    </div>

                    <div class="filter-col3 p-r-15 p-b-27">
                        <div class="mtext-102 cl2 p-b-15">
                            Color
                        </div>

                        <ul>
                            <li class="p-b-6">
                                <span class="fs-15 lh-12 m-r-6" style="color: #222;">
                                    <i class="zmdi zmdi-circle"></i>
                                </span>

                                <a href="#" class="filter-link stext-106 trans-04">
                                    Black
                                </a>
                            </li>

                            <li class="p-b-6">
                                <span class="fs-15 lh-12 m-r-6" style="color: #4272d7;">
                                    <i class="zmdi zmdi-circle"></i>
                                </span>

                                <a href="#" class="filter-link stext-106 trans-04 filter-link-active">
                                    Blue
                                </a>
                            </li>

                            <li class="p-b-6">
                                <span class="fs-15 lh-12 m-r-6" style="color: #b3b3b3;">
                                    <i class="zmdi zmdi-circle"></i>
                                </span>

                                <a href="#" class="filter-link stext-106 trans-04">
                                    Grey
                                </a>
                            </li>

                            <li class="p-b-6">
                                <span class="fs-15 lh-12 m-r-6" style="color: #00ad5f;">
                                    <i class="zmdi zmdi-circle"></i>
                                </span>

                                <a href="#" class="filter-link stext-106 trans-04">
                                    Green
                                </a>
                            </li>

                            <li class="p-b-6">
                                <span class="fs-15 lh-12 m-r-6" style="color: #fa4251;">
                                    <i class="zmdi zmdi-circle"></i>
                                </span>

                                <a href="#" class="filter-link stext-106 trans-04">
                                    Red
                                </a>
                            </li>

                            <li class="p-b-6">
                                <span class="fs-15 lh-12 m-r-6" style="color: #aaa;">
                                    <i class="zmdi zmdi-circle-o"></i>
                                </span>

                                <a href="#" class="filter-link stext-106 trans-04">
                                    White
                                </a>
                            </li>
                        </ul>
                    </div>

                    <div class="filter-col4 p-b-27">
                        <div class="mtext-102 cl2 p-b-15">
                            Tags
                        </div>

                        <div class="flex-w p-t-4 m-r--5">
                            <a href="#"
                               class="flex-c-m stext-107 cl6 size-301 bor7 p-lr-15 hov-tag1 trans-04 m-r-5 m-b-5">
                                Fashion
                            </a>

                            <a href="#"
                               class="flex-c-m stext-107 cl6 size-301 bor7 p-lr-15 hov-tag1 trans-04 m-r-5 m-b-5">
                                Lifestyle
                            </a>

                            <a href="#"
                               class="flex-c-m stext-107 cl6 size-301 bor7 p-lr-15 hov-tag1 trans-04 m-r-5 m-b-5">
                                Denim
                            </a>

                            <a href="#"
                               class="flex-c-m stext-107 cl6 size-301 bor7 p-lr-15 hov-tag1 trans-04 m-r-5 m-b-5">
                                Streetstyle
                            </a>

                            <a href="#"
                               class="flex-c-m stext-107 cl6 size-301 bor7 p-lr-15 hov-tag1 trans-04 m-r-5 m-b-5">
                                Crafts
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="row isotope-grid">

            <c:forEach items="#{pwelcome}" var="pw" >
                <div class="col-sm-6 col-md-4 col-lg-3 p-b-35 isotope-item ${pw.pcate.cname}">
                    <!-- Block2 -->
                    <div class="block2">
                        <c:if test="${pw.pisNew == true}">
                            <div class="block2-pic hov-img0 label-new" data-label="New">
                            </c:if>
                            <c:if test="${pw.pisNew == false}">
                                <div class="block2-pic hov-img0">
                                </c:if>
                                    <c:url value="/pics/${pw.pimg}" var="imgUrl"></c:url>
                                <img src="${imgUrl}" alt="IMG-PRODUCT">

                                <a href="#"
                                   class="block2-btn flex-c-m stext-103 cl2 size-102 bg0 bor2 hov-btn1 p-lr-15 trans-04 js-show-modal1">
                                    Quick View
                                </a>
                            </div>

                            <c:if test="${pw.pdiscount != 0}">
                                <div class="block2-txt flex-w flex-t p-t-14 label-dis" data-label="${pw.pdiscount}%">
                                </c:if>
                                <c:if test="${pw.pdiscount == 0}">
                                    <div class="block2-txt flex-w flex-t p-t-14" >
                                    </c:if>
                                    <div class="block2-txt-child1 flex-col-l ">
                                        <a href="${pageContext.request.contextPath}/product/detail?pid=${pw.pid}&&cid=${pw.cid}" class="stext-104 cl4 hov-cl1 trans-04 js-name-b2 p-b-6">
                                            ${pw.pname}
                                        </a>

                                        <span class="stext-105 cl3">
                                            <c:if test="${pw.pdiscount != 0}">
                                                <span style="text-decoration: line-through;">$${pw.pprice}</span> - <span style="color: red;" >$${pw.getDisPrice()}</span>
                                            </c:if>
                                            <c:if test="${pw.pdiscount == 0}">
                                                $${pw.pprice}
                                            </c:if>
                                        </span>
                                    </div>  

                                    <div class="block2-txt-child2 flex-r p-t-3">
                                        <h4 class="mtext-105 cl2 js-name-detail p-b-14">
                                        </h4>
                                        <a href="${pageContext.request.contextPath}/member/cart/add?pid=${pw.pid}&&quantity=1" class="text-white flex-c-m stext-101 cl0 bg1 bor1 hov-btn1 p-lr-5 trans-04 js-addcart-detail" >
                                            <i class="zmdi zmdi-shopping-cart text-center"></i>
                                        </a>

                                        <a href="#" class="btn-addwish-b2 dis-block pos-relative js-addwish-b2">
                                            <img class="icon-heart1 dis-block trans-04" src="${url}/images/icons/icon-heart-01.png"
                                                 alt="ICON">
                                            <img class="icon-heart2 dis-block trans-04 ab-t-l"
                                                 src="${url}/images/icons/icon-heart-02.png" alt="ICON">
                                        </a>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>

                </div>

                <!-- Pagination -->
                <div class="flex-c-m flex-w w-full p-t-38">
                    <a href="#" class="flex-c-m how-pagination1 trans-04 m-all-7 active-pagination1">
                        1
                    </a>

                    <a href="#" class="flex-c-m how-pagination1 trans-04 m-all-7">
                        2
                    </a>
                </div>
            </div>
            </section>
            <!--end product-->

            <!--start blog-->
            <jsp:include page="./blog/blog.jsp" flush="true" />
            <!--end blog-->

            <!--start main header-->
            <jsp:include page="./footer/footer.jsp" flush="true" />
            <!--end main header-->