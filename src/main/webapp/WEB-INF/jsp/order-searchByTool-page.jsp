

<%@ include file="/resources/include-header.jsp" %>     
<!--=========================================================================-->




<div class="bottom-bar">
    <div class="row">
        <div class="row col-md-12">
            <div class="col-md-3">
                <h4>
                    <i class="fa fa-user-circle-o" aria-hidden="true"> 
                        <a href="<c:url value="/orders/list"/>"> List of Orders</a>
                    </i>
                </h4>
            </div>

            <div class="col-md-3">
                <div class="search">
                    <form action="searchByText" method="get">
                        <input type="text" name="keywords"  value="${keywords}" placeholder="Search By Name" required="true"/>
                        <button><i class="fa fa-search"></i></button>
                    </form>
                </div>
            </div>

            <div class="col-md-6">
                <form:form action="searchDateToDate" method="get" modelAttribute="dateToDate">
                    <label>&nbsp; <b>From</b> &nbsp;</label>
                    <form:input class="search col-md-4" type="date" path="fromDate"/>
                    <label>&nbsp; <b>To</b> &nbsp;</label>
                    <form:input class="search col-md-4" type="date" path="toDate"/>
                    <button class="btn btn-success">Search</button>
                </div>
            </form:form>
        </div>
    </div>
</div>




<!--====================== LIST ACCOUNT =============================-->
<table class="table table-bordered" style="min-height: 550px;">
    <thead>
        <tr align="center">
            <th>ID</th>
            <th>CreateDate</th>
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
                <th>${l.shippingName}</th>
                <th>${l.cost}</th>
                <th>${l.discount}</th>
                <th>${l.discount}</th>
                <th>$<f:formatNumber value="${l.total}" pattern="#,###"/></th>
                <th>${l.ordersStatus}</th>
                <th>${l.username}</th>
                <th>${l.fullName}</th>
                <th>${l.address}</th>
                <th>${l.phone}</th>
                <th>${l.email}</th>
                <th align="center"><a href="<c:url value="/orders/edit?id=${l.id}"/>"><i class="fa fa-pencil-square-o" aria-hidden="true"> Edit</i></a></th>
                <th align="center"><a href="<c:url value="/orders/delete?id=${l.id}"/>"><i class="fa fa-trash" aria-hidden="true"> Delete</i></a></th>
            </tr>
        </c:forEach>
    </tbody>
    <tfoot>
        <tr align="center">
            <th colspan="13"><i class="fa fa-commenting text-danger" aria-hidden="true"> ${message}</i></th>
            <th colspan="2"><a href="<c:url value="/orders/add"/>"><i class="fa fa-plus-circle" aria-hidden="true"> Add</i></a></th>
        </tr>
    </tfoot>
</table>





<!--=========================================================================-->
<%@ include file="/resources/include-footer.jsp" %> 