/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import datos.Conexion;
import datos.PersonaDAO;
import domain.Persona;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;


/**
 *
 * @author aledom
 */
public class TestManejoPersonas {
   public static void main(String[] args) {

        Connection conexion = null;
        
        try {
            conexion = Conexion.getConnection();
            
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            
            PersonaDAO personaDao = new PersonaDAO(conexion);
            
            Persona cambioPersona = new Persona();
            cambioPersona.setIdPersona(2);
            cambioPersona.setNombre("Karla Ivonne");
            cambioPersona.setApellidos("Gomez");
            cambioPersona.setEmail("kgomez@mail.com");
            //cambioPersona.setTelefono("7713445678");
            personaDao.update(cambioPersona);
            Persona nuevaPersona = new Persona();
            nuevaPersona.setNombre("Carlos");
            nuevaPersona.setApellidos("Ramirez");
            personaDao.insertar(nuevaPersona);
            
            conexion.commit();
            System.out.println("Se ha hecho commit de la transaccion");
   
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
    }
}
