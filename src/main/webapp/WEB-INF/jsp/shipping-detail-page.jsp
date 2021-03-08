

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
                            <i class="fa fa-user-circle-o" aria-hidden="true"> <a href="#">Shipping - Detail</a></i>
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
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <th>${shipping.id}</th>
                                        <th>${shipping.shippingName}</th>
                                        <th>${shipping.warehouse}</th>
                                        <th>${shipping.receivedBy}</th>
                                        <th>${shipping.description}</th>
                                        <th>${shipping.ordersStatus}</th>
                                        <th>${shipping.shippingStatus}</th>
                                        <th>${shipping.receivedDate}</th>
                                        <th>${shipping.shipDate}</th>
                                    </tr>
                                </tbody>
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