

<%@ include file="/resources/include-header.jsp" %>     
<!--=========================================================================-->     


<!-- Breadcrumb Start -->
<div class="breadcrumb-wrap">
    <div class="container-fluid">
        <ul class="breadcrumb">
            <li class="breadcrumb-item"><a href="#">Home</a></li>
            <li class="breadcrumb-item"><a href="#">Products</a></li>
            <li class="breadcrumb-item active">Cart</li>
        </ul>
    </div>
</div>
<!-- Breadcrumb End -->

<!-- Cart Start -->
<div class="cart-page">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-8">
                <div class="cart-page-inner">
                    <div class="table-responsive">
                        <table class="table table-bordered">
                            <thead class="thead-dark">
                                <tr>
                                    <th>Product</th>
                                    <th>Price</th>
                                    <th>Quantity</th>
                                    <th>Total</th>
                                    <th>Remove</th>
                                </tr>
                            </thead>
                            <tbody class="align-middle">
                                <c:set var="index" value="0"/>
                                <c:forEach items="${lineItems}" var="item">
                                    <tr>
                                        <td>
                                            <div class="img">
                                                <a href="#"><img src="<c:url value="${item.products.images.firstLink}"/>" alt="Image"></a>
                                                <p>${item.products.productName}</p>
                                            </div>
                                        </td>
                                        <td>$ ${item.products.unitPrice}</td>
                                        <td>
                                            <div class="">
                                                <a class="btn-minus" href="<c:url value='/cart/decreate/${index}'/>"><i class="fa fa-minus"></i></a>
                                                <input type="text" value="${item.quantity}" style="background: white; color:black;">
                                                <a class="btn-plus" href="<c:url value='/cart/increate/${index}'/>"><i class="fa fa-plus"></i></a>
                                            </div>
                                        </td>
                                        <td>$ ${item.products.unitPrice * item.quantity}</td>
                                        <td><a href="<c:url value='/cart/remove/${item.products.id}'/>"><i class="fa fa-trash"></i></a></td>
                                    </tr>
                                    <c:set var="index" value="${index + 1}"/>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="cart-page-inner">
                    <div class="row">
<!--                        
                        <div class="col-md-12">
                            <div class="coupon">
                                <input type="text" placeholder="Coupon Code">
                                <button>Apply Code</button>
                            </div>
                        </div>-->
                        <div class="col-md-12">
                            <div class="cart-summary">
                                <div class="cart-content">
                                    <h1>Cart Summary</h1>
                                    <p>Sub Total<span>$ <f:formatNumber value="${amount}" pattern="#,###"/></span></p>
                                    <p>Shipping Cost<span>$ <f:formatNumber value="${amount * 0.1}" pattern="#,###"/></span></p>
                                    <h2>Grand Total<span>$ <f:formatNumber value="${amount *0.9}" pattern="#,###"/></span></h2>
                                </div>
                                <div class="cart-btn" align="center">
                                    <a href="<c:url value='/products/list'/>" ><button>Go Shopping</button></a>
                                    <c:if test="${viewUsers == null}">
                                        <a href="<c:url value='/login'/>" ><button>Login Now</button></a>
                                        <a href="#" ><button>Checkout</button></a>
                                    </c:if>
                                </div>
                                <!--Only view with role-admin or role-user-->
                                <sec:authorize access="hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')">
                                    <div class="cart-btn" align="center">
                                        <!--check number item in cart-->
                                        <c:if test="${count < 1}"> 
                                            <a href="#" ><button>Checkout</button></a>
                                        </c:if>
                                        <c:if test="${count >= 1}">
                                            <a href="<c:url value='/checkout/detail'/>" ><button>Checkout</button></a>
                                        </c:if>
                                    </div>
                                </sec:authorize>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Cart End -->




<!--=========================================================================-->
<%@ include file="/resources/include-footer.jsp" %> 