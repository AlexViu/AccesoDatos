<%-- 
    Document   : compras
    Created on : 6 feb. 2021, 1:34:14
    Author     : alex_
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="modelo.GestionCompras,java.util.ArrayList,mx.com.gm.sga.Compra"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestión de Compras</title>
</head>
<body>
	
	<c:set var="compras" value="${requestScope.compra}"/>
	
	<br/><br/><br/>
	
	<c:choose>
	
		<c:when test="${!empty compras}">
	
			<table border="1">
						<tr>
							<th>Id cliente</th>
                                                        <th>Id producto</th>
                                                        <th>importe</th>
							<th>fecha</th>
                                                        <th>puntos</th>
						</tr>
						
						<c:forEach var="com" items="${compra}">
							<tr><td>${com.id_cliente}</td>
							<td>${com.id_producto}</td>
							<td>${com.importe}</td>
                                                        <td>${com.fecha}</td>
                                                        <td>${com.puntos}</td>
							</tr>
						
						
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
