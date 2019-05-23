<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix= "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		<div>
			<c:url var="urlRegistrar" value="registrar"/>
			<form action="${urlRegistrar}" method="get" >
				Login: <input type="text" name="login" maxlength="20" size="20"/>
				<br/>
				Clave: <input type="password" name="clave" maxlength="20" size="20"/>
				<br/>
				Repetir clave: <input type="password" name="clave2" maxlength="20" size="20"/>
				<br/>
				Nombre: <input type="text" name="nombre" maxlength="20" size="20"/>
				<br/>
				Apellidos <input type="text" name="apellidos" maxlength="20" size="20"/>
				<br/>
				Direccion <input type="text" name="direccion" maxlength="20" size="20"/>
				<br/>
				DNI <input type="text" name="dni" maxlength="8" size="8"/>-<input type="text" name="letraDni" maxlength="1" size="1"/>
				<br/>
				Fecha Nacimiento: <input type="date" name="fechaNac"/>
				<br/>
				<input type="submit" value="REGISTRAR"/><input type="reset" value="BORRAR TODO"/>
			</form>
</body>
</html>