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


import modelo.GestionCompras;
import mx.com.gm.sga.Compra;

/**
 *
 * @author alex_
 */

@WebServlet("/RecuperarComprasAction")
public class RecuperarComprasAction extends HttpServlet {
     private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionCompras gcompras=new GestionCompras();
		List<Compra> compra=gcompras.recuperarCompras();
		//guardamos productos en un atributo de petici�n
		request.setAttribute("compra", compra);
		//trasnferencia de la petici�n
		request.getRequestDispatcher("compras.jsp").forward(request, response);
	}
}
