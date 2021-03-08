

<%@ include file="/resources/include-header.jsp" %>     
<!--=========================================================================-->




<div class="update-product">
    <div class="container-fluid"> 
        <form:form action="save"  method="post" modelAttribute="productType">
            <div class="row">
                <div class="col-lg-12">
                    <div class="update-product-inner">
                        <div class="billing-address">
                            <h2>Add product</h2>
                            <form:hidden path="id" />
                            <div class="col-md-12">
                                <label for="productName" class="col-md-3 control-label">Product Name</label>
                                <div >
                                    <form:input path="productName" cssClass="form-control" />
                                </div>
                            </div>
                            <div class="col-md-12">
                                <label for="unitPrice" class="col-md-3 control-label">Unit Price</label>
                                <div >
                                    <form:input path="unitPrice" cssClass="form-control" />
                                </div>
                            </div>

                            <div class="col-md-12">
                                <label for="quantityInStore" class="col-md-3 control-label">Quantity</label>
                                <div>
                                    <form:input path="quantityInStore" cssClass="form-control" />
                                </div>
                            </div>
                            <div class="col-md-6">
                                <label for="manufature" class="col-md-3 control-label">Manufacture</label>
                                <form:select class="custom-select" path="manufactureId" style="color:black;">
                                    <c:forEach items="${manufacturesList}" var="m">
                                        <c:choose>
                                            <c:when test="${m.id eq products.manufacture.id}">
                                                <form:option value="${m.id}" selected="true">${m.manufactureName}</form:option>
                                            </c:when>
                                            <c:otherwise>
                                                <form:option value="${m.id}"> ${m.manufactureName}</form:option>
                                            </c:otherwise>
                                        </c:choose> 
                                    </c:forEach>
                                </form:select>
                            </div>
                            <div class="col-md-6" >
                                <label for="types" class="col-md-3 control-label">Type</label>
                                <form:select class="custom-select" path="typesId" style="color:black;">
                                    <c:forEach items="${typesList}" var="t">
                                        <c:choose>
                                            <c:when test="${t.id eq products.types.id}">
                                                <form:option value="${t.id}" selected="true">${t.typeName}</form:option>
                                            </c:when>
                                            <c:otherwise>
                                                <form:option value="${t.id}"> ${t.typeName}</form:option>
                                            </c:otherwise>
                                        </c:choose> 
                                    </c:forEach>
                                </form:select>
                            </div>

                            <div class="col-md-12">
                                <label for="decription" class="col-md-3 control-label">Description</label>
                                <div >
                                    <form:input path="decription" cssClass="form-control" />
                                </div>
                            </div>
                            <div class="col-md-12">

                                <label for="updateDate" class="col-md-3 control-label">Update Date</label>
                                <div>
                                    <form:input type="date" path="updateDate" cssClass="form-control" />
                                </div>
                            </div>
                            <div class="col-md-12">
                                <label for="warranty" class="col-md-3 control-label">Warranty</label>
                                <div >
                                    <form:input path="warranty" cssClass="form-control" />
                                </div>
                            </div>
                            <div class="col-md-12">
                                <label for="image" class="col-md-3 control-label">Upload image</label><br>
                                
                                <input type="file" id="files" name="files" multiple><br><br>
                            </div>
                            <div class="form-group">

                                <div class="header-slider-caption">
                                    <form:button class="btn">Add product</form:button>
                                    </div>
                                </div>
                        </form:form>
                    </div>
                </div>



                <!--=========================================================================-->
                <%@ include file="/resources/include-footer.jsp" %> 
