

<%@ include file="/resources/include-header.jsp" %>     
<!--=========================================================================-->



<!-- Breadcrumb Start -->
<div class="breadcrumb-wrap">
    <div class="container-fluid">
        <ul class="breadcrumb">
            <li class="breadcrumb-item">
                <a href="<c:url value="/home"/>">Home</a>
            </li>
            <li class="breadcrumb-item active">
                <a href="<c:url value="/login"/>">Login</a>
            </li>
            <li class="breadcrumb-item active">
                <a href="<c:url value="/register"/>">Register</a>
            </li>
        </ul>
    </div>
</div>
<!-- Breadcrumb End -->


<!--============FORM REGISTER ===========================================================-->
<!-- My Account Start -->
<div class="my-account">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <form:form class="row" action="process" method="post" modelAttribute="users">
                    <p class="col-md-12" style="color: red;">&nbsp; ${message}</p>
                    
                    <div class="col-md-9">
                        <form:input class="form-control" type="text" placeholder="First Name" path="firstName"/>
                    </div>
                    <div class="col-md-3">
                        <form:errors cssClass="text-danger" path="firstName"/>
                    </div>
                    
                    <div class="col-md-9">
                        <form:input class="form-control" type="text" placeholder="Last Name" path="lastName"/>
                    </div>
                    <div class="col-md-3">
                        <form:errors cssClass="text-danger" path="lastName"/>
                    </div>
                    
                    <div class="col-md-9">
                        <form:input class="form-control" type="text" placeholder="Mobile" path="phone"/>
                    </div>
                    <div class="col-md-3">
                        <form:errors cssClass="text-danger" path="phone"/>
                    </div>
                    
                    <div class="col-md-9">
                        <form:input class="form-control" type="text" placeholder="Email" path="email"/>
                    </div>
                    <div class="col-md-3">
                        <form:errors cssClass="text-danger" path="email"/>
                    </div>
                    
                    <div class="col-md-9">
                        <form:input class="form-control" type="text" placeholder="Address" path="address"/>
                    </div>
                    <div class="col-md-3">
                        <form:errors cssClass="text-danger" path="address"/>
                    </div>
                    
                    <div class="col-md-9">
                        <form:input class="form-control" type="text" placeholder="Username" path="username"/>
                    </div>
                    <div class="col-md-3">
                        <form:errors cssClass="text-danger" path="username"/>
                    </div>
                    
                    <div class="col-md-9">
                        <form:input class="form-control" type="password" placeholder="Password" path="password"/>
                    </div>
                    <div class="col-md-3">
                        <form:errors cssClass="text-danger" path="password"/>
                    </div>
                    
                    <div class="col-md-9">
                        <form:input class="form-control" type="password" placeholder="Confirm Password" path="confirmPassword"/>
                    </div>
                    <div class="col-md-3">
                        <form:errors cssClass="text-danger" path="confirmPassword"/>
                    </div>
                    
                    <div class="col-md-12">
                        <button class="btn">Register</button>
                        <br><br>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
<!-- My Account End -->




<!--=========================================================================-->
<%@ include file="/resources/include-footer.jsp" %> 