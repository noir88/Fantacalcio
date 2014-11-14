<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link href="<c:url value="/resources/css/bootstrapTheme.css"/>"
	rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrapformvalidator.css"/>"
	rel="stylesheet">
<link href="<c:url value="/resources/css/fanta.css"/>" rel="stylesheet">
<!-- Latest compiled and minified JavaScript -->
<script type="text/javascript" onload="loaded=1"
	src="<c:url value="/resources/js/jquery.js"/>"></script>
<script type="text/javascript" onload="loaded=2"
	src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script type="text/javascript" onload="loaded=3"
	src="<c:url value="/resources/js//bootstrapvalidator.js"/>"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
</head>
<body background="<c:url value="/resources/img/sfondochamp.jpg"/>">



	<!-- <form action="login" method="post"> -->
	<!-- <input type="text" name="userName"><br> -->
	<!-- <input type="text" name="password"><br> -->
	<!-- <input type="submit" value="Login"> -->
	<!-- </form> -->

	<div class="col-lg-8">

		<form class="form-horizontal col-lg-offset-6 col-lg-6"
			style="margin-top: 15%" action="login" method="post">

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

					<%
						if (request.getAttribute("loginError") == null) {
					%>
					<div class="form-group">
						<label for="password" class="col-lg-2 control-label">Password</label>
						<div class="col-xs-9">
							<input type="password" class="form-control" name="password"
								placeholder="Password">
						</div>
					</div>
					<%
						} else {
							request.removeAttribute("loginError");
					%>




					<div class="form-group has-error">
						<label class="control-label col-lg-2" for="inputError">Errore</label>
						<div class="col-xs-9">
							<input type="text" class="form-control" name="password">
						</div>
					</div>

					<%
						}
					%>


					<div class="form-group">
						<div class="col-lg-10 col-lg-offset-2">
							<button type="submit" class="btn btn-primary"
								style="margin-right: 10px">Login</button>
							<h6 style="display: inline">
								<a href="FormRegistrazione">Oppure registrati qui.</a>
							</h6>


						</div>

					</div>
				</fieldset>

			</div>
		</form>
	</div>


</body>
</html>


