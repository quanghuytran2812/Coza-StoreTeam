<%-- 
    Document   : login
    Created on : Feb 13, 2022, 9:25:53 AM
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
<section class="bg-img1 txt-center p-lr-15 p-tb-92" style="background-image: url('${url}/images/bg-02.jpg');">
    <h2 class="ltext-105 cl0 txt-center">
        Login
    </h2>
</section>	

<!--content page {form login} -->
<section class="bg0 p-l-62 p-b-70">
    <div class="container">
        <div class="p-t-10">
            <div class="bor10 p-lr-70 p-t-55 p-b-70 w-full-md">
                <form action="login" method="post">
                    <h4 class="mtext-105 cl2 txt-center p-b-30">
                        Login Here!
                    </h4>

                    <div class="bor8 m-b-30">
                        <input class="stext-111 cl2 plh3 p-lr-15 size-116 p-r-30" type="text" name="uname" placeholder="Your User Name">
                    </div>

                    <div class="bor8 m-b-30">
                        <input class="stext-111 cl2 plh3 p-lr-15 size-116 p-r-30" type="password" name="password" id="myPass" placeholder="Your Password">
                    </div>
                    <div class="m-b-30">
                        <input type="checkbox" onclick="FunctShowPass()"> <span class="lnr lnr-eye"></span> Show Password
                    </div>
                    <div class="bor8 m-b-30">
                        <input class="stext-111 cl2 plh3 p-lr-15 size-116 p-r-30" type="text" name="vcode" id="myPass" placeholder="Your Verify Code">
                    </div>
                    <div class="m-b-30">
                        Remember me! <input class="p-r-30" type="checkbox" name="remember" >
                    </div>
                    <div class="m-b-30 text-danger">
                        <h3>${alert}</h3>
                    </div>
                    <div class="m-b-30 text-success">
                        <h3>${alert1}</h3>
                    </div>
                    <div class="m-b-30 text-danger">
                        <h3>${sessionScope.FailVerify}</h3>
                    </div>
                    <div class="container">
                        <button class="flex-c-m stext-101 cl0 size-121 bg3 bor1 hov-btn3 p-lr-15 trans-04 pointer">
                            Login
                        </button>
                    </div>
                    <hr>
                    <a href="${pageContext.request.contextPath}/register" class="flex-c-m stext-101 cl0 size-121 bg3 bor1 hov-btn3 p-lr-15 trans-04 pointer">
                        If don't have account? Register here!
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
