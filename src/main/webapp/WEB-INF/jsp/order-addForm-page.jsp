

<%@ include file="/resources/include-header.jsp" %>     
<!--=========================================================================-->



<div class="container">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <h2 class="text-center">Add New Orders</h2>

                <div class="col-md-12">

                    <form:form action="save" cssClass="form-horizontal" method="post" modelAttribute="ordersType">

                        <!-- need to associate this data with customer id -->
                        <form:hidden path="id" />

                        <div class="col-md-12">
                            <label for="name" class="col-md-3 control-label">Name</label>
                            <div class="col-md-9">
                                <form:input path="fullName" cssClass="form-control" />
                            </div>
                        </div>

                        <div class="col-md-12">
                            <label for="receiveAddress" class="col-md-3 control-label">Address</label>
                            <div class="col-md-9">
                                <form:input path="address" cssClass="form-control" />
                            </div>
                        </div>

                        <div class="col-md-12">
                            <label for="phone" class="col-md-3 control-label">Phone</label>
                            <div class="col-md-9">
                                <form:input path="phone" cssClass="form-control" />
                            </div>
                        </div>

                        <div class="col-md-12">
                            <label for="createDate" class="col-md-3 control-label">Email</label>
                            <div class="col-md-9">
                                <form:input path="email" cssClass="form-control" />
                            </div>
                        </div>


                        <div class="col-md-12">
                            <label for="cost" class="col-md-3 control-label">Cost</label>
                            <div class="col-md-9">
                                <form:input path="cost" cssClass="form-control" />
                            </div>
                        </div>

                        <div class="col-md-12">
                            <label for="discount" class="col-md-3 control-label">Discount</label>
                            <div class="col-md-9">
                                <form:input path="discount" cssClass="form-control" />
                            </div>
                        </div>

                        <div class="col-md-12">
                            <label for="total" class="col-md-3 control-label">Total</label>
                            <div class="col-md-9">
                                <form:input path="total" cssClass="form-control" />
                            </div>
                        </div>

                        <div class="col-md-12 ">
                            <label class="col-md-3">Shipping</label>
                        </div>
                        <div class="col-md-12 ">
                            <div class="col-md-9 ">
                                <form:select path="shippingId" class="custom-select">
                                    <c:forEach items="${shippingList}" var="s">
                                        <c:choose>
                                            <c:when test="${s.id eq orders.shipping.id}">
                                                <form:option value="${s.id}" selected="true">${s.shippingName}</form:option>
                                            </c:when>
                                            <c:otherwise>
                                                <form:option value="${s.id}">${s.shippingName}</form:option>
                                            </c:otherwise>
                                        </c:choose> 
                                    </c:forEach>
                                </form:select>
                            </div>
                        </div>
                        <div class="col-md-12 ">
                            <label class="col-md-3">Promotion</label>
                        </div>
                        <div class="col-md-12 ">
                            <div class="col-md-9 ">
                                <form:select path="promotionId" class="custom-select">
                                    <c:forEach items="${promotionList}" var="p">
                                        <c:choose >
                                            <c:when test="${p.id eq orders.promotion.id}">
                                                <form:option value="${p.id}" selected="true">${p.name}</form:option>
                                            </c:when>
                                            <c:otherwise>
                                                <form:option value="${p.id}">${p.name}</form:option>
                                            </c:otherwise>
                                        </c:choose> 
                                    </c:forEach>
                                </form:select>
                            </div>
                        </div>

                        <div class="col-md-12 ">
                            <label class="col-md-3">Users</label>
                        </div>

                        <div class="col-md-12 ">
                            <div class="col-md-9 ">
                                <form:select path="usersId" class="custom-select">
                                    <c:forEach items="${usersList}" var="u">
                                        <c:choose>
                                            <c:when test="${u.id eq orders.users.id}">
                                                <form:option value="${u.id}" selected="true">${u.fullName}</form:option>
                                            </c:when>
                                            <c:otherwise>
                                                <form:option value="${u.id}">${u.fullName}</form:option>
                                            </c:otherwise>
                                        </c:choose> 
                                    </c:forEach>
                                </form:select>
                            </div>
                        </div><br/>
                        

                        <div class="col-md-12 ">
                            <label class="col-md-3">Order Status</label>
                        </div>
                        <div class="col-md-12 ">
                            <div class="col-md-9 ">
                                <form:select path="ordersStatus" class="custom-select">
                                    <c:forEach items="${ordersStatusList}" var="o">
                                        <form:option value="${o}">${o}</form:option>
                                    </c:forEach>
                                </form:select>
                            </div>
                        </div>

                        <div class="col-md-12 row">
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <form:button class="btn btn-primary">Submit</form:button>
                            </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>






<!--=========================================================================-->
<%@ include file="/resources/include-footer.jsp" %> 