

<%@ include file="/resources/include-header.jsp" %>     
<!--=========================================================================-->





<!-- Bottom Bar Start -->
<div class="bottom-bar">
    <div class="container-fluid">
        <div class="row align-items-center">

            <div class="col-md-3">
                <div class="search">
                    <form action="searchByID" method="get">
                        <input type="text" placeholder="Search Promotion By ID" name="id" required="">
                        <button><i class="fa fa-search"></i></button>
                    </form>
                </div>
            </div>

            <div class="col-md-3">
                <div class="search">
                    <form action="searchByText" method="get">
                        <input type="text" placeholder="Search Promotion By Text" name="keywords" required="">
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
                            <i class="fa fa-user-circle-o" aria-hidden="true"> <a href="<c:url value="/promotion/list"/>"> List of Promotion</a></i>
                        </div>
                    </h4>

                    <div class="row">
                        <div class="table-responsive-sm col-md-12">
                            <table class="table table-bordered">
                                <thead>
                                    <tr align="center">
                                        <th>ID</th>
                                        <th>Event Name</th>
                                        <th>Start Date</th>
                                        <th>End Date</th>
                                        <th>Discount</th>
                                        <th colspan="2">Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${list}" var="p">
                                        <tr align="center">
                                            <th>${p.id}</th>
                                            <th>${p.name}</th>
                                            <th>${p.startDate}</th>
                                            <th>${p.endDate}</th>
                                            <th>${p.discount}</th>
                                            <th><a href="<c:url value="/promotion/update?id=${p.id}"/>"><i class="fa fa-pencil-square-o" aria-hidden="true"> Edit</i></a></th>
                                            <th><a href="<c:url value="/promotion/delete?id=${p.id}"/>"><i class="fa fa-trash" aria-hidden="true"> Delete</i></a></th>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                                <tfoot>
                                    <tr align="center">
                                        <th colspan="5"><i class="fa fa-commenting" aria-hidden="true"> ${message}</i></th>
                                        <th colspan="2"><a href="<c:url value="/promotion/add"/>"><i class="fa fa-plus-circle" aria-hidden="true"> Add</i></a></th>
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