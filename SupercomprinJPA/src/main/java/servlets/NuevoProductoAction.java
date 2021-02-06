/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.GestionProductos;

/**
 *
 * @author alex_
 */
@WebServlet("/NuevoProductoAction")
public class NuevoProductoAction extends HttpServlet {
    private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre=request.getParameter("nombre");
		int precio=Integer.parseInt(request.getParameter("precio"));
		int puntos=Integer.parseInt(request.getParameter("puntos"));
		//creamos un objeto de la capa de lgica de negocio
		//y llamamos al método encargado de hacer el alta
		GestionProductos gproductos=new GestionProductos();
		gproductos.nuevoProducto(nombre, precio, puntos);
		request.getRequestDispatcher("index.html").forward(request, response);
	}
}
