/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import datos.Conexion;
import datos.ClienteDAO;
import domain.Cliente;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author aledom
 */
public class Test {
    public static void main(String[] args) throws SQLException {
        ClienteDAO clienteDao = new ClienteDAO();
        List<Cliente> listaClientes = clienteDao.seleccionar();
        
        
        listaClientes.forEach(clientes -> {
            System.out.println("Clientes = " + clientes);
        });
    
    }
}
