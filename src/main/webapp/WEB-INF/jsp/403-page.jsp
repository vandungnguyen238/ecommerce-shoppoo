

<%@ include file="/resources/include-header.jsp" %>     
<!--=========================================================================-->


<div class="container-fluid" style="min-height: 270px;">
    <h1>&nbsp;</h1>
    <h1>HTTP Status 403 - Access is denied</h1>


    <c:choose>
        <c:when test="${empty username}">
            <h2>You do not have permission to access this page!</h2>
        </c:when>
        <c:otherwise>
            <h2>Username : ${username} <br/>
                You do not have permission to access this page!
            </h2>
        </c:otherwise>
    </c:choose>

</div>



<!--=========================================================================-->
<%@ include file="/resources/include-footer.jsp" %> 