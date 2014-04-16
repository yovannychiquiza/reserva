<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Agregar solicitud</title>
</head>
<body>
<jsp:include page="../menu.jsp"/>	

<script>
  $(function() {
    $( ".datepicker" ).datepicker();
  });
  </script>
<h1>Agregar solicitud</h1>
<p>Aqui puede Agregar un nuevo solicitud.</p>
<form:form method="POST" commandName="solicitud" action="${pageContext.request.contextPath}/solicitud/add.html">
<table>
<tbody>
	<tr>
		<td>Ciudad Origen:</td>
		<td><form:select path="ciudadOrigen_Id.Id" items="${listaCiudades}" /></td>				
	</tr>
	<tr>
		<td>Ciudad Destino:</td>		
		<td><form:select path="ciudadDestino_Id.Id" items="${listaCiudades}" /></td>		
	</tr>
	<tr>
		<td>Fecha Salida:</td>
		<td><form:input path="fechaSalida" class="datepicker"/></td>
	</tr>
	

	<tr>
		<td>Fecha Regreso:</td>
		<td><form:input path="fechaRegreso" class="datepicker"/></td>
	</tr>
	
	<tr>
		<td><input type="submit" value="Guardar" /></td>
		<td></td>
	</tr>
</tbody>
</table>
</form:form>

<p><a href="${pageContext.request.contextPath}/solicitud/list.html">Indice</a></p>
</body>
</html>