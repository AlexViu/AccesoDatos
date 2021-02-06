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

/**
 *
 * @author alex_
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    /**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op=request.getParameter("op");
		String url="";
		switch(op){
			case "doAlta":
				url="AltaAction";
				break;
                        case "doNuevoProducto":
				url="NuevoProductoAction";
				break;
                        case "doNuevoCompra":
				url="NuevoCompraAction";
				break;
			case "doEliminar":
				url="EliminarAction";
				break;
                        case "doEliminarProducto":
				url="EliminarProductoAction";
				break;
			case "doRecuperar":
				url="RecuperarAction";
				break;
                        case "doRecuperarp":
				url="RecuperarProductosAction";
				break;
                        case "doRecuperarCompras":
				url="RecuperarComprasAction";
				break;
                        case "toNuevo":
				url="nuevoCliente.html";
				break;
			case "toMenu":
				url="index.html";
				break;
                        case "toNuevop":
				url="nuevoProducto.html";
				break;
                        case "toNuevoCompra":
				url="nuevoCompra.html";
				break;
			
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
