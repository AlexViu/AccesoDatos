/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import datos.Conexion;
import datos.ClienteDAO;
import datos.CompraDAO;
import datos.DevolucionDAO;
import domain.Cliente;
import domain.Compra;
import domain.Devolucion;
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
        CompraDAO compraDao = new CompraDAO();
        DevolucionDAO devolucionDao = new DevolucionDAO();
        Connection conexion = Conexion.getConnection();
        
        try{
            List<Cliente> listaClientes = clienteDao.seleccionar();


            //inisertar
            //Cliente clienteNuevo = new Cliente("juan", "Fernandez", "22222222I", "1990-11-04", "juan@gmail.com", 0, 0);
            //clienteDao.insertar(clienteNuevo);

            //Eliminar
            //Cliente clienteDelete =new Cliente(2);
            //clienteDao.delete(clienteDelete);

            //UPDATE
            //Cliente clienteUpdate = new Cliente(3, "juan", "Fernan", "22222222I", "1990-11-04", "juan@gmail.com", 0, 0);
            //clienteDao.update(clienteUpdate);
            
            //hacer compra
            //Compra compraNueva = new Compra(1, 1, 3, "2020-11-22", 100);
            //compraDao.insertar(compraNueva);
            
            Compra compraNueva = new Compra(1, 1, 3, "2020-11-22", 100);
            compraDao.insertar(compraNueva);
            
            listaClientes.forEach(clientes -> {
                System.out.println("Clientes = " + clientes);
            });
        } catch (SQLException ex){
            ex.printStackTrace(System.out);
            System.out.println("Fallo en la operación de inserción. Se va a ejecutar rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
    }
}
