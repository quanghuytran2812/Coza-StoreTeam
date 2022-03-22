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
                        <div class="card-title">Edit Proudct</div>
                        <hr>
                        <form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/admin/product/edit">

                            <div class="form-group">
                                <label for="input-1">ID</label>
                                <input type="text" class="form-control" readonly="readonly" id="input-1" placeholder="Mã sản phẩm" name="pid" value="${product.pid}">
                            </div>

                            <div class="form-group">
                                <label for="input-1">Name</label>
                                <input type="text" class="form-control" id="input-1" placeholder="Tên sản phẩm" name="pname" value="${product.pname}">
                            </div>
                            
                            <div class="form-group">
                                <label for="input-1">Product Img</label>
                                <input type="file" class="form-control" id="input-2" placeholder="Product Img" name="pimg">
                            </div>

                            <div class="form-group">
                                <label for="input-1">Price</label>
                                <input type="text" class="form-control" id="input-1" placeholder="Giá" name="pprice" value="${product.pprice}">
                            </div>

                            <div class="form-group">
                                <label for="input-2">Discount</label>
                                <div class="input-group">
                                    <input type="text" class="form-control" placeholder="Giảm ... %" name="pdiscount" value="${product.pdiscount}">
                                    <div class="input-group-append">
                                        <button class="btn btn-light" type="button">%</button>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="input-2">New or Not?</label>
                                <div>
                                    <select class="form-control valid" id="input-6" name="pisNew" required aria-invalid="false">
                                        <option value="true" ${product.pisNew?"selected":""} >New</option>
                                        <option value="false" ${product.pisNew?"":"selected"} >Not New</option>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="input-2">Category</label>
                                <div>
                                    <select class="form-control valid" id="input-6" name="pcate" aria-invalid="false">
                                        <c:forEach items="${categories}" var="cate">
                                            <option value="${cate.cid }" ${cate.cid == product.cid?"selected":""} >${cate.cname }</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>


                            <div class="form-group">
                                <label for="input-2" class="col-form-label">Description</label>
                                <div>
                                    <textarea class="form-control" rows="4" id="input-17" name="pdes">${product.pdes}</textarea>
                                </div>
                            </div>
                                
                            <div class="form-footer">
                                <button class="btn btn-danger"><a href="${pageContext.request.contextPath}/admin/product/list">Back to list</a></button>

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