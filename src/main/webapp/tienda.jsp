<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page import="tienda.modelo.CarritoCollections"%>
<%@page import="tienda.modelo.Pelicula"%>
<%@page import="tienda.modelo.Libro"%>
<%@page import="java.util.List"%>
<%@page import="tienda.modelo.Producto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<style>
/* 	td{
	border:solid green 2px
	} 
	tr {
    background-color: #4CAF50;
    color: white;
	}*/
	
	</style>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title style="text-align:center">Tienda online</title>
	</head>
	<body>
<%-- 	<%= session.getAttribute("usuario") %> --%>
		<div style="font-size:10">Bienvenido  ${sessionScope.usuario} <c:url var= "urlSalir" value="salir"/> <a href="${urlSalir}">Cerrar sesión</a>
		</div>
		<div style= ""width: 600 px ; text-align:center>
			<table style= "border : solid green 2px">
				<tr>
					<td>Titulo</td>
					<td>Genero</td>
					<td>Precio</td>
					<td>Año</td>
					<td>Directo/Autor</td>
					<td></td>
				</tr>
				<c:forEach var="p" items="${requestScope.listaProductos }">
					<tr>
						<td><c:out value="${p.titulo }"/></td>
						<td><c:out value="${p.genero }"/></td>
<%-- 						<td><c:out value="${p.precio }"/></td> --%>
						<td><fmt:formatNumber maxFractionDigits="2" currencyCode="$" value="${p.precio}"/></td>
						<td><c:out value="${p.anho }"/></td>
<%-- 						<td><a href="anadirCarrito?productoId=${p.idProducto }">Añadir al Carrito</a></td> --%>
						<c:url var="urlAnadirCarrito" value="anadirCarrito">
							<c:param name="productoId" value = "${p.idProducto}"/>
						</c:url>
						<td> <a href="${urlAnadirCarrito}">Añadir al carrito</a></td>
					</tr>
				</c:forEach>
				<%
					List <Producto> listaProductos =(List<Producto>) request.getAttribute("listaProductos");
					for (Producto p : listaProductos ){
				%>
					<%-- <tr>
						<td><%=p.getTitulo()%></td>
						<td><%=p.getGenero()%></td>
						<td><%=p.getPrecio()%></td>
						<td><%=p.getAnho()%></td>
						<td><%if (p instanceof Libro){%>
							<%= ((Libro)p).getAutor()%>
						<%}else{%>
							<%=((Pelicula)p).getDirector() %>
						<%}%></td>
						<td><a href="anadirCarrito?productoId=<%= p.getidProducto()%>">Añadir al Carrito</a></td>
					</tr>	 --%>
				<%}%>
			</table>
		</div>
	
		<div>
			<%-- <p>CARRITO</p>
			<a href="vaciarCarrito" > Vaciar carrito </a>
			<% List <Producto> productosCarrito = ((CarritoCollections)session.getAttribute("carrito")).getListaProductos();
			double suma=0;
			for (Producto p:productosCarrito) { 
			suma+=p.getPrecio();%>
			<p><%= p.toString()%></p>
			<% } %>
			<p> <%= suma %></p> --%>
			<p>CARRITO</p>
<!-- 			<a href="vaciarCarrito" > Vaciar carrito </a> -->
			<c:url var="urlVaciarCarrito" value="vaciarCarrito"/> <a href="${urlVaciarCarrito}">Vaciar carrito</a> 
			<c:set var="total" value="0"/>
			<c:forEach var="producto" items="${ sessionScope.carrito.listaProductos}">
			<c:set var="total" value="${total+producto.precio}"/>
			<p><c:out value="${producto} }"/></p>
			</c:forEach>
			<p> Importe total: <fmt:formatNumber maxFractionDigits="2" currencyCode="$" value="${total }"/></p>
		</div>
	</body>
</html>