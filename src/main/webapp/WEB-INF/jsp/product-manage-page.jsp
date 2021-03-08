

<%@ include file="/resources/include-header.jsp" %>     
<!--=========================================================================-->




<!-- Breadcrumb Start -->
<div class="breadcrumb-wrap">
    <div class="container-fluid">
        <ul class="breadcrumb">
            <li class="breadcrumb-item"><a href="#">Home</a></li>
            <li class="breadcrumb-item"><a href="#">Products</a></li>
            <li class="breadcrumb-item active">Manage Product</li>
        </ul>
    </div>
</div>
<!-- Breadcrumb End -->


<div class="my-account" style="min-height: 550px;">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="tab-pane fade show active" id="account-tab" role="tabpanel" aria-labelledby="account-nav">
                    <h4>List of Products</h4>

                    <div class="row">
                        <div class="table-responsive-sm col-md-12">
                            <table class="table table-bordered">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Product Name</th>
                                        <th>Unit Price</th>
                                        <th>Quantity</th>
                                        <th>Manufactory</th>
                                        <th>Type</th>
                                        <th>Description</th>
                                        <th>Update Date</th>
                                        <th>Warranty</th>

                                        <th colspan="2">Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${list}" var="l">
                                        <tr>
                                            <th>${l.id}</th>
                                            <th>${l.productName}</th>
                                            <th>${l.unitPrice}</th>
                                            <th>${l.quantityInStore}</th>
                                            <th>${l.manufacture.manufactureName}</th>
                                            <th>${l.types.typeName}</th>
                                            <th>${l.decription}</th>
                                            <th>${l.updateDate}</th>
                                            <th>${l.warranty}</th>
                                            <th><a href="<c:url value="/products/edit?id=${l.id}"/>"><i class="fa fa-pencil-square-o" aria-hidden="true"> Edit</i></a></th>
                                            <th><a href="<c:url value="/products/delete?id=${l.id}"/>"><i class="fa fa-trash" aria-hidden="true"> Delete</i></a></th>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                                <tfoot>
                                    <tr>
                                        <th colspan="9"><i class="fa fa-commenting" aria-hidden="true"> ${message}</i></th>
                                        <th colspan="2"><a href="<c:url value="/products/add"/>"><i class="fa fa-plus-circle" aria-hidden="true"> Add</i></a></th>
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