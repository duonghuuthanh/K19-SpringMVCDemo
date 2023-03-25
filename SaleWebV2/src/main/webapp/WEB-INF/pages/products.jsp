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
                    path="price" placeholder="Giá sản phẩm" name="price" />
        <label for="price">Giá sản phẩm</label>
    </div>
    <div class="form-floating">
        <form:select class="form-select" path="categoryId" id="categoryId" name="categoryId">
            <c:forEach items="${categories}" var="c">
                <c:choose>
                    <c:when test="${product.categoryId.id == c.id}">
                        <option value="${c.id}" selected>${c.name}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${c.id}">${c.name}</option>
                    </c:otherwise>
                </c:choose>
                
            </c:forEach>
        </form:select>
        <label for="categoryId" class="form-label">Danh mục sản phẩm</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="file" class="form-control" id="file" 
                    path="file" name="file" />
        <label for="file">Ảnh sản phẩm</label>
    </div>
    <c:if test="${product.image != null}">
        <div class="form-floating mb-3 mt-3">
            <img src="${product.image}" width="120" /> 
        </div>
    </c:if>
    <div class="form-floating mb-3 mt-3">
        <c:choose>
            <c:when test="${product.id > 0}">
                <form:hidden path="id" />
                <form:hidden path="image" />
                <input type="submit"  value="Cập nhật sản phẩm" class="btn btn-success" />
            </c:when>
            <c:otherwise>
                <input type="submit"  value="Thêm sản phẩm" class="btn btn-success" />
            </c:otherwise>
        </c:choose>
        
    </div>
</form:form>

<table class="table">
    <tr>
        <th></th>
        <th>Id</th>
        <th>Tên sản phẩm</th>
        <th>Giá</th>
        <th></th>
    </tr>
    <c:forEach items="${products}" var="p">
    <tr id="product${p.id}">
        <td><img src="${p.image}" width="200" /></td>
        <td>${p.id}</td>
        <td>${p.name}</td>
        <td>${p.price}</td>
        <td>
            <c:url value="/api/products/${p.id}" var="endpoint" />
            <input type="button" onclick="deleteProduct('${endpoint}', ${p.id})" value="Xóa" class="btn btn-danger" />
            <a href="<c:url value="/admin/products/${p.id}" />" class="btn btn-info">Cập nhật</a>
        </td>
    </tr>
    </c:forEach>
</table>

<script src="<c:url value="/js/product.js" />"></script>