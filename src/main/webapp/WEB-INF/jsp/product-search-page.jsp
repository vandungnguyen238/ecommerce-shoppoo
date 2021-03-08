

<%@ include file="/resources/include-header.jsp" %>     
<!--=========================================================================-->



<!-- Breadcrumb Start -->
<div class="breadcrumb-wrap">
    <div class="container-fluid">
        <ul class="breadcrumb">
            <li class="breadcrumb-item"><a href="#">Home</a></li>
            <li class="breadcrumb-item"><a href="#">Products</a></li>
            <li class="breadcrumb-item active">Product List</li>
            <li class="breadcrumb-item active">${tag}</li>

        </ul>
    </div>
</div>
<!-- Breadcrumb End -->

<!-- Product List Start -->
<div class="product-view">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="product-view-top">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="product-search">
                                <form action="searchKeyWord" method="get">
                                    <input type="text" placeholder="Search By Name" name="keywords" value="${keywords}" required/>
                                    <button><i class="fa fa-search"></i></button>
                                </form>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="product-short">
                                <div class="dropdown">
                                    <div class="dropdown-toggle" data-toggle="dropdown">Manufactures</div>
                                    <div class="dropdown-menu dropdown-menu-right">
                                        <c:forEach  items="${manufacturesList}" var="l">
                                            <a href="<c:url value="/products/searchManufactures?manufactureName=${l.manufactureName}"/>" class="dropdown-item">${l.manufactureName}</a>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="product-price-range">
                                <div class="dropdown">
                                    <div class="dropdown-toggle" data-toggle="dropdown">Product price range</div>
                                    <div class="dropdown-menu dropdown-menu-right">
                                        <a href="<c:url value="/products/searchPrice?start=0&end=500"/>" class="dropdown-item">$0 to $500</a>
                                        <a href="<c:url value="/products/searchPrice?start=550&end=1000"/>" class="dropdown-item">$500 to $1000</a>
                                        <a href="<c:url value="/products/searchPrice?start=1000&end=1500"/>" class="dropdown-item">$1000 to $1500</a>
                                        <a href="<c:url value="/products/searchPrice?start=1500&end=2500"/>" class="dropdown-item">$1500 to $2500</a>
                                        <a href="<c:url value="/products/searchPrice?start=2500&end=3000"/>" class="dropdown-item">$2500 to $3000</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
                                    
                                    
            <p class="text-danger">${message}</p>
            
            
            <div class="row col-md-12">
                <c:forEach items="${list}" var="l">
                    <div class="col-md-3">
                        <div class="product-item">
                            <div class="product-title">
                                <a href="#">${l.productName}</a>
                                <div class="ratting">
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                </div>
                            </div>
                            <div class="product-image">
                                <a href="#">
                                    <img src="<c:url value="${l.firstLink}"/>" alt="Product Image">
                                </a>
                                <div class="product-action">
                                    <a href="<c:url value="/cart/add/${l.id}"/>"><i class="fa fa-cart-plus"></i></a>
                                    <a href="<c:url value="/products/edit?id=${l.id}"/>"><i class="fa fa-pencil-square-o" aria-hidden="true"> Edit</i></a><i class="fa fa-heart"></i></a>
                                    <a href="<c:url value="/products/product-detail?id=${l.id}"/>"><i class="fa fa-search"></i></a>
                                </div>
                            </div>
                            <div class="product-price">
                                <h3><span>$</span>${l.unitPrice}</h3>
                                <a class="btn" href="<c:url value="/cart/buy/${l.id}"/>"><i class="fa fa-shopping-cart"></i>Buy Now</a>
                            </div>
                        </div>
                    </div>
                </c:forEach> 
            </div>

            <!-- Pagination Start -->
            <div class="col-md-12">
                <nav aria-label="Page navigation example">
                    <ul class="pagination justify-content-center">
                        <li class="page-item disabled">
                            <a class="page-link" href="#" tabindex="-1">Previous</a>
                        </li>
                        <li class="page-item active"><a class="page-link" href="#">1</a></li>
                        <li class="page-item"><a class="page-link" href="#">2</a></li>
                        <li class="page-item"><a class="page-link" href="#">3</a></li>
                        <li class="page-item">
                            <a class="page-link" href="#">Next</a>
                        </li>
                    </ul>
                </nav>
            </div>
            <!-- Pagination Start -->
            <!--            </div>           -->

            <!--                         Side Bar Start -->
            <!--            <div class="col-lg-4 sidebar">
                            <div class="sidebar-widget category">
                                <h2 class="title">Category</h2>
                                <nav class="navbar bg-light">
                                    <ul class="navbar-nav">
                                        <li class="nav-item">
                                            <a class="nav-link" href="<c:url value="/home"/>"><i class="fa fa-home"></i>Home</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="<c:url value="/products/cellphone"/>"><i class="fas fa-mobile"></i>Cell Phones</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="<c:url value="/products/laptop"/>"><i class="fas fa-laptop"></i>Laptop</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="<c:url value="/products/tablet"/>"><i class="fas fa-tablet-alt"></i>Tablet</a>
                                        </li>
            
                                    </ul>
                                </nav>
                            </div>
            
            
            
            
                            <div class="sidebar-widget tag">
                                <h2 class="title">Tags</h2>
                                <a href="#">iPhone12</a>
                                <a href="#">Samsung Note 10</a>
                                <a href="#">Samsung S20</a>
                                <a href="#">iPhone11</a>
                                <a href="#">MacBook</a>
                                <a href="#">Laptop Dell</a>
                                <a href="#">Huawei Phone</a>
                            </div>
                        </div>-->
            <!--            Side Bar End -->
        </div>
    </div>
</div>
<!-- Product List End -->  

<!-- Brand Start -->
<div class="brand">
    <div class="container-fluid">
        <div class="brand-slider">
            <div class="brand-item"><img src="img/brand-1.png" alt=""></div>
            <div class="brand-item"><img src="img/brand-2.png" alt=""></div>
            <div class="brand-item"><img src="img/brand-3.png" alt=""></div>
            <div class="brand-item"><img src="img/brand-4.png" alt=""></div>
            <div class="brand-item"><img src="img/brand-5.png" alt=""></div>
            <div class="brand-item"><img src="img/brand-6.png" alt=""></div>
        </div>
    </div>
</div>
<!-- Brand End -->



<!--=========================================================================-->
<%@ include file="/resources/include-footer.jsp" %> 