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


import modelo.GestionClientes;
import mx.com.gm.sga.Cliente;


/**
 *
 * @author aledom
 */
@WebServlet("/RecuperarAction")
public class RecuperarAction extends HttpServlet {
    private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionClientes gclientes=new GestionClientes();
		List<Cliente> cliente=gclientes.recuperarClientes();
		//guardamos contactos en un atributo de petici�n
		request.setAttribute("cliente", cliente);
		//trasnferencia de la petici�n
		request.getRequestDispatcher("clientes.jsp").forward(request, response);
	}
}
