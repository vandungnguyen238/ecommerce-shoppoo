

<%@ include file="/resources/include-header.jsp" %>     
<!--=========================================================================-->      





<!-- Breadcrumb Start -->
<div class="breadcrumb-wrap">
    <div class="container-fluid">
        <ul class="breadcrumb">
            <li class="breadcrumb-item"><a href="#">Account</a></li>
            <li class="breadcrumb-item active">Update/ Add & Edit</li>
        </ul>
    </div>
</div>
<!-- Breadcrumb End -->


<!--============FORM ADD/EDIT ===========================================================-->
<!-- My Account Start -->
<div class="my-account">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <form:form class="row" action='save' method="post" modelAttribute="users">

                    <p class="col-md-12" style="color: red;">&nbsp; ${message}</p>

                    <div class="col-md-12">
                        <form:input class="form-control" type="hidden" placeholder="ID" path="id"/>
                    </div>

                    <div class="col-md-12">
                        <label>First Name</label>
                    </div>
                    <div class="col-md-9">
                        <form:input class="form-control" type="text" placeholder="First Name" path="firstName"/>
                    </div>
                    <div class="col-md-3">
                        <form:errors cssClass="text-danger" path="firstName"/>
                    </div>

                    <div class="col-md-12">
                        <label>Last Name</label>
                    </div>
                    <div class="col-md-9">
                        <form:input class="form-control" type="text" placeholder="Last Name" path="lastName"/>
                    </div>
                    <div class="col-md-3">
                        <form:errors cssClass="text-danger" path="lastName"/>
                    </div>

                    <div class="col-md-12">
                        <label>Mobile</label>
                    </div>
                    <div class="col-md-9">
                        <form:input class="form-control" type="text" placeholder="Mobile" path="phone"/>
                    </div>
                    <div class="col-md-3">
                        <form:errors cssClass="text-danger" path="phone"/>
                    </div>

                    <div class="col-md-12">
                        <label>Email</label>
                    </div>
                    <div class="col-md-9">
                        <form:input class="form-control" type="email" placeholder="Email" path="email"/>
                    </div>
                    <div class="col-md-3">
                        <form:errors cssClass="text-danger" path="email"/>
                    </div>

                    <div class="col-md-12">
                        <label>Address</label>
                    </div>
                    <div class="col-md-9">
                        <form:input class="form-control" type="text" placeholder="Address" path="address"/>
                    </div>
                    <div class="col-md-3">
                        <form:errors cssClass="text-danger" path="address"/>
                    </div>

                    <div class="col-md-12">
                        <label>Username</label>
                    </div>
                    <div class="col-md-9">
                        <form:input class="form-control" type="text" placeholder="Username" path="username"/>
                    </div>
                    <div class="col-md-3">
                        <form:errors cssClass="text-danger" path="username"/>
                    </div>

                    <div class="col-md-12">
                        <label>Password</label>
                    </div>
                    <div class="col-md-9">
                        <form:input class="form-control" type="password" placeholder="Password" path="password"/>
                    </div>
                    <div class="col-md-3">
                        <form:errors cssClass="text-danger" path="password"/>
                    </div>

                    <div class="col-md-12">
                        <label>confirm password</label>
                    </div>
                    <div class="col-md-9">
                        <form:input class="form-control" type="password" placeholder="Confirm Password" path="confirmPassword"/>
                    </div>
                    <div class="col-md-3">
                        <form:errors cssClass="text-danger" path="confirmPassword"/>
                    </div>

                    <c:choose >
                        <c:when test="${type eq 'add'}">
                            <div class="col-md-12">
                                <button class="btn">Add New</button> 
                                <br><br>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div class="col-md-12">
                                <button class="btn">Update</button> 
                                <br><br>
                            </div>
                        </c:otherwise>
                    </c:choose>

                    <c:if test="${type eq 'add'}">
                    </c:if>
                    <c:if test="${type eq 'edit'}">
                    </c:if>
                </form:form>
            </div>
        </div>
    </div>
</div>
</div>
<!-- My Account End -->






<!--=========================================================================-->
<%@ include file="/resources/include-footer.jsp" %> 