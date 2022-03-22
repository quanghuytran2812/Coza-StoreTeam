<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <!-- Start header section -->
  <jsp:include page = "./header/header.jsp" flush = "true" />
    <div class="content-wrapper">
      <div class="container-fluid">

        <div class="row mt-3">
          <div class="col-lg-8">
            <div class="card">
              <div class="card-body">
                <div class="card-title">Edit Category</div>
                <hr>
          	
	                <form action="${pageContext.request.contextPath}/admin/category/edit" method="post">
	                  <div class="form-group">
	                    <label for="input-1">ID</label>
	                    <input type="text" class="form-control" readonly id="input-1" placeholder="ID" name="cid" value="${category.cid}">
	                  </div>
	                  <div class="form-group">
	                    <label for="input-1">Category Name</label>
	                    <input type="text" class="form-control" id="input-1" placeholder="Tên chuyên mục" name="cname" value="${category.cname }">
	                  </div>
		              <div class="form-group">
		                  <label for="input-2">Category Session</label>
                                  <input type="text" class="form-control" id="input-1" placeholder="Tên session chuyên mục" name="csession" value="${category.csession }">
		               </div>
	                   <div class="form-footer">
	                      <button class="btn btn-danger"><a href="${pageContext.request.contextPath}/admin/category/list">Back to List cate</a></button>
                         
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