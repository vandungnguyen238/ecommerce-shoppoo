

<%@ include file="/resources/include-header.jsp" %>     
<!--=========================================================================-->




<!-- Checkout Start -->
<div class="checkout">
    <div class="container-fluid"> 
        <div class="row">
            <div class="col-lg-8">
                <div class="checkout-inner">

                    <div class="billing-address">
                        <h2>Receive Address</h2>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Username</label>
                                <input class="form-control" type="text" placeholder="First Name" value="${viewUsers.username}" readonly="true"/>
                            </div>
                            <div class="col-md-6">
                                <label>E-mail</label>
                                <input class="form-control" type="text" placeholder="E-mail"  value="${viewUsers.email}" readonly="true">
                            </div>
                            <div class="col-md-6">
                                <label>Full Name</label>
                                <input class="form-control" type="text" placeholder="First Name" value="${viewUsers.fullName}" readonly="true"/>
                            </div>
                            <div class="col-md-6">
                                <label>Mobile No</label>
                                <input class="form-control" type="text" placeholder="Mobile No"  value="${viewUsers.phone}" readonly="true">
                            </div>      
                            <div class="col-md-12">
                                <input class="form-control" type="hidden">
                            </div>                
                            <div class="col-md-6">
                                <label>Address</label>
                                <input class="form-control" type="text" placeholder="Address" value="${viewUsers.address}" readonly="true">
                            </div>                
                            <div class="col-md-6">
                                <label>Country</label>
                                <select class="custom-select" disabled="true">
                                    <option selected="true">VIET NAM</option>
                                    <option>LAO</option>
                                    <option>CAMPUCHIA</option>
                                    <option>THAI LAN</option>
                                </select>
                            </div> 
                            <div class="col-md-6">
                                <label>Quantity of Product</label>
                                <input class="form-control" type="text" value="${count}" readonly="true">
                            </div> 
                            <div class="col-md-6">
                                <label>Amount</label>
                                <input class="form-control" type="text" value="${amount}" readonly="true">
                            </div>                       
                            <div class="col-md-12">
                                <input class="form-control" type="hidden" readonly="true">
                            </div>


                            <!--=================== FORM ====================-->
                            <div class="col-md-12">
                                <form:form action="save" method="post" modelAttribute="ordersType">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <label>Promotion</label>
                                            <form:select path="promotionId"  class="custom-select">
                                                <c:forEach items="${promotionList}" var="p">
                                                    <c:choose>
                                                        <c:when test="${p.startDate < currentDate && currentDate < p.endDate}">
                                                            <form:option value="${p.id}" selected="true">${p.name}</form:option>
                                                        </c:when>
                                                    </c:choose> 
                                                </c:forEach>
                                            </form:select>
                                        </div>
                                        <div class="col-md-6">
                                            <label>Discount</label>
                                            <form:select path="discount"  class="custom-select">
                                                <c:forEach items="${promotionList}" var="p">
                                                    <c:if test="${p.startDate < currentDate && currentDate < p.endDate}">
                                                        <form:option value="${p.discount}" selected="true">${p.discount}</form:option>
                                                    </c:if>
                                                </c:forEach>
                                            </form:select>
                                        </div>
                                    </div>



                                    <div class="product-view">
                                        <div class="row">
                                            &nbsp;&nbsp;&nbsp;&nbsp;
                                            <div class="row col-md-6">
                                                <div class="product-price-range">
                                                    <div class="dropdown">
                                                        <div class="dropdown-toggle" data-toggle="dropdown">Shipping Company</div>
                                                        <div class="dropdown-menu dropdown-menu-right">
                                                            <c:forEach items="${shippingList}" var="s">
                                                                <a href="<c:url value="/checkout/changeShipping?id=${s.id}"/>" class="dropdown-item">${s.shippingName}</a>
                                                            </c:forEach>
                                                        </div>
                                                        <form:input class="form-control" type="hidden" path="shippingId" readonly="true"/>
                                                        <form:input class="form-control" type="text" path="shippingName" readonly="true"/>
                                                    </div>
                                                </div>
                                            </div>
                                            &nbsp;&nbsp;&nbsp;
                                            <div class="col-md-6">
                                                <label>Shipping Cost</label>
                                                <form:input class="form-control" type="text" path="cost" readonly="true"/>
                                            </div>
                                        </div>
                                    </div>


                                    <div class="row"> 
                                        <div class="col-md-12"> 
                                            <label><strong>Total Payment</strong></label>
                                            <form:input class="form-control" type="hidden" path="total" value="${amount * (1 + 0.1) + ordersType.cost}" readonly="true"/>
                                            <input class="form-control" type="text" path="total" value='$<f:formatNumber value="${amount * (1 + 0.1) + ordersType.cost}" pattern="#,###"/>' readonly="true"/>
                                        </div>
                                    </div>


                                    <div class="row"> 
                                        <div class="col-md-12"> 
                                            <div class="checkout-payment">
                                                <div class="payment-methods">
                                                    <h2>Payment Methods</h2>
                                                    <div class="payment-method">
                                                        <div class="custom-control custom-radio">
                                                            <input type="radio" class="custom-control-input" id="payment-1" name="payment" checked="true">
                                                            <label class="custom-control-label" for="payment-1">Cash</label>
                                                        </div>
                                                    </div>

                                                    <div class="payment-method">
                                                        <div class="custom-control custom-radio">
                                                            <input type="radio" class="custom-control-input" id="payment-2" name="payment">
                                                            <label class="custom-control-label" for="payment-2">Credit</label>
                                                        </div>
                                                    </div>
                                                </div>


                                                <div class="checkout-btn col-md-6">
                                                    <button class="btn">Place Order</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </form:form>
                            </div>
                        </div> 
                        <h1>&nbsp;</h1>
                        <h1>&nbsp;</h1>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Checkout End -->





<!--=========================================================================-->
<%@ include file="/resources/include-footer.jsp" %> 