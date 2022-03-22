<%-- 
    Document   : footer
    Created on : Mar 2, 2022, 12:08:10 PM
    Author     : tuan anh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:url value = "/view/admin/assets" var="url"/>

<jsp:include page = "./right-sidebar.jsp" flush = "true" />
<script>
    function deleteAccount(uid) {
    var option = confirm('If Account exists an unpaid order will not be deleted. Do you want to delete?');
            if (option === true) {
    window.location.href = '${pageContext.request.contextPath}/admin/user/delete?uid=' + uid;
    } else {
    window.location.href = '${pageContext.request.contextPath}/admin/user/list';
    }
    }
</script>
<script>
    function deleteCategory(cid) {
    var option = confirm('If Category exists an constraints will not be deleted. Do you want to delete?');
            if (option === true) {
    window.location.href = '${pageContext.request.contextPath}/admin/category/delete?cid=' + cid;
    } else {
    window.location.href = '${pageContext.request.contextPath}/admin/category/list';
    }
    }
</script>
<script>
    function deleteProduct(pid) {
    var option = confirm('If Product exists an constraints will not be deleted. Do you want to delete?');
            if (option === true) {
    window.location.href = '${pageContext.request.contextPath}/admin/product/delete?pid=' + pid;
    } else {
    window.location.href = '${pageContext.request.contextPath}/admin/product/list';
    }
    }
</script>
<script src="${url}/js/jquery.min.js"></script>
<script src="${url}/js/popper.min.js"></script>
<script src="${url}/js/bootstrap.min.js"></script>
<script src="${url}/plugins/simplebar/js/simplebar.js"></script>
<script src="${url}/js/sidebar-menu.js"></script>
<script src="${url}/js/jquery.loading-indicator.js"></script>
<script src="${url}/js/app-script.js"></script>
<script src="${url}/plugins/Chart.js/Chart.min.js"></script>
<script src="${url}/js/index.js"></script>
<script src="${url}/plugins/summernote/dist/summernote-bs4.min.js"></script>
</body>

</html>
