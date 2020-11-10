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
            Persona nueva_persona =new Persona("Antonio11111111111111111111111111111111111111111111", "Pérez","carlitos@gmail.com",35);
       
            
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
