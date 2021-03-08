

<%@ include file="/resources/include-header.jsp" %>     
<!--=========================================================================-->




<!--=======================================================================-->
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


<!--============FORM LOGIN ===========================================================-->
<!-- My Account Start -->
<div class="my-account">
    <div class="container-fluid">
        <div class="col-md-6" > 
            <div class="row">
                <form class="row" action="<c:url value='/j_spring_security_check' />" method='POST'>
                    <div class="col-md-12" style="color: red;">
                        <p style="color: red;">

                            <span>${msg}</span>

                            <span>${error}</span>

                        </p>
                    </div>
                    <div class="col-md-12">
                        <label>Username</label>
                    </div>
                    <div class="col-md-12">
                        <input class="form-control" type="text" name="username" value="dungdeptrai" placeholder="Username">
                    </div>
                    <div class="col-md-12">
                        <label>Password</label>
                    </div>
                    <div class="col-md-12">
                        <input class="form-control" type="text" name="password" value="123" placeholder="Password">
                    </div>
                    <div class="col-md-12">
                        <div class="custom-control custom-checkbox" >
                            <input type="checkbox" class="custom-control-input" id="newaccount" >
                            <label class="custom-control-label" for="newaccount">Keep me signed in</label>
                        </div>
                    </div>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                    <div class="col-md-12">
                        <button class="btn">Login</button>
                    </div>
                </form> 
            </div>
        </div>
    </div>
</div>
</div>
<!-- My Account End -->


<!-- Footer Start -->
<div class="footer">
    <div class="container-fluid">
        <div class="row">


            <div class="col-lg-3 col-md-6">
                <div class="footer-widget">
                    <h2>Get in Touch</h2>
                    <div class="contact-info">
                        <p><i class="fa fa-map-marker"></i>Quang Trung, Da Nang, Viet Nam</p>
                        <p><i class="fa fa-envelope"></i>e-CommerceTeam@gmail.com</p>
                        <p><i class="fa fa-phone"></i>+0905999999< /p>
                    </div>
                </div>
            </div>

            <div class="col-lg-3 col-md-6">
                <div class="footer-widget">
                    <h2>Follow Us</h2>
                    <div class="contact-info">
                        <div class="social">
                            <a href=""><i class="fab fa-twitter"></i></a>
                            <a href=""><i class="fab fa-facebook-f"></i></a>
                            <a href=""><i class="fab fa-linkedin-in"></i></a>
                            <a href=""><i class="fab fa-instagram"></i></a>
                            <a href=""><i class="fab fa-youtube"></i></a>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-lg-3 col-md-6">
                <div class="footer-widget">
                    <h2>Company Info</h2>
                    <ul>
                        <li><a href="#">About Us</a></li>
                        <li><a href="#">Privacy Policy</a></li>
                        <li><a href="#">Terms & Condition</a></li>
                    </ul>
                </div>
            </div>

            <div class="col-lg-3 col-md-6">
                <div class="footer-widget">
                    <h2>Purchase Info</h2>
                    <ul>
                        <li><a href="#">Payment Policy</a></li>
                        <li><a href="#">Shipping Policy</a></li>
                        <li><a href="#">Return Policy</a></li>
                    </ul>
                </div>
            </div>
        </div>

        <div class="row payment align-items-center">
            <div class="col-md-6">
                <div class="payment-method">
                    <h2>We Accept:</h2>
                    <img src="<c:url value="/resources/img/payment-method.png"/>" alt="Payment Method" />
                </div>
            </div>
            <div class="col-md-6">
                <div class="payment-security">
                    <h2>Secured By:</h2>
                    <img src="<c:url value="/resources/img/godaddy.svg"/>" alt="Payment Security" />
                    <img src="<c:url value="/resources/img/norton.svg"/>" alt="Payment Security" />
                    <img src="<c:url value="/resources/img/ssl.svg"/>" alt="Payment Security" />
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Footer End -->




<!--=========================================================================-->
<%@ include file="/resources/include-footer.jsp" %> 