<%-- 
    Document   : product-detail
    Created on : Mar 18, 2023, 3:31:50 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-danger">CHI TIẾT SẢN PHẨM</h1>

<c:url value="/products/${product.id}/comments" var="url" />
<div class="row">
    <div class="col-md-5 col-xs-12">
        <img src="${product.image}" class="img-fluid" />
    </div>
    <div class="col-md-7 col-xs-12">
        <h1>${product.name}</h1>
        <p>${product.description}</p>
        <h3>${product.price} VNĐ</h3>
    </div>
</div>
<sec:authorize access="isAuthenticated()">
    <div>
        <textarea class="form-control" rows="5" id="comment-content" name="content"></textarea>
        <input type="button" value="Them binh luan" onclick="addComment('${url}')" class="btn btn-danger m-1" />
    </div>
</sec:authorize>
    <div class="spinner-grow text-primary spinner" style="display:none"></div>
<div id="comments">

</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment-with-locales.min.js"></script>
<script src="<c:url value="/js/comment.js" />"></script>
<script>
            window.onload = function () {
                loadComments('${url}');
            };
</script>
