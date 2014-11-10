<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><html>
<head>

<!-- Latest compiled and minified CSS -->
<link  href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet">
<link  href="<c:url value="/resources/css/bootstrapformvalidator.css"/>" rel="stylesheet">
<link  href="<c:url value="/resources/css/datepicker.css"/>" rel="stylesheet">
<!-- Latest compiled and minified JavaScript -->
<script type="text/javascript" onload="loaded=1" src="<c:url value="/resources/js/jquery.js"/>"></script>
<script type="text/javascript" onload="loaded=2" src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script type="text/javascript" onload="loaded=3" src="<c:url value="/resources/js//bootstrapvalidator.js"/>"></script>
<script type="text/javascript"  onload="loaded=4" src="<c:url value="/resources/js/RegistrationFormValidator.js"/>"></script>
<script type="text/javascript" onload="loaded=3" src="<c:url value="/resources/js//bootstrap-datepicker.js"/>"></script>


    <title>
        Prova
    </title>
</head>
<body>

 <c:if test="${ empty sessionScope.utentes}">
 <% response.sendRedirect("/fabrizio/"); %>
 </c:if>
 
 <c:if test="${sessionScope.utentes.role != 'admin'}">
 
 <%response.sendRedirect("/fabrizio/"); %>
 </c:if>
 <div class="container">
    <div class="row">
        <div class='col-sm-6'>
            <div class="form-group">
                <input type="text" value="16/02/12" data-date-format="dd/mm/yy" class="datepicker" >
                            </div>
        </div>
        <script type="text/javascript">
        $(document).ready(function() {
            $('.datepicker').datepicker();
        })
        </script>
    </div>
</div>

</body>



</html>