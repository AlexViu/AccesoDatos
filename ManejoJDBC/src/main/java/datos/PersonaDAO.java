/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import static datos.Conexion.*;
import java.util.*;
import java.sql.*;
import domain.Persona;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aledom
 */
public class PersonaDAO {
    private static final String SQL_SELECT="SELECT Id_persona, Nombre, Apellidos, Email, Edad FROM persona";
    private static final String SQL_INSERT="INSERT INTO persona(Nombre, Apellidos, Email, Edad) VALUES (?, ?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM persona where id_persona = ?";
    private static final String SQL_UPDATE = "UPDATE persona SET nombre = ?, apellidos = ?, email = ?, edad = ? WHERE id_persona = ?";
                                                
    
    public List<Persona> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<>();
        
         try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs=stmt.executeQuery();
            while (rs.next()){
                int idPersona = rs.getInt("Id_persona");
                String nombre = rs.getString("Nombre");
                String apellidos = rs.getString("Apellidos");
                String email = rs.getString("Email");
                int edad = rs.getInt("Edad");
                
                persona = new Persona(idPersona, nombre, apellidos, edad, email);
                personas.add(persona);
            }
            
        } catch (SQLException ex) {
           ex.printStackTrace(System.out);
        }
        finally {
            Conexion.close(conn);
            Conexion.close(rs);
            Conexion.close(stmt);
        }
        
        return personas;
    }
    
    
    public int insertar (Persona persona) {
        Connection conn = null;
        PreparedStatement stmt = null;
        
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellidos());
            stmt.setString(3, persona.getEmail());
            stmt.setInt(4, persona.getEdad());
            registros = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    
        finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    public int delete(Persona persona) {

        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try {

            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_DELETE);
            stmt.setInt(1, persona.getIdPersona());
            registros = stmt.executeUpdate();

        } catch (SQLException ex) {

            ex.printStackTrace(System.out);
        } finally {

            try {
                stmt.close();
                con.close();
            } catch (SQLException ex) {

                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
     public int update(Persona p) {
        
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try {
            
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_UPDATE);
            stmt.setString(1, p.getNombre());
            stmt.setString(2, p.getApellidos());
            stmt.setString(3, p.getEmail());
            stmt.setInt(4, p.getEdad());
            stmt.setInt(5, p.getIdPersona());
            registros = stmt.executeUpdate();
            
        } catch (SQLException ex) {
            
            ex.printStackTrace(System.out);
        }
      return registros;
    }
}
