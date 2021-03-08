

<%@ include file="/resources/include-header.jsp" %>     
<!--=========================================================================-->






<!--====================== SEARCH BY MORE TOOL =============================-->
<!--Only view with ROLE_ADMIN-->
<sec:authorize access="hasRole('ROLE_ADMIN')"> 
    <div class="container-fluid">
        <div class="row">
            <h1><i class="fa fa-user-circle" aria-hidden="true"></i> SEARCH MORE TOOL</h1>
            <div class="col-md-12">
                <div class="row">
                    <div class="col-md-3">
                        <div class="product-short">
                            <div class="dropdown">
                                <a href="<c:url value="/account/searchNewAccount"/>" class="dropdown-toggle">New Accounts</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="search">
                            <form action="searchByName" method="get">
                                <input type="text" placeholder="Search By Name" name="name" value="${name}" required/>
                                <button><i class="fa fa-search"></i></button>
                            </form>
                        </div>
                    </div>
                    <!--Khi su dung path phai use form:form-->
                    <!--Chu y: co path thi bat buoc phai modelAttribute truoc do-->
                    <div class="col-md-6">
                        <form:form action="searchByDate" method="get" modelAttribute="dateToDate">
                            <label>&nbsp; <b>From</b> &nbsp;</label>
                            <form:input class="search col-md-4" type="date" path="fromDate"/>                            
                            <label>&nbsp; <b>To</b> &nbsp;</label>
                            <form:input class="search col-md-4" type="date" path="toDate"/>
                            <button class="btn btn-success">Search</button>
                        </div>
                    </form:form>
                </div>
            </div>


            <div class="row col-md-12">
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
                                <tr>
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
                        <tfoot>
                            <tr>
                                <th colspan="8"><i class="fa fa-commenting" aria-hidden="true"> ${message}</i></th>
                                <th colspan="2"><a href="<c:url value="/account/add"/>"><i class="fa fa-plus-circle" aria-hidden="true"> Add</i></a></th>
                            </tr>
                        </tfoot>
                    </table>
                </div>
            </div>

        </div>
    </div>
    <h1>&nbsp;</h1>     
    <h1>&nbsp;</h1>    
</sec:authorize>









<!--=========================================================================-->
<%@ include file="/resources/include-footer.jsp" %> 