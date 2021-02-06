/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import modelo.GestionProductos;
import mx.com.gm.sga.Producto;

/**
 *
 * @author alex_
 */

@WebServlet("/RecuperarProductosAction")
public class RecuperarProductosAction extends HttpServlet {
    private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionProductos gproductos=new GestionProductos();
		List<Producto> producto=gproductos.recuperarProductos();
		//guardamos productos en un atributo de petici�n
		request.setAttribute("producto", producto);
		//trasnferencia de la petici�n
		request.getRequestDispatcher("productos.jsp").forward(request, response);
	}
}
