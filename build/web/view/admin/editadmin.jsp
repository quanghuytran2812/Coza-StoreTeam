<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <!-- Start header section -->
  <jsp:include page = "./header/header.jsp" flush = "true" />
    <div class="content-wrapper">
      <div class="container-fluid">

        <div class="row mt-3">
          <div class="col-lg-8">
            <div class="card">
              <div class="card-body">
                <div class="card-title">Task: Edit Admin</div>
                <hr>
          	
	         <form action="${pageContext.request.contextPath}/admin/admin/edit" enctype="multipart/form-data" method="post"> 
	         <div class="form-group">
	                    <label for="input-1">ID</label>
	                    <input type="text" class="form-control" readonly id="input-1" placeholder="Admin ID" name="uid" value="${admin.uid}">
                            <input type="text" class="form-control" hidden readonly id="input-1" placeholder="Admin ID" name="uavatar" value="${admin.uavatar}">
                            <input type="text" class="form-control" hidden readonly id="input-1" placeholder="Admin ID" name="uemail" value="${admin.uemail}">
	                  </div>
	                  <div class="form-group">
	                    <label for="input-1">Username</label>
	                    <input type="text" class="form-control" id="input-1" placeholder="Username" name="usname" value="${admin.usname}">
	                  </div>
	                  <div class="form-group">
	                    <label for="input-1">Password</label>
	                    <input type="password" class="form-control" id="myinput" placeholder="Mật khẩu" name="upassword" value="${admin.upassword}">
        <input type="checkbox" onclick="myFunction1()">Show password
                    <script>function myFunction1() {
                    	  var x = document.getElementById("myinput");
                    	  if (x.type === "password") {
                    	    x.type = "text";
                    	  } else {
                    	    x.type = "password";
                    	  }
                    	}</script> 
	                  </div>
	                  <div class="form-group">
	                    <label for="input-1">Role</label>
	                    <input type="text" class="form-control" id="input-1" placeholder="Role Admin" name="urole" value="${admin.urole?"Admin":"User"}">
	                  </div>	                  		              
	                 <div class="form-footer">
	                 <button type="reset" class="btn btn-danger"><i class="fa fa-times"></i> Reset </button>
	                    <button type="submit" class="btn btn-success"><i class="fa fa-check-square-o"></i> Edit </button>
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