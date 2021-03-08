

<%@ include file="/resources/include-header.jsp" %>     
<!--=========================================================================-->



<div class="bottom-bar">
    <div class="row">
        <div class="col-md-3">
            <h4 > 
                <i class="fa fa-user-circle-o" aria-hidden="true"> 
                    <a href="<c:url value="/orders/list"/>"> List of Orders</a>
                </i>
            </h4>
        </div>
        <div class="search col-md-6">
            <form action="searchByID" method="get">
                <input type="text" placeholder="Search Orders By ID" name="id" value="${id}" required="">
                <button><i class="fa fa-search"></i></button>
            </form>
        </div>
    </div>
</div>


<!--====================== LIST ORDER =============================-->
<table class="table table-bordered" style="min-height: 550px;">
    <thead>
        <tr align="center">
            <th>ID</th>
            <th>CreateDate</th>
            <th>OrderDetail</th>
            <th>ShippingName</th>
            <th>Cost</th>
            <th>PromotionName</th>
            <th>Discount</th>
            <th>Total</th>
            <th>Status</th>
            <th>Username</th>
            <th>FullName</th>
            <th>ToAddress</th>
            <th>Phone</th>
            <th>Email</th>
            <th colspan="2">Action</th>

        </tr>
    </thead>
    <tbody>
        <c:forEach items="${list}" var="l">
            <tr>
                <th>${l.id}</th>
                <th>${l.createDate}</th>
                <th><a href="<c:url value="/orderDetail/getOrderDetailByOrderId?id=${l.id}"/>">OrderDetail</a></th>
                <th><a href="<c:url value="/shipping/getByShippingName?name=${l.shipping.shippingName}"/>">${l.shipping.shippingName}</a></th>
                <th>${l.shipping.cost}</th>
                <th>${l.promotion.name}</th>
                <th>${l.promotion.discount}</th>
                <th>$<f:formatNumber value="${l.total}" pattern="#,###"/></th>
                <th>${l.ordersStatus}</th>
                <th>${l.users.username}</th>
                <th>${l.users.fullName}</th>
                <th>${l.users.address}</th>
                <th>${l.users.phone}</th>
                <th>${l.users.email}</th>
                <th><a href="<c:url value="/orders/edit?id=${l.id}"/>"><i class="fa fa-pencil-square-o" aria-hidden="true"> Edit</i></a></th>
                <th><a href="<c:url value="/orders/delete?id=${l.id}"/>"><i class="fa fa-trash" aria-hidden="true"> Delete</i></a></th>
            </tr>
        </c:forEach>
    </tbody>
    <tfoot>
        <tr align="center">
            <th colspan="13"><i class="fa fa-commenting" aria-hidden="true"> ${message}</i></th>
            <th colspan="2"><a href="<c:url value="/orders/add"/>"><i class="fa fa-plus-circle" aria-hidden="true"> Add</i></a></th>
        </tr>
    </tfoot>
</table>



<!--=========================================================================-->
<%@ include file="/resources/include-footer.jsp" %> 