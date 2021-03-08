

<%@ include file="/resources/include-header.jsp" %>     
<!--=========================================================================-->


<!--========================================== Message Alert before turn off -->
<div class="container mt-3" align="center">
    <div class="alert alert-info">
        <b> <3 <3 <3 ....... Hi, ${viewUsers.fullName}! ...... <3 <3 <3 </b> &nbsp; &nbsp; &nbsp; Welcome to here!
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">x</button>
    </div>
</div>



<!--Only view with ROLE_ADMIN-->
<div class="container-fluid">
    <div class="row">
        <sec:authorize access="hasRole('ROLE_ADMIN')"> 
            <h2>&nbsp;ONLY VIEW ROLE_ADMIN</h2>
            <div class="col-md-12">
                <div class="product-view">
                    <div class="container-fluid">
                        <div class="col-md-12">
                            <div class="row">
                                <div class="col-md-4">
                                    <div class="product-price-range">
                                        <div class="dropdown">
                                            <div class="dropdown-toggle" data-toggle="dropdown"><a href="#">Manage Account</a></div>
                                            <div class="dropdown-menu dropdown-menu-right">
                                                <a class="nav-link" href="<c:url value="/account/insertData"/>" class="dropdown-item" target="_blank" >
                                                    <i class="fas fa-link"></i> Insert Data
                                                </a>
                                                <a class="nav-link" href="<c:url value="/account/list"/>" class="dropdown-item" target="_blank" >
                                                    <i class="fas fa-link"></i> List of Accounts
                                                </a>
                                                <a class="nav-link" href="<c:url value="/account/searchNewAccount"/>" class="dropdown-item" target="_blank" >
                                                    <i class="fas fa-link"></i> NEW Account
                                                </a>
                                                <a class="nav-link" href="<c:url value="/account/list"/>" class="dropdown-item" target="_blank" >
                                                    <i class="fas fa-link"></i> Search By ID
                                                </a>
                                                <a class="nav-link" href="<c:url value="/account/searchByTool"/>" class="dropdown-item" target="_blank" >
                                                    <i class="fas fa-link"></i> Search By Name
                                                </a>
                                                <a class="nav-link" href="<c:url value="/account/searchByTool"/>" class="dropdown-item" target="_blank" >
                                                    <i class="fas fa-link"></i> Search By Date
                                                </a>
                                                <a class="nav-link" href="<c:url value="/account/searchByTool"/>" class="dropdown-item" target="_blank" >
                                                    <i class="fas fa-link"></i> Search More Tool
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="product-price-range">
                                        <div class="dropdown">
                                            <div class="dropdown-toggle" data-toggle="dropdown"><a href="#">Manage Product</a></div>
                                            <div class="dropdown-menu dropdown-menu-right">
                                                <a class="nav-link" href="<c:url value="/products/productmanage"/>" class="dropdown-item" target="_blank">
                                                    <i class="fas fa-link"></i> Manage Product
                                                </a>
                                                <a class="nav-link" href="<c:url value="/products/list"/>" class="dropdown-item" target="_blank">
                                                    <i class="fas fa-link"></i> List of Products 
                                                </a>
                                                <a class="nav-link" href="<c:url value="/products/searchType?typeName=Cellphone"/>"><i class="fas fa-mobile"></i> Cell Phones</a>
                                                <a class="nav-link" href="<c:url value="/products/searchType?typeName=Laptop"/>"><i class="fas fa-laptop"></i> Laptop</a>
                                                <a class="nav-link" href="<c:url value="/products/searchType?typeName=Tablet"/>"><i class="fas fa-tablet-alt"></i> Tablet</a>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="product-price-range">
                                        <div class="dropdown">
                                            <div class="dropdown-toggle" data-toggle="dropdown"><a href="#">Manage Order</a></div>
                                            <div class="dropdown-menu dropdown-menu-right">
                                                <a class="nav-link" href="<c:url value="/orders/list"/>" class="dropdown-item" target="_blank">
                                                    <i class="fas fa-link"></i> All of Orders
                                                </a>
                                                <a class="nav-link" href="<c:url value="/orders/searchByTool"/>" class="dropdown-item" target="_blank">
                                                    <i class="fas fa-link"></i> Search Orders
                                                </a>
                                                <a class="nav-link" href="<c:url value="/orders/searchOrderStatus?ordersStatus=pending"/>" class="dropdown-item" target="_blank">
                                                    <i class="fas fa-link"></i> Pending Orders
                                                </a>
                                                <a class="nav-link" href="<c:url value="/orders/searchOrderStatus?ordersStatus=shipping"/>" class="dropdown-item" target="_blank">
                                                    <i class="fas fa-link"></i> Shipping Orders
                                                </a>
                                                <a class="nav-link" href="<c:url value="/orders/searchOrderStatus?ordersStatus=received"/>" class="dropdown-item" target="_blank">
                                                    <i class="fas fa-link"></i> Received Orders
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>


                        <!--=============================--> 
                        <div class="col-md-12">
                            <div class="row">
                                <h1>&nbsp;</h1>
                            </div>
                        </div>
                        <!--=============================-->



                        <div class="col-md-12">
                            <div class="row">
                                <div class="col-md-4">
                                    <div class="product-price-range">
                                        <div class="dropdown">
                                            <div class="dropdown-toggle" data-toggle="dropdown"><a href="#">Manage Shipping</a></div>
                                            <div class="dropdown-menu dropdown-menu-right">
                                                <a class="nav-link" href="<c:url value="/shipping/list"/>" class="dropdown-item" target="_blank">
                                                    <i class="fas fa-link"></i> List of Shipping
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="product-price-range">
                                        <div class="dropdown">
                                            <div class="dropdown-toggle" data-toggle="dropdown"><a href="#">Manage Promotion</a></div>
                                            <div class="dropdown-menu dropdown-menu-right">
                                                <a class="nav-link" href="<c:url value="/promotion/list"/>" class="dropdown-item" target="_blank">
                                                    <i class="fas fa-link"></i> List Promotion
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="product-price-range">
                                        <div class="dropdown">
                                            <div class="dropdown-toggle" data-toggle="dropdown"><a href="#">Report</a></div>
                                            <div class="dropdown-menu dropdown-menu-right">
                                                <a class="nav-link" href="<c:url value="/orders/report"/>" class="dropdown-item" target="_blank">
                                                    <i class="fas fa-link"></i> Credit Report
                                                </a>
                                                <a class="nav-link" href="<c:url value="/orders/report"/>" class="dropdown-item" target="_blank">
                                                    <i class="fas fa-link"></i> Summary Report
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>



                        <!--=============================--> 
                        <div class="col-md-12">
                            <div class="row">
                                <h1>&nbsp;</h1>
                            </div>
                        </div>
                        <!--=============================-->
                        <div class="col-md-4">
                            <div class="product-price-range">
                                <div class="dropdown">
                                    <div class="dropdown-toggle" data-toggle="dropdown"><a href="#">Contact</a></div>
                                    <div class="dropdown-menu dropdown-menu-right">
                                        <a class="nav-link" href="<c:url value="/contact"/>" class="dropdown-item" target="_blank">
                                            <i class="fas fa-link"></i> Contact
                                        </a>
                                        <a class="nav-link" href="<c:url value="/contact"/>" class="dropdown-item" target="_blank">
                                            <i class="fas fa-link"></i> Address
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>



                        <!--=============================--> 
                        <div class="col-md-12">
                            <div class="row">
                                <p>&nbsp;</p>
                            </div>
                        </div>
                        <!--=============================-->



                    </div>
                </div>
            </div>
        </sec:authorize>
    </div>
</div>











<!-- Product Detail Start -->
<div class="product-detail">
    <div class="container-fluid">

        <div class="row product-detail-bottom">
            <div class="col-lg-12">
                <ul class="nav nav-pills nav-justified">
                    <li class="nav-item">
                        <a class="nav-link active" data-toggle="pill" href="#description"> &nbsp;</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" data-toggle="pill" href="#reviews"> &nbsp;</a>
                    </li>
                </ul>
            </div>
        </div>


        <div class="row">
            <div class="col-lg-8">
                <div class="product-detail-top"> 
                    <table class="table table-borderless">
                        <thead>
                            <tr>
                                <th colspan="2"><h2><i class="fa fa-user-circle" aria-hidden="true"></i> MY-ACCOUNT</h2></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>ID:</td>
                                <td>${viewUsers.id}</td>
                            </tr>
                            <tr>
                                <td>ROLE:</td>
                                <td>${roleName}</td>
                            </tr>
                            <tr>
                                <td>Usename:</td>
                                <td>${viewUsers.username}</td>
                            </tr>
                            <tr>
                                <td>Password:</td>
                                <td>${viewUsers.password}</td>
                            </tr>
                            <tr>
                                <td>FullName:</td>
                                <td>${viewUsers.fullName}</td>
                            </tr>
                            <tr>
                                <td>Phone:</td>
                                <td>${viewUsers.phone}</td>
                            </tr>
                            <tr>
                                <td>Address:</td>
                                <td>${viewUsers.address}</td>
                            </tr>
                            <tr>
                                <td>Email:</td>
                                <td>${viewUsers.email}</td>
                            </tr>
                            <tr>
                                <td>Enable:</td>
                                <td>${viewUsers.enable}</td>
                            </tr>
                            <tr>
                                <td>CreateDate:</td>
                                <td>${viewUsers.createDate}</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>



            <!-- Side Bar Start -->
            <div class="col-lg-4 sidebar">
                <div class="sidebar-widget category-item">

                    <nav class="navbar">
                        <h2 class="title">Update account</h2>
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a href="<c:url value="/account/edit?id=${viewUsers.id}"/>">
                                    <i class="fa fa-pencil-square-o" aria-hidden="true"> Change Contact</i>
                                </a> 
                            </li>
                            <li class="nav-item">
                                <a href="<c:url value="/account/edit?id=${viewUsers.id}"/>">
                                    <i class="fa fa-pencil-square-o" aria-hidden="true"> Change Password</i>
                                </a> 
                            </li>
                            <li class="nav-item">
                                <a href="<c:url value="/account/edit?id=${viewUsers.id}"/>">
                                    <i class="fa fa-pencil-square-o" aria-hidden="true"> Change Phone</i>
                                </a> 
                            </li>
                        </ul>
                    </nav>          
                    <br/>
                    <nav class="navbar">
                        <h2 class="title">
                            <a href="<c:url value="/register"/>">
                                <i class="fa fa-registered" aria-hidden="true"> Register Account</i>
                            </a>
                        </h2>
                    </nav>
                    <nav class="navbar">
                        <h2 class="title">
                            <i class="fas fa-link"></i> <a href="<c:url value="/orders/myOrder?username=${viewUsers.username}"/>" class="" aria-hidden="true"><u>My order</u></a>
                        </h2>


                    </nav>
                </div>
            </div>
            <!-- Side Bar End -->
        </div>
    </div>
</div>
<!-- Product Detail End -->









<!--=========================================================================-->
<%@ include file="/resources/include-footer.jsp" %> 