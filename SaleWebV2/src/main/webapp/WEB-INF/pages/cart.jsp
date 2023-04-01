<%-- 
    Document   : cart.jsp
    Created on : Apr 1, 2023, 3:33:53 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-success">GIỎ HÀNG</h1>

<table class="table">
    <tr>
        <th>Mã sản phẩm</th>
        <th>Tên sản phẩm</th>
        <th>Đơn giá</th>
        <th>Số lượng</th>
        <th></th>
    </tr>
    <c:forEach items="${cart.values()}" var="c">
        <c:url value="/api/cart/${c.id}" var="url" /> 
        <tr id="cart${c.id}">
            <td>${c.id}</td>
            <td>${c.name}</td>
            <td>${c.price}</td>
            <td>
                <input type="number" onblur="updateCart('${url}', this)"
                       value="${c.quantity}" class="form-control" />
            </td>
            <td>
                <button class="btn btn-danger" onclick="deleteCart('${url}', ${c.id})">Xóa</button>
            </td>
        </tr>
    </c:forEach>
</table>

<div>
    <button class="btn btn-success">Thanh toán</button>
</div>

<script src="<c:url value="/js/cart.js" />"></script>