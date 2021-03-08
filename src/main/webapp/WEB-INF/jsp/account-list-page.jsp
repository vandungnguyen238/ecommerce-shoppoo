

<%@ include file="/resources/include-header.jsp" %>     
<!--=========================================================================-->





<!--====================== LIST ACCOUNT =============================-->
<!-- Breadcrumb Start -->
<div class="breadcrumb-wrap">
    <div class="container-fluid">
        <ul class="breadcrumb">
            <li class="breadcrumb-item"><a href="#">Home</a></li>
            <li class="breadcrumb-item"><a href="#">Accounts</a></li>
            <li class="breadcrumb-item active">
                <a href="<c:url value="/account/list"/>"> List of Accounts</a>
            </li>
        </ul>
    </div>
</div>



<!-- Bottom Bar Start -->
<div class="bottom-bar">
    <div class="container-fluid">
        <div class="row align-items-center">
            <div class="col-md-3">
                <div class="search">
                    <form action="searchByID" method="get">
                        <input type="text" placeholder="Search By ID" name="id" required="">
                        <button><i class="fa fa-search"></i></button>
                    </form>
                </div>
            </div>

            <div class="col-md-6">
                <div class="product-price-range">
                    <div class="dropdown">
                        <h2><a href="<c:url value="/account/searchByTool"/>"> Search more tool</a></h2>
                    </div>
                </div>
            </div>



        </div>
    </div>
</div>
<!-- Bottom Bar End --> 

<!-- Breadcrumb End -->
<div class="my-account" style="min-height: 550px;">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="tab-pane fade show active" id="account-tab" role="tabpanel" aria-labelledby="account-nav">
                    <div class="row">
                        <div class="table-responsive-sm col-md-12">
                            <table class="table table-bordered">
                                <thead align="center">
                                    <tr>
                                        <th>ID</th>
                                        <th>FullName</th>
                                        <th>Phone</th>
                                        <th>Address</th>
                                        <th>Email</th>
                                        <th>Username</th>
                                        <th>Password</th>
                                        <th>Enable</th>
                                        <th>CreateDate</th>
                                        <th colspan="2">Action</th>
                                    </tr>
                                </thead>
                                <tbody align="center">
                                    <c:forEach items="${list}" var="l">
                                        <tr align="center">
                                            <th>${l.id}</th>
                                            <th>${l.fullName}</th>
                                            <th>${l.phone}</th>
                                            <th>${l.address}</th>
                                            <th>${l.email}</th>
                                            <th>${l.username}</th>
                                            <th>${l.password}</th>
                                            <th>${l.enable}</th>
                                            <th>${l.createDate}</th>                              
                                            <th><a href="<c:url value="/account/edit?id=${l.id}"/>"><i class="fa fa-pencil-square-o" aria-hidden="true"> Edit</i></a></th>
                                            <th><a href="<c:url value="/account/delete?id=${l.id}"/>"><i class="fa fa-trash" aria-hidden="true"> Delete</i></a></th>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                                <tfoot align="center">
                                    <tr align="center">
                                        <th colspan="9"><i class="fa fa-commenting" aria-hidden="true"> ${message}</i></th>
                                        <th colspan="2"><a href="<c:url value="/account/add"/>"><i class="fa fa-plus-circle" aria-hidden="true"> Add</i></a></th>
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