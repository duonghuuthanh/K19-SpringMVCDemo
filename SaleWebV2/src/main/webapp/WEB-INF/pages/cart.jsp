<%-- 
    Document   : cart.jsp
    Created on : Apr 1, 2023, 3:33:53 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="se" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-success">GIỎ HÀNG</h1>

<c:choose>
    <c:when test="${cart == null}">
        <div class="alert alert-warning m-1">
            KHÔNG CÓ SẢN PHẨM NÀO!!!
        </div>
    </c:when>
    <c:when test="${cart != null}">
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

        <div class="alert alert-info">
            <h4>Tổng số sản phẩm: ${cartStats.totalQuantity}</h4>
            <h4>Tổng tiền: ${cartStats.totalAmount} VNĐ</h4>
        </div>

        <se:authorize access="isAuthenticated()">
            <div>
                <c:url value="/api/pay" var="pUrl" />
                <button class="btn btn-success" onclick="pay('${pUrl}')">Thanh toán</button>
            </div>
        </se:authorize>
        <se:authorize access="!isAuthenticated()">
            <p>Vui lòng <a href="<c:url value="/login" />">đăng nhập</a> để thanh toán!!!</p>
        </se:authorize>

    </c:when>
</c:choose>


<script src="<c:url value="/js/cart.js" />"></script>