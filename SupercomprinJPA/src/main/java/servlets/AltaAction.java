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
@WebServlet("/AltaAction")
public class AltaAction extends HttpServlet{
    private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre=request.getParameter("nombre");
		String apellidos=request.getParameter("apellidos");
		String dni=request.getParameter("dni");
                String fecha_nac=request.getParameter("fecha_nac");
                String email=request.getParameter("email");
		//creamos un objeto de la capa de lgica de negocio
		//y llamamos al método encargado de hacer el alta
		GestionClientes gclientes=new GestionClientes();
		gclientes.altaCliente(nombre, apellidos, dni, fecha_nac, email);
		request.getRequestDispatcher("menu.html").forward(request, response);
	}
}
