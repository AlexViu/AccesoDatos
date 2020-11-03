/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import datos.CochesDAO;
import datos.PropietariosDAO;
import domain.Coches;
import domain.Propietarios;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author alex_
 */
public class ManejoConcesionario {
    public static void main(String[] args) throws SQLException {
        CochesDAO cochesDao = new CochesDAO();
        List<Coches> listaCoches = cochesDao.seleccionar();
        PropietariosDAO propietariosDAO = new PropietariosDAO();
        List<Propietarios> listaPropietarios = propietariosDAO.seleccionar();
        
        //Crear Coche
        //Coches cocheNuevo = new Coches("4444CAA", "Opel", 8000, "48385018F");
        //cochesDao.insertar(cocheNuevo);
        
        //Eliminar coche
        //Coches cocheDelete = new Coches("4444CAA");
        //cochesDao.delete(cocheDelete);
        
        //modificar coche
        //Coches cocheUpdate= new Coches("4444CAA", "Renault", 9000, "48385018F");
        //cochesDao.update(cocheUpdate);
        
        //Crear propietario
        //Propietarios propietarioNuevo = new Propietarios("12453453Y", "Antonio", 33);
        //propietariosDAO.insertar(propietarioNuevo);
        
        //Eliminar propietario
        //Propietarios propietarioDelete = new Propietarios("12453453Y");
        //propietariosDAO.delete(propietarioDelete);
        
        //modificar propietario
        //Propietarios propietarioUpdate= new Propietarios("12453453Y", "Juan", 30);
        //propietariosDAO.update(propietarioUpdate);
        
        //Mostrar coches
        listaCoches.forEach(coches -> {
            System.out.println("coches = " + coches);
        });
       
        //mostrar propietarios
        listaPropietarios.forEach(propietarios -> {
            System.out.println("propietarios = " + propietarios);
        });
       
    }
}
