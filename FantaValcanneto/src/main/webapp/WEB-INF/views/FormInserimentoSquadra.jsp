<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page
	import="java.util.List, model.Messaggio, com.fabrizio.fantavalcanneto.persistence.GestoreMessaggi, com.fabrizio.fantavalcanneto.persistence.UserManager"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Latest compiled and minified CSS -->
<link href="<c:url value="/resources/css/bootstrapTheme.css"/>"
	rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrapformvalidator.css"/>"
	rel="stylesheet">

	
<!-- Latest compiled and minified JavaScript -->
<script type="text/javascript" onload="loaded=1"
	src="<c:url value="/resources/js/jquery.js"/>"></script>
<script type="text/javascript" onload="loaded=2"
	src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script type="text/javascript" onload="loaded=3"
	src="<c:url value="/resources/js//bootstrapvalidator.js"/>"></script>
<script type="text/javascript" onload="loaded=4"
	src="<c:url value="/resources/js/calciatoriRegisterFormValidator.js"/>"></script>
<title>Insert title here</title>
</head>
<body>

	<c:if test="${ empty sessionScope.utentes}">
		<% response.sendRedirect("/fabrizio/"); %>
	</c:if>

	<c:if test="${sessionScope.utentes.role != 'admin'}">
		<%response.sendRedirect("/fabrizio/home"); %>
	</c:if>

<%String divClassMessage = "";
	String glipClass="";%>
	
<c:if test="${! empty sessionScope.inserimentoSquadra}">
	
	<%if (request.getSession().getAttribute("inserimentoSquadra").equals("Squadra Inserita Correttamente.")){
	 divClassMessage = "class='alert alert-success' style='margin-top:10px' role='alert'";
	glipClass = "glyphicon-floppy-saved";
		}	
	else {
		divClassMessage = " class='alert alert-danger' style='margin-top:10px;' role='alert'";
		 glipClass = "glyphicon-floppy-remove";
	}
		%>
		
		</c:if>
	<nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Brand</a>
		</div>


		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Link</a></li>



				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> <%if (null == request.getSession().getAttribute("squadra")) {
        	  %> no team <%
          } else { %> ${sessionScope.squadra.nomeSquadra }<%}; %> <span
						class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="inserisciFormazione">formaz</a></li>
						<li><a href="admin/FormInserimentoScontro">scontro</a></li>
						<li><a href="#">Something else here</a></li>
						<li class="divider"></li>
						<li><a href="#">Separated link</a></li>
						<li class="divider"></li>
						<li><a href="admin/CreaSquadra">Creazione Squadra</a></li>
					</ul></li>



				<c:if test="${sessionScope.utentes.role == 'admin'}">

					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"> Admin <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="admin/FormInserimentoScontro">scontro</a></li>
							<li><a href="admin/CreaSquadra">Creazione Squadra</a></li>
							<li><a href="admin/FormInserimentoCalciatore">Inserimento
									Calciatori</a></li>
						</ul></li>

				</c:if>
			</ul>

			<form class="navbar-form navbar-left" role="search">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Search">
				</div>
				<button type="submit" class="btn btn-default">Submit</button>
			</form>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">Link</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">Benvenuto ${sessionScope.utentes.nome} <span
						class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="logout">Esci</a></li>
					</ul></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	</nav>




	<div class="col-md-4 col-md-offset-4">
	<h3>Inserimento Squadra</h3>
	</div>
	
	<div class="col-md-8 col-md-offset-4">
	
		<form action="inserisciSquadra" class="registerForm col-xs-4"
			method="GET">
			<div class="form-group">
				<label>Nome</label> <input type="text" class="form-control"
					name="nomeSquadra" />
			</div>
			<label>Giocatori Associabili</label> 
			<select class="form-control" name="giocatore">

 <c:forEach items="${utentiSenzaSquadra}" var="users">
    <option><c:out value="${users.value}"/></option>
    </c:forEach>
    </select>
			<br/>
			<div>
			
			<input type="submit" class="btn btn-primary" value="Salva">
			<% if(request.getSession().getAttribute("inserimentoSquadra") != null){ 
			%><div <%=divClassMessage%>> <span class="glyphicon <%=glipClass %>" style="margin-right:5px" aria-hidden="true"></span>
			${sessionScope.inserimentoSquadra}</div> <%; 
			session.removeAttribute("inserimentoSquadra"); }; %> </div>
		</form>

	</div>

</body>



</html>