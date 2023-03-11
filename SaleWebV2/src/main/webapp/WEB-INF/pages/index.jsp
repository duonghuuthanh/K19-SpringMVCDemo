<%-- 
    Document   : index
    Created on : Mar 4, 2023, 3:34:47 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<section class="container">
    <div class="row">
        <c:forEach items="${products}" var="p">
            <div class="col-md-3 col-xs-12" style="padding:1rem;">
                <div class="card">
                    <img class="card-img-top" src="${p.image}" alt="Card image">
                    <div class="card-body">
                        <h4 class="card-title">${p.name}</h4>
                        <p class="card-text">${p.price} VND</p>
                        <a href="#" class="btn btn-primary">Xem chi tiet</a>
                        <a href="#" class="btn btn-danger">Dat hang</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</section>

