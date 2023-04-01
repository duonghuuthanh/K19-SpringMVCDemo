<%-- 
    Document   : header.jsp
    Created on : Mar 11, 2023, 5:04:04 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<header>
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">BÁN HÀNG TRỰC TUYẾN</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="collapsibleNavbar">
                <ul class="navbar-nav me-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/" />">Trang chủ</a>
                    </li>

                    <c:forEach items="${categories}" var="c">
                        <c:url value="/" var="url">
                            <c:param name="categoryId" value="${c.id}" />
                        </c:url>
                        <li class="nav-item">
                            <a class="nav-link" href="${url}">${c.name}</a>
                        </li>
                    </c:forEach>
                        <li class="nav-item">
                            <a class="nav-link text-danger" href="<c:url value="/cart" />">&#128722; Giỏ hàng <span class="badge bg-danger cart-counter">${cartStats.totalQuantity}</span></a>
                        </li>
                </ul>
                 <c:url value="/" var="action" />
                <form class="d-flex" action="${action}">
                    <input class="form-control me-2" type="text" name="kw" placeholder="Nhập tên...">
                    <button class="btn btn-primary" type="submit">Tìm</button>
                </form>
            </div>
        </div>
    </nav>
</header>
