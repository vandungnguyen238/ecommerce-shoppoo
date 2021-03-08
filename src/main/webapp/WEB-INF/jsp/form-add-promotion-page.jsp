

<%@ include file="/resources/include-header.jsp" %>     
<!--=========================================================================-->


<div class="container">
    <div class="col-md-offset-2 col-md-7">
        <h2 class="text-center">Add New Promotion</h2>
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title">Promotion Form</div>
            </div>
            <div class="panel-body">
                <form:form action="save" cssClass="form-horizontal" method="post" modelAttribute="promotion">

                    <!-- need to associate this data with customer id -->
                    <form:hidden path="id" />

                    <div class="form-group">
                        <label for="startDate" class="col-md-3 control-label">Start Date</label>
                        <div class="col-md-9">
                            <form:input type="date" path="startDate" cssClass="form-control" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="endDate" class="col-md-3 control-label">End Date</label>
                        <div class="col-md-9">
                            <form:input type="date" path="endDate" cssClass="form-control" />
                        </div>
                    </div>
                        
                    <div class="form-group">
                        <label for="name" class="col-md-3 control-label">Event Name</label>
                        <div class="col-md-9">
                            <form:input path="name" cssClass="form-control" />
                        </div>
                    </div>
                        
                    <div class="form-group">
                        <label for="discount" class="col-md-3 control-label">Discount</label>
                        <div class="col-md-9">
                            <form:input path="discount" cssClass="form-control" />
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
