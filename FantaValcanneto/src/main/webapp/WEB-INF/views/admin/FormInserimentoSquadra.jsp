<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><html>
<head>

<!-- Latest compiled and minified CSS -->
<link  href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet">
<link  href="<c:url value="/resources/css/bootstrapformvalidator.css"/>" rel="stylesheet">
<!-- Latest compiled and minified JavaScript -->
<script type="text/javascript" onload="loaded=1" src="<c:url value="/resources/js/jquery.js"/>"></script>
<script type="text/javascript" onload="loaded=2" src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script type="text/javascript" onload="loaded=3" src="<c:url value="/resources/js//bootstrapvalidator.js"/>"></script>
<script type="text/javascript"  onload="loaded=4" src="<c:url value="/resources/js/RegistrationFormValidator.js"/>"></script>



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
 
 
<form action = "inserisciSquadra" class="registerForm col-xs-4" method="GET">
    <div class="form-group">
        <label>Nome Squadra</label>
        <input type="text" class="form-control" name="nomeSquadra" />
    
    <select class="form-control" name="giocatore">

 <c:forEach items="${utentiSenzaSquadra}" var="users">
    <option><c:out value="${users.value}"/></option>
    </c:forEach>
</select>  
    </div>

    <input type="submit" value="Associa">
</form>
</body>



</html>