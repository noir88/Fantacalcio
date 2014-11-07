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
<form action = "inserisciSquadra" class="registerForm col-xs-4" method="post">
    <div class="form-group">
        <label>Nome Squadra</label>
        <input type="text" class="form-control" name="nomeSquadra" />
    </div>
    
    
    <div class="dropdown">
  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
    Dropdown
    <span class="caret"></span>
  </button>
  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
  
 <c:forEach items="${utentiSenzaSquadra}" var="users">
    <li role="presentation"><a role="menuitem" tabindex="-1" href="#"><c:out value="${users.value}"/></a></li>
    </c:forEach>
  </ul>
</div>
    
<!-- <label>cognome</label> -->
<!--         <input type="text" class="form-control" name="nome" /> -->
<!--     </div> -->
<!--     <label>cognome</label> -->
<!--         <input type="text" class="form-control" name="cognome" /> -->
<!--     </div> -->
<!--     <label>password</label> -->
<!--         <input type="text" class="form-control" name="password" /> -->
<!--     </div> -->

<!--     <div class="form-group"> -->
<!--         <label>Email address</label> -->
<!--         <input type="text" class="form-control" name="email" /> -->
<!--     </div> -->
    <input type="submit" value="Registra">
</form>
</body>



</html>