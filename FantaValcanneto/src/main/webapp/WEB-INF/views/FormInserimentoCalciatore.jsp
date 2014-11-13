<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><html>
<head>

<!-- Latest compiled and minified CSS -->
<link  href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet">
<link  href="<c:url value="/resources/css/bootstrapformvalidator.css"/>" rel="stylesheet">
<!-- Latest compiled and minified JavaScript -->
<script type="text/javascript" onload="loaded=1" src="<c:url value="/resources/js/jquery.js"/>"></script>
<script type="text/javascript" onload="loaded=2" src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script type="text/javascript" onload="loaded=3" src="<c:url value="/resources/js//bootstrapvalidator.js"/>"></script>
<script type="text/javascript"  onload="loaded=5" src="<c:url value="/resources/js/calciatoriRegisterFormValidator.js"/>"></script>

    <title>
        Prova
    </title>
</head>
<body>


 <c:if test="${! empty sessionScope.giocatoreInserito}">
  ${sessionScope.giocatoreInserito} 
  <% session.removeAttribute("giocatoreInserito"); %>
 </c:if>

<form action = "registraCalciatore" class="registerForm col-xs-4" method="post">
    <div class="form-group">
        <label>Nome</label>
        <input type="text" class="form-control" name="nome" />
    </div>

<select class="form-control" name="ruolo">
<option> Portiere</option>
<option> Difensore</option>
<option> Centrocampista</option>
<option> Attaccante</option>
</select>

<div class="form-group">
        <label>Squadra Reale</label>
        <input type="text" class="form-control" name="squadraReale" />
    </div>

    <input type="submit" value="Salva">
</form>
</body>



</html>