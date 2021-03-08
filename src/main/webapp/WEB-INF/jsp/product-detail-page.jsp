

<%@ include file="/resources/include-header.jsp" %>     
<!--=========================================================================-->





<!-- Breadcrumb Start -->
<div class="breadcrumb-wrap">
    <div class="container-fluid">
        <ul class="breadcrumb">
            <li class="breadcrumb-item"><a href="#">Home</a></li>
            <li class="breadcrumb-item"><a href="#">Products</a></li>
            <li class="breadcrumb-item active">Product Detail</li>
        </ul>
    </div>
</div>
<!-- Breadcrumb End -->

<!-- Product Detail Start -->
<div class="product-detail">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-8">
                <div class="product-detail-top">
                    <div class="row align-items-center">
                        <div class="col-md-5">
                            <div class="product-slider-single normal-slider">
                                <a href="#">
                                    <img src="<c:url value="${product.images.firstLink}"/>" alt="Product Image">
                                </a>
                            </div>

                        </div>
                        <div class="col-md-7">
                            <div class="product-content">
                                <div class="title"><h2>${product.productName}</h2></div>
                                <div class="price">
                                    <h4>Price:</h4>
                                    <p><span>$</span>${product.unitPrice}</p>
                                </div>
                                <div class="show">
                                    <h4>Quantity:</h4>
                                    <p>${product.quantityInStore} </p>
                                </div>
                                <div class="show">
                                    <h4>Warranty:</h4>
                                    <p>${product.warranty} </p>
                                </div>
                                <div class="show">
                                    <h4>Manufacture:</h4>
                                    <p>${product.manufacture.manufactureName}</p>
                                </div>
                                <!--                                
                                <div class="p-color">
                                    <h4>Color:</h4>
                                    <div class="btn-group btn-group-sm">
                                        <button type="button" class="btn">White</button>
                                        <button type="button" class="btn">Black</button>
                                        <button type="button" class="btn">Blue</button>
                                    </div> 
                                </div>-->
                                <div class="action">
                                    <a class="btn"  href="<c:url value="/cart/add/${product.id}"/>"><i class="fa fa-shopping-cart"></i>Add to Cart</a>
                                    <a class="btn"  href="<c:url value="/cart/buy/${product.id}"/>"><i class="fa fa-shopping-bag"></i>Buy Now</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row product-detail-bottom">
                    <div class="col-lg-12">
                        <ul class="nav nav-pills nav-justified">
                            <li class="nav-item">
                                <a class="nav-link active" data-toggle="pill" href="#description">Description</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" data-toggle="pill" href="#reviews">Reviews </a>
                            </li>
                        </ul>

                        <div class="tab-content">
                            <div id="description" class="container tab-pane active">
                                <h4>Product description</h4>

                                <p>${product.decription}</p>

                            </div>
                            <div id="reviews" class="container tab-pane fade">
                                <div class="reviews-submitted">
                                    <div class="reviewer">Phasellus Gravida - <span>01 Jan 2020</span></div>
                                    <div class="ratting">
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                    </div>
                                    <p>
                                        Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Side Bar Start -->
            <div class="col-lg-4 sidebar">
                <div class="sidebar-widget category">
                    <h2 class="title">Category</h2>
                    <nav class="navbar bg-light">
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link" href="#"><i class="fa fa-home"></i>Home</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="<c:url value="/products/searchType?typeName=Cellphone"/>"><i class="fas fa-mobile"></i>Cell Phones</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="<c:url value="/products/searchType?typeName=Laptop"/>"><i class="fas fa-laptop"></i>Laptop</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="<c:url value="/products/searchType?typeName=Tablet"/>"><i class="fas fa-tablet-alt"></i>Tablet</a>
                            </li>

                        </ul>
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