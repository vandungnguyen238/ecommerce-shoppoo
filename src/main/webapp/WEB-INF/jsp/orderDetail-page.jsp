

<%@ include file="/resources/include-header.jsp" %>     
<!--=========================================================================-->



<div class="bottom-bar">
    <div class="row">
        <div class="col-md-3">
            <h4 > 
                <i class="fa fa-user-circle-o" aria-hidden="true"> 
                    <a href="<c:url value="/orderDetail/list"/>">Order Detail</a>
                </i>
            </h4>
        </div>
    </div>
</div>


<!--====================== LIST =============================-->
<table class="table table-bordered" style="min-height: 550px;">
    <thead>
        <tr align="center">
            <th>ID</th>
            <th>OrderID</th>
            <th>ProductID</th>
            <th>Quantity</th>
            <th>Amount</th>
        </tr>
    </thead>
    <tbody align="center">
        <c:forEach items="${list}" var="l">
            <tr>
                <th>${l.id}</th>
                <th>${l.orders.id}</th>
                <th>
                    ${l.products.id}
                    <a class="nav-link" href="<c:url value="/products/product-detail?id=${l.products.id}"/>" target="_blank">
                        <i class="fas fa-link"></i> Detail
                    </a>
                </th>
                <th>${l.quantity}</th>
                <th>${l.amount}</th>
            </tr>
        </c:forEach>
    </tbody>
</table>



<!--=========================================================================
<%@ include file="/resources/include-footer.jsp" %> 