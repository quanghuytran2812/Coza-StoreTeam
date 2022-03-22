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
                        <div class="card-title">Add Product</div>
                        <hr>
                        <form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/admin/product/add">


                            <div class="form-group">
                                <label for="input-1">Name Product</label>
                                <input type="text" class="form-control" id="input-1" placeholder="Tên sản phẩm" name="pname">
                            </div>

                            <div class="form-group">
                                <label for="input-1">Product Img</label>
                                <input type="file" class="form-control" id="input-2" placeholder="Product Img" name="pimg">
                            </div>

                            <div class="form-group">
                                <label for="input-2">Category</label>
                                <div>
                                    <select class="form-control valid" id="input-6" name="cid" aria-invalid="false">
                                        <c:forEach items="${categories}" var="cate">
                                            <option value="${cate.cid }">${cate.cname }</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="input-1">Price</label>
                                <input type="text" class="form-control" id="input-1" placeholder="Giá" name="pprice">
                            </div>

                            <div class="form-group">
                                <label for="input-2">Discount</label>
                                <div class="input-group">
                                    <input type="text" class="form-control" placeholder="Giảm ... %" name="pdiscount">
                                    <div class="input-group-append">
                                        <button class="btn btn-light" type="button">%</button>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="input-2">New or Not?</label>
                                <div>
                                    <select class="form-control valid" id="input-6" name="pisNew" required aria-invalid="false">
                                        <option value="true">New</option>
                                        <option value="false">Not New</option>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="input-2" class="col-form-label">Description</label>
                                <div>
                                    <textarea class="form-control" rows="4" id="input-17" name="pdes"></textarea>
                                </div>
                            </div>

                            <div class="form-footer">
                                <button class="btn btn-danger"><i class="fa fa-times"></i><a href="${pageContext.request.contextPath}/admin/product/list">Back to list</a></button>
                                <button type="submit" class="btn btn-success"><i class="fa fa-check-square-o"></i> Add</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="overlay toggle-menu"></div>
    </div>
</div>
<!--<script>
                var date = new Date();
                
                var day = date.getDate();
                var month = date.getMonth() + 1;
                var year = date.getFullYear();
                
                if (month < 10) month = "0" + month;
                if (day < 10) day = "0" + day;
                
                var today = year + "-" + month + "-" + day;
                
                
                document.getElementById('the-date').value = today;
</script>-->
<jsp:include page = "./footer/footer.jsp" flush = "true" />