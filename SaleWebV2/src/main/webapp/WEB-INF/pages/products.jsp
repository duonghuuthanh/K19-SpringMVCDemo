<%-- 
    Document   : products
    Created on : Mar 18, 2023, 4:33:15 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 class="text-center text-success">QUẢN LÝ SẢN PHẨM</h1>

<c:url value="/admin/products" var="action" />
<c:if test="${errMsg != null}">
    ${errMsg}
</c:if>
<form:form method="post" action="${action}" enctype="multipart/form-data" modelAttribute="product">
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" id="name" 
                    path="name" placeholder="Tên sản phẩm" name="name" />
        <label for="name">Tên sản phẩm</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="number" step="100" class="form-control" id="price" 
                    path="price" placeholder="Gía sản phẩm" name="price" />
        <label for="price">Gía sản phẩm</label>
    </div>
    <div class="form-floating">
        <form:select class="form-select" path="categoryId" id="categoryId" name="categoryId">
            <c:forEach items="${categories}" var="c">
                <option value="${c.id}">${c.name}</option>
            </c:forEach>
        </form:select>
        <label for="categoryId" class="form-label">Danh mục sản phẩm</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="file" class="form-control" id="file" 
                    path="file" name="file" />
        <label for="file">Ảnh sản phẩm</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <input type="submit"  value="Thêm sản phẩm" class="btn btn-danger" />
    </div>
</form:form>