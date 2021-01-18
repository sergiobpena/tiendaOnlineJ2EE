<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
	<div style="align:center">
			<c:url var="urlLogin" value="login"/>
			<form action="${urlLogin}" method="post">
				Login: <input type="text" name="login" maxlength="20" size "20 />
				</br>
				Clave: <input type="password" name="clave" maxlength="20" size "20 />
				</br>
				<input type="submit" value="LOGIN" />
				</br>
				<c:url var="urlRegistro" value="registro.jsp"/>
				<a href="${urlRegistro }">Nuevo cliente</a>
			</form>
		</div>
	
	</body>
</html>