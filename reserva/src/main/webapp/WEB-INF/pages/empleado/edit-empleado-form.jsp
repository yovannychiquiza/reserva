<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Editar empleado</title>
</head>
<body>
	<div class="container">

		<jsp:include page="../menu.jsp" />

		<p>${message}</p>
		<form:form method="POST" commandName="empleado"
			action="${pageContext.request.contextPath}/empleado/edit/${empleado.id}.html">

			<div class="det-cuadro-gris-a">Editar empleado</div>

			<div id="dis-contenido" style="width: 100%">
				<div class="det-contenido-1a">

					<table>
						<tbody>
							<tr>
								<td>Identificacion:</td>
								<td><form:input path="identificacion" /></td>
							</tr>
							<tr>
								<td>Nombre:</td>
								<td><form:input path="nombre" /></td>
							</tr>
							<tr>
								<td>Apellido:</td>
								<td><form:input path="apellido" /></td>
							</tr>
							<tr>
								<td>Usuario:</td>
								<td><form:input path="usuario" /></td>
							</tr>
							<tr>
								<td>Contraseņa:</td>
								<td><form:input path="contrasena" /></td>
							</tr>
							
							<tr>
								<td><input type="submit" value="Guardar" /></td>
								<td></td>
							</tr>
						</tbody>
					</table>

				</div>
			</div>
		</form:form>

	</div>
</body>
</html>