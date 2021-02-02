<%-- 
    Document   : clientes
    Created on : 2 feb. 2021, 9:21:48
    Author     : aledom
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="modelo.GestionClientes,java.util.ArrayList,mx.com.gm.sga.Cliente"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestión de Clientes</title>
</head>
<body>
	
	<c:set var="clientes" value="${requestScope.cliente}"/>
	
	<br/><br/><br/>
	
	<c:choose>
	
		<c:when test="${!empty clientes}">
	
			<table border="1">
						<tr>
							<th>Nombre</th>
                                                        <th>Apellidos</th>
                                                        <th>dni</th>
                                                        <th>Fecha Nacimiento</th>
							<th>Email </th>
							<th>Puntos</th>
                                                        <th>Saldo</th>
							<th></th>
						</tr>
						
						<c:forEach var="cli" items="${cliente}">
							<tr><td>${cli.nombre}</td>
							<td>${cli.apellidos}</td>
							<td>${cli.dni}</td>
                                                        <td>${cli.fecha_nac}</td>
                                                        <td>${cli.email}</td>
                                                        <td>${cli.puntos}</td>
                                                        <td>${cli.saldo}</td>
							<td><a href="Controller?op=doEliminar&id=${cli.id}">Eliminar</a></td></tr>
						
						
						</c:forEach>
						
						
						
			</table>
		</c:when>
		<c:otherwise>
			<h1>No hay clientes</h1>
		</c:otherwise>
	</c:choose>
	<br/>
	<br/>
	<a href="Controller?op=toMenu">Menu</a>
</body>
</html>
