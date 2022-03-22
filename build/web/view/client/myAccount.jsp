<%-- 
    Document   : myAccount
    Created on : Feb 2, 2022, 12:17:26 AM
    Author     : tuan anh
--%>

<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
        ${sessionScope.account.usname}
    </h2>
</section>

<form action="${pageContext.request.contextPath}/member/myaccount" enctype="multipart/form-data" method="post">
    <section class="bg0 p-t-104 p-b-30">
        <div class="container">
            <div class="flex-w flex-tr">
                <div class="size-210 bor10 p-lr-70 p-t-55 p-b-70 p-lr-15-lg w-full-md">
                    <h4 class="mtext-105 cl2 txt-center p-b-30">

                        <span class="fs-35 cl5 txt-center size-211">
                            <span class="lnr lnr-user"></span>
                        </span>

                        ${sessionScope.account.usname}
                    </h4>
                    <input name="uid" value="${sessionScope.account.uid }" hidden="">
                    <input name="urole" value="${sessionScope.account.urole }" hidden="">
                    Email: 
                    <div class="bor8 m-b-20 how-pos4-parent">
                        <input class="stext-111 cl2 plh3 size-116 p-l-22 p-r-30" value="${sessionScope.account.uemail}" type="text" name="uemail" placeholder="Your Email Address">
                    </div>
                    UserName: 
                    <div class="bor8 m-b-20 how-pos4-parent">
                        <input class="stext-111 cl2 plh3 size-116 p-l-22 p-r-30" value="${sessionScope.account.usname}" type="text" name="usname" placeholder="Your UserName">
                    </div>
                    Password:
                    <div class="bor8 m-b-20 how-pos4-parent">
                        <input class="stext-111 cl2 plh3 size-116 p-l-22 p-r-30" value="${sessionScope.account.upassword}" type="password" name="upassword" id="myPass" placeholder="Your Password">
                    </div>

                    <div class="m-b-20 how-pos4-parent">
                        <input type="checkbox" onclick="FunctShowPass()"> <span class="lnr lnr-eye"></span> Show Password
                    </div>

                    <button class="flex-c-m stext-101 cl0 size-121 bg3 bor1 hov-btn3 p-lr-15 trans-04 pointer">
                        Submit
                    </button>
                </div>



                <div class="size-210 bor10 flex-w flex-col-m p-lr-93 p-tb-30 p-lr-15-lg w-full-md">

                    <h4 class="mtext-105 cl2 txt-right p-b-30">

                        <a href="${pageContext.request.contextPath }/logout" class="lnr lnr-redo">Logout!</a>

                    </h4>

                    <div class="flex-w w-full p-b-42">
                        <c:url value="/pics/${sessionScope.account.uavatar}" var="imgUrl"></c:url>
                            <div class="size-212">
                                <span class="fs-35 cl5 txt-center size-211">
                                    <span class="lnr lnr-picture"></span>
                                    <input type="file" name="uavatar" value="${imgUrl}" class="bor10 fs-15">
                                </span>

                                <div class="flex-w flex-sb p-t-36 gallery-lb rounded-circle">
                                    <div class="wrap-item-gallery m-b-10 size-212 rounded-circle">
                                        <a class="item-gallery bg-img1 rounded-circle bor10 border-dark" href="${imgUrl}" data-lightbox="gallery"
                                       style="background-image: url('${imgUrl}');"></a>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </section>	
</form>
                 

<!--start footer-->
<jsp:include page="./footer/footer.jsp" flush="true" />
<!--end footer-->
