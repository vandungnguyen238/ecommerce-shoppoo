

<%@ include file="/resources/include-header.jsp" %>     
<!--=========================================================================-->


<div class="container">
    <div class="col-md-offset-2 col-md-7">
        <h2 class="text-center">Add New Shipping</h2>
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title">Shipping Form</div>
            </div>
            <div class="panel-body">
                <form:form action="save" cssClass="form-horizontal" method="post" modelAttribute="shipping">

                    <!-- need to associate this data with customer id -->
                    <form:hidden path="id" />

                    <div class="form-group">
                        <label for="shippingName" class="col-md-3 control-label">Shipping Name</label>
                        <div class="col-md-9">
                            <form:input path="shippingName" cssClass="form-control" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="warehouse" class="col-md-3 control-label">Warehouse</label>
                        <div class="col-md-9">
                            <form:input path="warehouse" cssClass="form-control" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="receivedBy" class="col-md-3 control-label">Received By</label>
                        <div class="col-md-9">
                            <form:input type="date" path="receivedBy" cssClass="form-control" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="description" class="col-md-3 control-label">Description</label>
                        <div class="col-md-9">
                            <form:input path="description" cssClass="form-control" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="ordersStatus" class="col-md-3 control-label">Orders Status</label>
                        <div class="col-md-9">
                            <form:input path="ordersStatus" cssClass="form-control" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="shippingStatus" class="col-md-3 control-label">Shipping Status</label>
                        <div class="col-md-9">
                            <form:input path="shippingStatus" cssClass="form-control" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="receivedDate" class="col-md-3 control-label">Received Date</label>
                        <div class="col-md-9">
                            <form:input type="date" path="receivedDate" cssClass="form-control" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="shipDate" class="col-md-3 control-label">Ship Date</label>
                        <div class="col-md-9">
                            <form:input type="date" path="shipDate" cssClass="form-control" />
                        </div>
                    </div>

                    <div class="form-group">
                        <!-- Button -->
                        <div class="col-md-offset-3 col-md-9">
                            <form:button cssClass="btn btn-primary">Submit</form:button>
                            </div>
                        </div>
                </form:form>
            </div>
        </div>
    </div>
</div>






<!--=========================================================================-->
<%@ include file="/resources/include-footer.jsp" %> 
