

<%@ include file="/resources/include-header.jsp" %>     
<!--=========================================================================-->




<div class="bottom-bar">
    <div class="row">
        <div class="row col-md-12">
            <div class="col-md-3">
                <h4>
                    <i class="fa fa-user-circle-o" aria-hidden="true"> 
                        <a href="<c:url value="/orders/report"/>"> Report Summary</a>
                    </i>
                </h4>
            </div>


            <div class="col-md-6">
                <form:form action="reportSummary" method="get" modelAttribute="dateToDate">
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
<table class="table table-bordered" style="min-height: 100px;">
    <tr align="center">
        <th rowspan="2">&nbsp;</th>
        <th>Number of order</th>
        <th>Total of amount</th>
        <th rowspan="2">&nbsp;</th>
    </tr>
    <tr align="center">
        <th>0${number} order</th>
        <th>$ ${total}</th>
    </tr>
</table>





<!--=========================================================================-->
<%@ include file="/resources/include-footer.jsp" %> 