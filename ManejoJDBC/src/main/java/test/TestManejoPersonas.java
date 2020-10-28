/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import datos.PersonaDAO;
import domain.Persona;
import java.sql.SQLException;
import java.util.*;


/**
 *
 * @author aledom
 */
public class TestManejoPersonas {
    public static void main(String[] args) throws SQLException {
        PersonaDAO personaDao = new PersonaDAO();
        List<Persona> personas = personaDao.seleccionar();
        
        Persona personaNueva = new Persona("Carlos", "Perez", 54,  "carlos@gmail.com");
        personaDao.insertar(personaNueva);
        personas.forEach(persona -> {
            System.out.println("persona = " + persona);
        });
    }
}
