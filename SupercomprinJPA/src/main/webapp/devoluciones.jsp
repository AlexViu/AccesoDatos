<%-- 
    Document   : devoluciones
    Created on : 7 feb. 2021, 0:16:16
    Author     : alex_
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="modelo.GestionDevolucion,java.util.ArrayList,mx.com.gm.sga.Devolucion"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestión de Devoluciones</title>
</head>
<body>
	
	<c:set var="devoluciones" value="${requestScope.devolucion}"/>
	
	<br/><br/><br/>
	
	<c:choose>
	
		<c:when test="${!empty devoluciones}">
	
			<table border="1">
						<tr>
                                                        <th>Id producto</th>
							<th>Id cliente</th>
                                                        <th>importe</th>
							<th>fecha</th>
                                                        <th>puntos</th>
						</tr>
						
						<c:forEach var="dev" items="${devolucion}">
							<tr><td>${dev.id_producto}</td>
                                                        <td>${dev.id_cliente}</td>
							<td>${dev.importe}</td>
                                                        <td>${dev.fecha}</td>
                                                        <td>${dev.puntos}</td>
							</tr>
						
						
						</c:forEach>
						
						
						
			</table>
		</c:when>
		<c:otherwise>
			<h1>No hay devoluciones</h1>
		</c:otherwise>
	</c:choose>
	<br/>
	<br/>
	<a href="Controller?op=toMenu">Menu</a>
</body>
</html>