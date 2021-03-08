
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="f" uri="http://java.sun.com/jstl/fmt_rt"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopoo - Mobile, Laptop & Tablet </title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="eCommerce HTML Template Free Download" name="keywords">
        <meta content="eCommerce HTML Template Free Download" name="description">

        <!-- Favicon --> 
        <link href="<c:url value='/resources/favicon/favicon.ico'/>" rel="icon">
        <!-- Font Awesome -->
        <link href="<c:url value="/resources/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet" >
        <!-- Google Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400|Source+Code+Pro:700,900&display=swap" rel="stylesheet">

        <!-- CSS Libraries -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

        <link href="<c:url value='/resources/lib/slick/slick.css'/>" rel="stylesheet">
        <link href="<c:url value='/resources/lib/slick/slick-theme.css'/>" rel="stylesheet">

        <!-- Template Stylesheet -->
        <link href="<c:url value='/resources/css/style.css'/>" rel="stylesheet" type="text/css">
        <link href="<c:url value='/resources/css/css-header.css'/>" rel="stylesheet" type="text/css">

    </head>

    <body>
        <!-- Nav Bar Start -->
        <div class="nav" style="min-height:50px;">
            <div class="container-fluid">
                <nav class="navbar navbar-expand-md bg-dark navbar-dark">
                    <a href="#" class="navbar-brand">MENU</a>
                    <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                        <span class="navbar-toggler-icon"></span>
                    </button>

                    <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                        <div class="navbar-nav mr-auto">
                            <a href="<c:url value="/home"/>" class="nav-item nav-link">Home</a>
                            <a href="<c:url value="/contact"/>" class="nav-item nav-link">About</a>
                            <a href="<c:url value="/contact"/>" class="nav-item nav-link">Contact</a>
                            <div class="nav-item dropdown">
                                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Products</a>
                                <div class="dropdown-menu">
                                    <a href="<c:url value="/products/list"/>" class="dropdown-item"><i class="fas fa-shopping-bag"></i> All products</a>
                                    <a href="<c:url value="/products/searchType?typeName=Cellphone"/>" class="dropdown-item"><i class="fas fa-mobile"></i> Cell Phone</a>
                                    <a href="<c:url value="/products/searchType?typeName=Laptop"/>" class="dropdown-item"><i class="fas fa-laptop"></i> Laptop</a>
                                    <a href="<c:url value="/products/searchType?typeName=Tablet"/>" class="dropdown-item"><i class="fas fa-tablet-alt"></i> Tablet</a>
                                </div>
                            </div>                            
                        </div>



                        <div class="navbar-nav ml-auto">
                            <div class="nav-item dropdown">

                                <c:if test="${viewUsers == null}">
                                    <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown"> Account</a>
                                </c:if>
                                <c:if test="${viewUsers != null}">
                                    <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">${viewUsers.fullName}</a>
                                </c:if>

                                <div class="dropdown-menu">
                                    <div class="dropdown-item">
                                        <sec:authorize access="hasRole('ROLE_ADMIN')">
                                            <i class="fa fa-user-circle" aria-hidden="true"> ROLE_ADMIN</i>
                                        </sec:authorize>      
                                    </div>


                                    <!--SỬ dụng cái này thay việc dùng c:if test roleName=Role_admin-->
                                    <sec:authorize access="hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')">
                                        <a href="<c:url value="/account/myAccount"/>" class="dropdown-item">My Account</a>
                                    </sec:authorize>

                                    <a href="<c:url value="/register"/>" class="dropdown-item">Register</a>

                                    <a href="<c:url value="/login"/>" class="dropdown-item">Login</a>

                                    <c:if test="${viewUsers != null}">
                                        <a href="<c:url value="/logout"/>" class="dropdown-item">Logout</a>
                                    </c:if>
                                </div>

                            </div>
                        </div>
                    </div>
                </nav>
            </div>
        </div>
        <!-- Nav Bar End -->      





        <!-- Bottom Bar Start -->
        <div class="bottom-bar">
            <div class="container-fluid">
                <div class="row align-items-center">
                    <div class="col-md-3">
                        <div class="logo">
                            <a href="<c:url value="/homepage"/>">
                                <img src="<c:url value="/resources/img/logo.png"/>" alt="Logo">
                            </a>
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="search">
                            <form action="/e_Commerce_Shopoo/products/searchKeyWord" method="get">
                                <input type="text" name="keywords" value="${keywords}" required/>
                                <button><i class="fa fa-search"></i></button>
                            </form>
                        </div>
                    </div>


                    <c:set var="amount" value="0"/>
                    <c:set var="count" value="0"/>
                    <c:forEach items="${lineItems}" var="item">
                        <c:set var="amount" value="${amount + item.products.unitPrice * item.quantity}"/>
                        <c:set var="count" value="${count + item.quantity}"/>
                    </c:forEach>
                    <div class="col-md-3">
                        <div class="user" data-id="${l.id}">
                            <a href="<c:url value="/cart"/>" class="btn cart">
                                <i class="fa fa-shopping-cart"></i>
                                <span id="cart-count" >${count}</span>
                                <br/>
                                <c:if test="${count >0}">
                                    <span id="cart-amount">
                                        <b>$</b>
                                        <f:formatNumber value="${amount}" pattern="#,###"/>
                                    </span>
                                </c:if>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Bottom Bar End -->     