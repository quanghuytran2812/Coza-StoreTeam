
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%> 
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
        <!--End Row--> 


        <div class="row"> 
<!--            <div class="col-lg-12"> 
                <button class="add-catalog"><a href="${pageContext.request.contextPath}/admin/admin/add">Add Admin</a></button> 
            </div> -->
            <div class="col-lg-12"> 
                <div class="card"> 
                    <div class="card-body"> 
                        <h5 class="card-title">List Admin</h5> 
                        <div class="table-responsive">              
                            <table class="table table-striped"> 
                                <thead> 
                                    <tr> 
                                        <th scope="col">ID</th> 
                                        <th scope="col">Username</th> 
                                        <th scope="col">Password</th> 
                                        <th scope="col">Role</th>
                                        <th scope="col">Action</th>                        
                                    </tr> 
                                </thead> 
                                <tbody> 
                                    <c:forEach items="${adminList}" var="admin"> 
                                        <tr> 
                                            <td scope="row">${admin.uid}</td> 
                                            <td>${admin.usname}</td> 
                                            <td>${admin.upassword}</td> 
                                            <td>${admin.urole?"Admin":"User"}</td> 
                                            <td> 
                                                <button class="btn btn-success"><a href="${pageContext.request.contextPath}/admin/admin/edit?aid=${admin.uid}">Edit</a></button>
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
    </div> 
</div> 

<jsp:include page = "./footer/footer.jsp" flush = "true" />