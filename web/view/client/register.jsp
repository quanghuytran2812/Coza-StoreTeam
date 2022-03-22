<%-- 
    Document   : register
    Created on : Feb 2, 2022, 11:32:24 PM
    Author     : tuan anh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:url value = "/view/client/assets" var="url"/>

<!--start main header-->
<jsp:include page="./header-common/mainHeader-c.jsp" flush="true" />
<!--end main header-->

<!--start cart-->
<jsp:include page="./cart/cart.jsp" flush="true" />
<!--end cart-->

<!-- Title page -->
<section class="bg-img1 txt-center p-lr-15 p-tb-92" style="background-image: url('${url}/images/bg-01.jpg');">
    <h2 class="ltext-105 cl0 txt-center">
        Register
    </h2>
</section>	

<!--content page {form login} -->
<section class="bg0 p-l-62 p-b-116">
    <div class="container">
        <div class="p-t-10">
            <div class="bor10 p-lr-70 p-t-55 p-b-70 p-lr-15-lg w-full-md">
                <form action="register" method="post">
                    <h2 class="mtext-105 cl2 txt-center p-b-30">
                        Register here!
                    </h2>

                    <div class="bor8 m-b-30">
                        <input class="stext-111 cl2 plh3 p-lr-15 size-116 p-r-30" type="text" name="email" placeholder="Your Email Address">
                    </div>

                    <div class="bor8 m-b-30">
                        <input class="stext-111 cl2 plh3 p-lr-15 size-116 p-r-30" type="text" name="uname" placeholder="Your User Name">
                    </div>

                    <div class="bor8 m-b-30">
                        <input class="stext-111 cl2 plh3 p-lr-15 size-116 p-r-30" type="password" name="password" id="myPass" placeholder="Your Password">
                    </div>

                    <div class="bor8 m-b-30">
                        <input class="stext-111 cl2 plh3 p-lr-15 size-116 p-r-30" type="password" name="passConfirm" id="myPassConf" placeholder="Your Confirm Password">
                    </div>

                    <div class="m-b-20 how-pos4-parent">
                        <input type="checkbox" onclick="FunctShowPass()">Show Password
                    </div>
                    <h2 class="text-danger"> ${alert}</h2>
                    <div class="container">
                        <button class="flex-c-m stext-101 cl0 size-121 bg3 bor1 hov-btn3 p-lr-15 trans-04 pointer">
                            Create Account
                        </button>
                    </div>
                    <hr>
                    <a href="${pageContext.request.contextPath}/login" class="flex-c-m stext-101 cl0 size-121 bg3 bor1 hov-btn3 p-lr-15 trans-04 pointer">
                        If already have an account? Login here!
                    </a>

                </form>
            </div>
        </div>
    </div>
</section>
<!--end content page--> 

<!--start footer-->
<jsp:include page="./footer/footer.jsp" flush="true" />
<!--end footer-->
