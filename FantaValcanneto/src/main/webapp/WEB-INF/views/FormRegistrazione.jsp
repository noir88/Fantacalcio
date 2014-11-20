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

<script type="text/javascript"  onload="loaded=4" src="<c:url value="/resources/js/RegistrationFormValidator.js"/>"></script>

    <title>
        Prova
    </title>
</head>
<body>
<body background="<c:url value="/resources/img/sfondochamp.jpg"/>">
<div class="col-lg-8">

		<form class="registerForm form-horizontal col-lg-offset-6 col-lg-6"
			style="margin-top: 15%" action="registraUtente" method="post">

			<div class="well bs-component">
				<fieldset>
					<legend>Benvenuto</legend>
					<div class="form-group">
						<label for="userName" class="col-lg-2 control-label">Username</label>
						<div class="col-xs-9">
							<input type="text" class="form-control" name="userName"
								placeholder="Username">
						</div>
					</div>
					
					<div class="form-group">
						<label for="nome" class="col-lg-2 control-label">Nome</label>
						<div class="col-xs-9">
							<input type="text" class="form-control" name="nome"
								placeholder="Nome">
						</div>
					</div>

					<div class="form-group">
						<label for="cognome" class="col-lg-2 control-label">Cognome</label>
						<div class="col-xs-9">
							<input type="text" class="form-control" name="cognome"
								placeholder="Cognome">
						</div>
					</div>

					<div class="form-group">
						<label for="password" class="col-lg-2 control-label">Password</label>
						<div class="col-xs-9">
							<input type="password" class="form-control" name="password"
								placeholder="Password">
						</div>
					</div>
					
					<div class="form-group">
						<label for="email" class="col-lg-2 control-label">Email</label>
						<div class="col-xs-9">
							<input type="text" class="form-control" name="email"
								placeholder="Email">
						</div>
					</div>


					<div class="form-group">
						<div class="col-lg-10 col-lg-offset-2">
							<button type="submit" class="btn btn-primary"
								style="margin-right: 10px">Registrati</button>

						</div>

					</div>
				</fieldset>

			</div>
		</form>
 
 </div>

</body>



</html>