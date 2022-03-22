<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Start header section -->
<%
    response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setHeader("Expires", "0");
%>
<jsp:include page = "./header/header.jsp" flush = "true" />

<div class="content-wrapper">
    <div class="container-fluid">

        <div class="row mt-3">
            <div class="col-lg-12">
                <div class="card">
                    <div class="card-body">
                        <div class="card-title">Add User</div>
                        <h1 style="color: red;" >${errMsg}</h1>
                        <hr>
                        <form action="${pageContext.request.contextPath}/admin/user/add" enctype="multipart/form-data" method="post">

                            <div class="form-group">
                                <label for="input-2">Email</label>
                                <input type="text" class="form-control" id="input-3" placeholder="Nhập địa chỉ Email" name="uemail">
                            </div>
                            <div class="form-group">
                                <label for="input-1">Avatar</label>
                                <input type="file" class="form-control" id="input-2" placeholder="Avatar" name="uavatar">
                            </div>
                            <div class="form-group">
                                <label for="input-3">UserName</label>
                                <input type="text" class="form-control" id="input-5" placeholder="Nhập User Name" name="usname">
                            </div>
                            <div class="form-group">
                                <label for="input-4">Password</label>
                                <input type="password" class="form-control" id="myinput" placeholder="Nhập mật khẩu" name="upassword">
                                <input type="checkbox" onclick="myFunction1()">Show Password
                                <script>function myFunction1() {
                                        var x = document.getElementById("myinput");
                                        if (x.type === "password") {
                                            x.type = "text";
                                        } else {
                                            x.type = "password";
                                        }
                                    }
                                </script>                   
                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn btn-light px-5"><i class="icon-lock"></i> Add</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="overlay toggle-menu"></div>
    </div>
</div>
<script>
    var date = new Date();

    var day = date.getDate();
    var month = date.getMonth() + 1;
    var year = date.getFullYear();

    if (month < 10)
        month = "0" + month;
    if (day < 10)
        day = "0" + day;

    var today = year + "-" + month + "-" + day;


    document.getElementById('the-date').value = today;
</script>

<jsp:include page = "./footer/footer.jsp" flush = "true" />