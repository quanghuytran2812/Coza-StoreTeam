<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Start header section -->
<jsp:include page = "./header/header.jsp" flush = "true" />

<div class="content-wrapper">
    <div class="container-fluid">

        <div class="row mt-3">
            <div class="col-lg-12">
                <div class="card">
                    <div class="card-body">
                        <div class="card-title">Edit User</div>
                        <hr>
                        <form action="${pageContext.request.contextPath}/admin/user/edit" enctype="multipart/form-data" method="post">
                            <div class="form-group">
                                <label for="input-1">ID</label>
                                <input type="text" class="form-control" id="input-1" readonly="readonly" placeholder="uid" value="${user.uid}" name="uid">
                            </div>
                            <div class="form-group">
                                <c:url value="/pics/${user.uavatar}" var="imgUrl"></c:url>
                                <label for="input-1">Avatar</label>
                                <input type="file" class="form-control" id="input-2" placeholder="${uavatar}" value="${uavatar}" name="uavatar">
                            </div>
                            <div class="form-group">
                                <label for="input-2">Email</label>
                                <input type="text" class="form-control" id="input-3" placeholder="Địa chỉ Email" value="${user.uemail}" name="uemail">
                            </div>
                            <div class="form-group">
                                <label for="input-3">Username</label>
                                <input type="text" class="form-control" id="input-4" placeholder="ten account" value="${user.usname}" name="usname">
                            </div>
                            <div class="form-group">
                                <label for="input-4">Password</label>
                                <input type="password" class="form-control" id="myinput" placeholder="Mật khẩu" value="${user.upassword}" name="upassword">
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
                                <label for="input-3">Role</label>
                                <input type="text" class="form-control" id="input-5" placeholder="Username" value="${user.urole?"Admin":"User"}" name="urole">
                            </div>

                            <div class="form-group">
                                <button class="btn btn-danger"><a href="${pageContext.request.contextPath}/admin/user/list">Back to List</a></button>

                                <button type="submit" class="btn btn-success">Update</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="overlay toggle-menu"></div>
    </div>
</div>

<jsp:include page = "./footer/footer.jsp" flush = "true" />