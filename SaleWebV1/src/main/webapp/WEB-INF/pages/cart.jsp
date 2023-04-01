<%-- 
    Document   : cart
    Created on : Apr 1, 2023, 1:14:34 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-success">GIỎ HÀNG</h1>

<c:if test="${carts != null}">
    <table class="table">
        <tr>
            <th>Mã sản phẩm</th>
            <th>Tên sản phẩm</th>
            <th>Đơn giá</th>
            <th>Số lượng</th>
            <th></th>
        </tr>
        <c:forEach items="${carts.values()}" var="c">
            <c:url value="/api/cart/${c.id}" var="endpoint" />
            <tr>
                <td>${c.id}</td>
                <td>${c.name}</td>
                <td>${c.price}</td>
                <td>
                    <input type="number" value="${c.quantity}"
                           onblur="updateItem('${endpoint}', this)"
                           class="form-control" />
                </td>
                <td>
                    
                    <button class="btn btn-danger" onclick="deleteItem('${endpoint}', )">Xóa</button>
                </td>
            </tr>
        </c:forEach>
    </table> 

    <div>
        <input type="button" value="Thanh toán" class="btn btn-success" />
    </div>
</c:if>

<script src="<c:url value="/js/cart.js" />"></script>
<script>
    window.onload = function() {
        
    }
</script>
