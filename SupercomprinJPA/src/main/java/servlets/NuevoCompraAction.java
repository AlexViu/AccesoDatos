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

import modelo.GestionCompras;
import mx.com.gm.sga.Cliente;
/**
 *
 * @author alex_
 */

@WebServlet("/NuevoCompraAction")
public class NuevoCompraAction extends HttpServlet {
    private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_cliente=Integer.parseInt(request.getParameter("id_cliente"));
		int id_producto=Integer.parseInt(request.getParameter("id_producto"));
                int importe=Integer.parseInt(request.getParameter("importe"));
                String fecha=request.getParameter("fecha");
                int puntos=Integer.parseInt(request.getParameter("puntos"));

		GestionCompras gcompras=new GestionCompras();
                Cliente cliente = new Cliente(id_cliente);
		gcompras.nuevoCompra(cliente , id_producto, importe, fecha, puntos);
		request.getRequestDispatcher("index.html").forward(request, response);
	}
}
