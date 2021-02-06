<%-- 
    Document   : productos
    Created on : 3 feb. 2021, 18:12:52
    Author     : alex_
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="modelo.GestionProductos,java.util.ArrayList,mx.com.gm.sga.Producto"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestión de Productos</title>
</head>
<body>
	
	<c:set var="productos" value="${requestScope.producto}"/>
	
	<br/><br/><br/>
	
	<c:choose>
	
		<c:when test="${!empty productos}">
	
			<table border="1">
						<tr>
							<th>Nombre</th>
                                                        <th>Precio</th>
                                                        <th>Puntos</th>
							<th></th>
						</tr>
						
						<c:forEach var="pro" items="${producto}">
							<tr><td>${pro.nombre}</td>
							<td>${pro.precio}</td>
							<td>${pro.puntos}</td>
							<td><a href="Controller?op=doEliminarProducto&id=${pro.id}">Eliminar</a></td></tr>
						
						
						</c:forEach>
						
						
						
			</table>
		</c:when>
		<c:otherwise>
			<h1>No hay productos</h1>
		</c:otherwise>
	</c:choose>
	<br/>
	<br/>
	<a href="Controller?op=toMenu">Menu</a>
</body>
</html>