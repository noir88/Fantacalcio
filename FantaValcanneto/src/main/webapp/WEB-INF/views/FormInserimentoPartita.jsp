<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="java.util.List" %>

<html>
<head>

<!-- Latest compiled and minified CSS -->
<link  href="<c:url value="/resources/css/bootstrapTheme.css"/>" rel="stylesheet">
<link  href="<c:url value="/resources/css/datepicker.css"/>" rel="stylesheet">
<!-- Latest compiled and minified JavaScript -->
<%-- <script type="text/javascript" onload="loaded2=2" src="<c:url value="/resources/js/bootstrap.min.js"/>"></script> --%>
<%-- <script type="text/javascript" onload="loaded3=3" src="<c:url value="/resources/js/bootstrap-datepicker.js"/>"></script> --%>

<script type="text/javascript" onload="loaded1=1" src="<c:url value="/resources/js/jquery.js"/>"></script>
<script onload="loaded2=1" src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script onload="loaded3=1" src="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.js"></script>

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



	<div class="col-md-4 col-md-offset-4">
	<h3>Inserimento Partita</h3>
	</div>
	
	<div class="col-md-10 col-md-offset-4">
	
		<form action="inserisciPartita" class="registerForm col-xs-4" method="GET">
			<div class="form-group">
				<label>Giornata Serie A</label> <input type="text" class="form-control"
					name="giornataSerieA" />
			</div>
			<label>Tipo:</label> 
			<select class="form-control" name="tipologia">
				<option>Campionato</option>
				<option>Coppa</option>
			</select>
			<br/>
		<div class="form-group">
		<label>Formazioni Entro</label><div>
                <div class='input-group date' id='datetimepicker1'>
                    <input type='text'class="form-control" />
                    <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span>
                    </span>
                </div>
            </div>
            
        <script type="text/javascript">
            $(document).ready(function () {
                $('#datetimepicker1').datepicker({
                format: 'dd/mm/yyyy'});
            });
        </script>
        </div>
			
			<div class="form-group">
				<label> Alle ore</label> <div>
				<span class = "col-xs-4"><select class="form-control" name="ore">
				<%for(int i=0; i<24; i++){
				%>
				<option><%=i %></option>
				<%
				} %>
			</select> </span>
			
				<span class = "col-xs-4"> <select class="form-control" name="minuti"> 
				<option>00</option>
				<option>30</option>
				</select> </span>
				</div>
				
			</div>
				</br>
				</br>
				
				<!-- Scontro 1 -->
				<div class="form-group">
				<label> Scontro 1 <span class="glyphicon glyphicon-fire" aria-hidden="true"></span></label> <div>
				<span class = "col-xs-6"><select class="form-control" name="squadra1">
				
				<%for(String squadra : (List<String>)request.getAttribute("squadre")){
					
				%>
				<option><%=squadra %></option>
				<%
				} %>
			</select> </span>
			
			<span class = "col-xs-6"><select class="form-control" name="squadra2">
				
				<%for(String squadra : (List<String>)request.getAttribute("squadre")){
					
				%>
				<option><%=squadra %></option>
				<%
				} %>
			</select> </span>
			
			
				</div>
				
			</div>
				</br>
				</br>
				<!-- Scontro 2 -->
				
				
				<div class="form-group">
				<label> Scontro 2 <span class="glyphicon glyphicon-fire" aria-hidden="true"></span></label> <div>
				<span class = "col-xs-6"><select class="form-control" name="squadra3">
				
				<%for(String squadra : (List<String>)request.getAttribute("squadre")){
					
				%>
				<option><%=squadra %></option>
				<%
				} %>
			</select> </span>
			
			<span class = "col-xs-6"><select class="form-control" name="squadra4">
				
				<%for(String squadra : (List<String>)request.getAttribute("squadre")){
					
				%>
				<option><%=squadra %></option>
				<%
				} %>
			</select> </span>
			
			
				</div>
				
			</div>
				
				</br>
				</br>
				
				<!-- Scontro 3 -->
				
				
				<div class="form-group">
				<label> Scontro 3 <span class="glyphicon glyphicon-fire" aria-hidden="true"></span></label> <div>
				<span class = "col-xs-6"><select class="form-control" name="squadra5">
				
				<%for(String squadra : (List<String>)request.getAttribute("squadre")){
					
				%>
				<option><%=squadra %></option>
				<%
				} %>
			</select> </span>
			
			<span class = "col-xs-6"><select class="form-control" name="squadra6">
				
				<%for(String squadra : (List<String>)request.getAttribute("squadre")){
					
				%>
				<option><%=squadra %></option>
				<%
				} %>
			</select> </span>
			
			
				</div>
				
			</div>
				</br>
				</br>
				
				<!-- Scontro 4 -->
				
				
				<div class="form-group">
				<label> Scontro 4 <span class="glyphicon glyphicon-fire" aria-hidden="true"></span></label> <div>
				<span class = "col-xs-6"><select class="form-control" name="squadra7">
				
				<%for(String squadra : (List<String>)request.getAttribute("squadre")){
					
				%>
				<option><%=squadra %></option>
				<%
				} %>
			</select> </span>
			
			<span class = "col-xs-6"><select class="form-control" name="squadra8">
				
				<%for(String squadra : (List<String>)request.getAttribute("squadre")){
					
				%>
				<option><%=squadra %></option>
				<%
				} %>
			</select> </span>
			
			
				</div>
				
			</div>
			
				</br>
				</br>
				
			<div>
			<input type="submit" class="btn btn-primary" value="Salva">
			</div>
		</form>

	</div>
	
</body>



</html>