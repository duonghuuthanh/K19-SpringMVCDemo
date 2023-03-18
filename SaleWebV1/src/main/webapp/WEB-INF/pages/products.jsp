<%-- 
    Document   : products
    Created on : Mar 18, 2023, 1:45:57 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-info text-center">QUẢN TRỊ SẢN PHẨM</h1>

<c:if test="${errMsg != null}">
    <div class="alert alert-danger">${errMsg}</div>
</c:if>
<c:url value="/admin/products" var="action" />
<form:form method="POST" action="${action}"
           modelAttribute="product" enctype="multipart/form-data">
    
    <form:errors path="*" element="div" cssClass="alert alert-danger" />
    
    <div class="form-floating mb-3 mt-3">
        <form:input class="form-control" id="name" placeholder="Tên sản phẩm" path="name" name="name" />
        <label for="name">Tên sản phẩm</label>
    </div>
    <div class="form-floating">
        <textarea class="form-control" id="description" path="description" name="description" placeholder="Mô tả"></textarea>
        <label for="description">Mô tả</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="number" class="form-control" id="price" placeholder="Giá sản phẩm" path="price" name="price" />
        <label for="price">Giá sản phẩm</label>
    </div>
    <div class="form-floating">
        <form:select class="form-select" id="categoryId" name="categoryId" path="categoryId">
            <c:forEach items="${categories}" var="c">
                <option value="${c.id}">${c.name}</option>
            </c:forEach>
        </form:select>
        <label for="categoryId" class="form-label">Danh mục sản phẩm:</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="file" class="form-control" id="file" path="file" name="file" />
        <label for="file">Ảnh sản phẩm</label>
    </div>
    <div class="form-floating mt-2">
        <input type="submit" value="Thêm sản phẩm" class="btn btn-danger" />
    </div>
</form:form>
