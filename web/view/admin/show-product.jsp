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
                <button class="add-catalog"><a href="${pageContext.request.contextPath}/admin/product/add">Add Product</a></button>
            </div>
            <div class="col-lg-12">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">List Product</h5>
                        <div class="table-responsive">
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th scope="col">ID</th>
                                        <th scope="col">Name</th>
                                        <th scope="col">Img</th>
                                        <th scope="col">Price</th>
                                        <th scope="col">Discount</th>
                                        <th scope="col">New or Not</th>
                                        <th scope="col">Category</th>
                                        <th scope="col">Description</th>
                                        <th scope="col">Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${proList}" var="product">
                                        <tr>
                                            <th scope="row">${product.pid }</th>
                                            <td>${product.pname }</td>
                                            <c:url value="/pics/${product.pimg}" var="imgUrl"></c:url>
                                            <td><img style="    width: 110px;height: 67px; object-fit: cover;border: 1px solid #fff;" src="${imgUrl}" alt="${product.pimg}"></td>
                                            <td>$${product.pprice }</td>
                                            <td>${product.pdiscount }%</td>
                                            <td>

                                                <c:choose>
                                                    <c:when test="${product.pisNew == true}"> 
                                                        <c:out value="New"/>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <c:out value="Not New"/>
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>
                                            <td>${product.pcate.cname }</td>
                                            <td>${product.pdes }</td>
                                            <td>
                                                <button class="btn btn-danger"><a onclick="deleteProduct(${product.pid})" href="#">Delete</a></button>

                                                <button class="btn btn-success"><a href="${pageContext.request.contextPath}/admin/product/edit?pid=${product.pid}">Edit</a></button>
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