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

import modelo.GestionClientes;

/**
 *
 * @author alex_
 */

@WebServlet("/AnyadirSaldoAction")
public class AnyadirSaldoAction extends HttpServlet {
     private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ido=Integer.parseInt(request.getParameter("id"));
                int saldo=Integer.parseInt(request.getParameter("saldo"));
		GestionClientes gclientes=new GestionClientes();
		gclientes.saldoCliente(ido, saldo);
		request.getRequestDispatcher("index.html").forward(request, response);
	}
}
