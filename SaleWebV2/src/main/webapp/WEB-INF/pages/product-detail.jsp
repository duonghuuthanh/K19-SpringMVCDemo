<%-- 
    Document   : product-detail
    Created on : Mar 18, 2023, 3:31:50 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-danger">CHI TIẾT SẢN PHẨM</h1>

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
