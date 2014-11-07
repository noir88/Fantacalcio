<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@ page import="model.User"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Benvenuto ${sessionScope.utentes.userName} 
</h1>
<a href="CreaSquadra">crea</a>

<P>  The time on the server is . </P>
</body>
</html>
