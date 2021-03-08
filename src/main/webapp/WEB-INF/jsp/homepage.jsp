

<%@ include file="/resources/include-header.jsp" %>     
<!--=========================================================================-->





<!--========================================== Message Alert before turn off -->
<div class="container mt-3" align="center">
    <div class="alert alert-info">
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">x</button>
        <strong> <3 <3 <3 .......Hi, ${viewUsers.fullName}! Welcome to here!...... <3 <3 <3 </strong>
        <p>${message}</p> 
    </div>
</div>





<!-- Main Slider Start -->
<div class="header">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-3">
                <nav class="navbar bg-light">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/home"/>"><i class="fa fa-home"></i>Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/products/list"/>"><i class="fas fa-shopping-bag"></i>All products</a>
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
                        <li class="nav-item">
                            <a class="nav-link" href="#"><i class="fas fa-bullhorn"></i>Best Buy</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#"><i class="fas fa-address-card"></i>Credit</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/contact"/>"><i class="fas fa-map-marked-alt"></i>Address</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/contact"/>"><i class="fas fa-phone-square-alt"></i>Contact Us</a>
                        </li>
                    </ul>
                </nav>
            </div>
            <div class="col-md-6">
                <div class="header-slider normal-slider">
                    <div class="header-slider-item">
                        <img src="<c:url value="/resources/img/slider-1.jpg"/>" alt="Slider Image" />
                    </div>
                    <div class="header-slider-item">
                        <img src="<c:url value="/resources/img/slider-2.jpg"/>" alt="Slider Image" />

                    </div>
                    <div class="header-slider-item">
                        <img src="<c:url value="/resources/img/slider-3.jpg"/>" alt="Slider Image" />
                    </div>
                </div>
            </div>
            <div class="col-md-3">
                <div class="header-img">
                    <div class="img-item">
                        <img src="<c:url value="/resources/img/category-1.jpg"/>" />

                    </div>
                    <div class="img-item">
                        <img src="<c:url value="/resources/img/category-2.jpg"/>" />

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Main Slider End -->      

<!-- Brand Start -->
<div class="brand">
    <div class="container-fluid">
        <div class="brand-slider">
            <div class="brand-item"><img src="<c:url value="/resources/img/brand-1.png"/>" alt=""></div>
            <div class="brand-item"><img src="<c:url value="/resources/img/brand-2.png"/>" alt=""></div>
            <div class="brand-item"><img src="<c:url value="/resources/img/brand-3.png"/>" alt=""></div>
            <div class="brand-item"><img src="<c:url value="/resources/img/brand-4.png"/>" alt=""></div>
            <div class="brand-item"><img src="<c:url value="/resources/img/brand-5.png"/>" alt=""></div>
            <div class="brand-item"><img src="<c:url value="/resources/img/brand-6.png"/>" alt=""></div>
        </div>
    </div>
</div>
<!-- Brand End -->     

<!-- Featured Product Start -->
<div class="featured-product product">
    <div class="container-fluid">
        <div class="section-header">
            <h1>Hot Products</h1>
        </div>
        <div class="row col-md-16 align-items-center product-slider ">
            <c:forEach items="${list}" var="l">
                <div class="col-lg-3">
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
                            <a href="<c:url value="/product-detail"/>">
                                <img src="<c:url value="${l.images.firstLink}"/>" alt="Product Image">
                            </a>
                            <div class="product-action">
                                <a href="<c:url value="/cart/add/${l.id}"/>"><i class="fa fa-cart-plus"></i></a>
<!--                                <a href="#"><i class="fa fa-heart"></i></a>-->
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
    </div>
</div>
<!-- Featured Product End -->       
<!-- Brand Start -->
<div class="brand">
    <div class="container-fluid">
        <div class="brand-slider">
            <div class="brand-item"><img src="<c:url value="/resources/img/brand-1.png"/>" alt=""></div>
            <div class="brand-item"><img src="<c:url value="/resources/img/brand-2.png"/>" alt=""></div>
            <div class="brand-item"><img src="<c:url value="/resources/img/brand-3.png"/>" alt=""></div>
            <div class="brand-item"><img src="<c:url value="/resources/img/brand-4.png"/>" alt=""></div>
            <div class="brand-item"><img src="<c:url value="/resources/img/brand-5.png"/>" alt=""></div>
            <div class="brand-item"><img src="<c:url value="/resources/img/brand-6.png"/>" alt=""></div>
        </div>
    </div>
</div>
<!-- Brand End --> 

<!-- Feature Start-->
<div class="feature">
    <div class="container-fluid">
        <div class="row align-items-center">
            <div class="col-lg-3 col-md-6 feature-col">
                <div class="feature-content">
                    <i class="fab fa-cc-mastercard"></i>
                    <h2>Secure Payment</h2>
                    <p>
                        We absolutely keep the information of customers.

                    </p>
                </div>
            </div>
            <div class="col-lg-3 col-md-6 feature-col">
                <div class="feature-content">
                    <i class="fa fa-truck"></i>
                    <h2>Worldwide Delivery</h2>
                    <p>
                        We guarantee safe and fast transport service.
                    </p>
                </div>
            </div>
            <div class="col-lg-3 col-md-6 feature-col">
                <div class="feature-content">
                    <i class="fa fa-sync-alt"></i>
                    <h2>90 Days Return</h2>
                    <p>
                        We recall defective products within 90 days.

                    </p>
                </div>
            </div>
            <div class="col-lg-3 col-md-6 feature-col">
                <div class="feature-content">
                    <i class="fa fa-comments"></i>
                    <h2>24/7 Support</h2>
                    <p>
                        Taking care of customers is our honor.                        
                    </p>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Feature End--> 

<!-- Review Start -->
<div class="review">
    <div class="container-fluid">
        <div class="row align-items-center review-slider normal-slider">
            <div class="col-md-6">
                <div class="review-slider-item">
                    <div class="review-img">
                        <img src="<c:url value="/resources/img/review-1.jpg"/>" alt="Image">
                    </div>
                    <div class="review-text">
                        <h2>Jenifer Eira</h2>
                        <h3>Content creator</h3>
                        <div class="ratting">
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                        </div>
                        <p>
                            Shopoo Customer Service always makes me happy!
                        </p>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="review-slider-item">
                    <div class="review-img">
                        <img src="<c:url value="/resources/img/review-2.jpg"/>" alt="Image2">
                    </div>
                    <div class="review-text">
                        <h2>Tom Hiddleston</h2>
                        <h3>Developer</h3>
                        <div class="ratting">
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                        </div>
                        <p>
                            Shopoo is the store I trust for my working, software development tools.
                        </p>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="review-slider-item">
                    <div class="review-img">
                        <img src="<c:url value="/resources/img/review-3.jpg"/>" alt="Image3">
                    </div>
                    <div class="review-text">
                        <h2>Anna Cris</h2>
                        <h3>Housewife</h3>
                        <div class="ratting">
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                        </div>
                        <p>
                            Shopoo is the select the first row for the technology products.
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Review End -->        




<!--=========================================================================-->
<%@ include file="/resources/include-footer.jsp" %> 