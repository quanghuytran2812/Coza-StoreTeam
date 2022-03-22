<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setHeader("Expires", "0");
%>
<!-- Start header section -->
<jsp:include page = "./header/header.jsp" flush = "true" />
<div class="content-wrapper">
    <div class="container-fluid">

        <div class="row mt-3">
            <div class="col-lg-12">
                <button class="add-catalog"><a href="${pageContext.request.contextPath}/admin/user/add">Add User</a></button>
            </div>  
            <div class="col-lg-12">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">List User</h5>
                        <div class="table-responsive">
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th scope="col">ID</th>
                                        <th scope="col">Avatar</th>
                                        <th scope="col">Email</th>
                                        <th scope="col">Username</th>
                                        <th scope="col">Password</th>
                                        <th scope="col">Role</th>
                                        <th scope="col">Action</th>

                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${userList}" var="user">
                                        <tr>
                                            <td scope="row">${user.uid}</td>
                                            <c:url value="/pics/${user.uavatar}" var="imgUrl"></c:url>
                                            <td>
                                                <img src="${imgUrl}" alt="${user.uavatar}" style="width: 110px;height: 67px; object-fit: cover;border: 1px solid #fff;" />
                                            </td>
                                            <td>${user.uemail }</td>
                                            <td>${user.usname }</td>
                                            <td>${user.upassword }</td>
                                            <td>${user.urole?"Admin":"User"}</td>
                                            <td>
                                                <button class="btn btn-danger"><a href="#" onclick="deleteAccount(${user.uid})" >Delete</a></button>

                                                <button class="btn btn-success"><a href="${pageContext.request.contextPath}/admin/user/edit?uid=${user.uid}">Edit</a></button>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="overlay toggle-menu"></div>
    </div>
</div>


<jsp:include page = "./footer/footer.jsp" flush = "true" />