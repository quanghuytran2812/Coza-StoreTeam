<%@page contentType="text/html" pageEncoding="UTF-8"%>
  <!-- Start header section -->
  <jsp:include page = "./header/header.jsp" flush = "true" />
    <div class="content-wrapper">
      <div class="container-fluid">

        <div class="row mt-3">
          <div class="col-lg-8">
            <div class="card">
              <div class="card-body">
                <div class="card-title">Add Category</div>
                <hr>
                <form action="${pageContext.request.contextPath}/admin/category/add" method="post">
                
                  <div class="form-group">
                    <label for="input-1">Category Name</label>
                    <input type="text" class="form-control" id="input-1" placeholder="Tên chuyên mục" name="name">
                  </div>
	               <div class="form-group">
	                  <label for="input-2">Category Session</label>
	                  <div>
	                    <input type="text" class="form-control" id="input-1" placeholder="Tên session chuyên mục" name="session">
	                  </div>
	                </div>
                 <div class="form-footer">
                    <button type="reset" class="btn btn-danger"><i class="fa fa-times"></i> Cancel</button>
                    <button type="submit" class="btn btn-success"><i class="fa fa-check-square-o"></i> Add Category</button>
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