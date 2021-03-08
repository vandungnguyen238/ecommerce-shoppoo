

<%@ include file="/resources/include-header.jsp" %>     
<!--=========================================================================-->





<!-- Bottom Bar Start -->
<div class="bottom-bar">
    <div class="container-fluid">
        <div class="row align-items-center">

            <div class="col-md-3">
                <div class="search">
                    <form action="searchByID" method="get">
                        <input type="text" placeholder="Search Shipping By ID" name="id" required="">
                        <button><i class="fa fa-search"></i></button>
                    </form>
                </div>
            </div>
            
            <div class="col-md-3">
                <div class="search">
                    <form action="searchByText" method="get">
                        <input type="text" placeholder="Search Shipping By Text" name="keywords" required="">
                        <button><i class="fa fa-search"></i></button>
                    </form>
                </div>
            </div>

        </div>
    </div>
</div>
<!-- Bottom Bar End --> 

<!--====================== LIST ACCOUNT =============================-->
<div class="my-account" style="min-height: 550px;">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="tab-pane fade show active" id="account-tab" role="tabpanel" aria-labelledby="account-nav">
                    <h4>
                        <div class="class-div1">
                            <i class="fa fa-user-circle-o" aria-hidden="true"> <a href="<c:url value="/shipping/list"/>"> List of Shipping</a></i>
                        </div>
                    </h4>

                    <div class="row">
                        <div class="table-responsive-sm col-md-12">
                            <table class="table table-bordered">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Shipping Name</th>
                                        <th>Warehouse</th>
                                        <th>Received By</th>
                                        <th>Description</th>
                                        <th>Orders Status</th>
                                        <th>Shipping Status</th>
                                        <th>Received Date</th>
                                        <th>Shipped Date</th>
                                        <th colspan="2">Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${list}" var="s">
                                        <tr>
                                            <th>${s.id}</th>
                                            <th>${s.shippingName}</th>
                                            <th>${s.warehouse}</th>
                                            <th>${s.receivedBy}</th>
                                            <th>${s.description}</th>
                                            <th>${s.ordersStatus}</th>
                                            <th>${s.shippingStatus}</th>
                                            <th>${s.receivedDate}</th>
                                            <th>${s.shipDate}</th>
                                            <th><a href="<c:url value="/shipping/update?id=${s.id}"/>"><i class="fa fa-pencil-square-o" aria-hidden="true"> Edit</i></a></th>
                                            <th><a href="<c:url value="/shipping/delete?id=${s.id}"/>"><i class="fa fa-trash" aria-hidden="true"> Delete</i></a></th>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                                <tfoot>
                                    <tr align="center">
                                        <th colspan="9"><i class="fa fa-commenting" aria-hidden="true"> ${message}</i></th>
                                        <th colspan="2"><a href="<c:url value="/shipping/add"/>"><i class="fa fa-plus-circle" aria-hidden="true"> Add</i></a></th>
                                    </tr>
                                </tfoot>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!--=========================================================================-->
<%@ include file="/resources/include-footer.jsp" %> 