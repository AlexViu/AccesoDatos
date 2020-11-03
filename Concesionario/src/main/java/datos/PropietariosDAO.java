/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import static datos.Conexion.*;
import java.util.*;
import java.sql.*;
import domain.Propietarios;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author alex_
 */
public class PropietariosDAO {
    private static final String SQL_SELECT = "SELECT DNI, Nombre, Edad FROM propietarios";
    private static final String SQL_INSERT = "INSERT INTO propietarios(DNI, Nombre, Edad) VALUES (?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM propietarios where DNI = ?";
    private static final String SQL_UPDATE = "UPDATE propietarios SET Nombre = ?, Edad = ? WHERE DNI = ?";
    
    public List<Propietarios> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Propietarios propietario = null;
        List<Propietarios> listaPropietarios = new ArrayList<>();
        
         try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs=stmt.executeQuery();
            while (rs.next()){
                String dni = rs.getString("DNI");
                String nombre = rs.getString("Nombre");
                int edad = rs.getInt("Edad");
                
                propietario = new Propietarios(dni, nombre, edad);
                listaPropietarios.add(propietario);
            }
            
        } catch (SQLException ex) {
           ex.printStackTrace(System.out);
        }
        finally {
            Conexion.close(conn);
            Conexion.close(rs);
            Conexion.close(stmt);
        }
        
        return listaPropietarios;
    }
    
    
   public int insertar (Propietarios propietarios) {
        Connection conn = null;
        PreparedStatement stmt = null;
        
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, propietarios.getDNI());
            stmt.setString(2, propietarios.getNombre());
            stmt.setInt(3, propietarios.getEdad());

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
    
   public int delete(Propietarios propietarios) {

        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try {

            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_DELETE);
            stmt.setString(1, propietarios.getDNI());
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
    
    public int update(Propietarios propietarios) {
        
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try {
            
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_UPDATE);
            stmt.setString(1, propietarios.getNombre());
            stmt.setInt(2, propietarios.getEdad());
            stmt.setString(3, propietarios.getDNI());
            registros = stmt.executeUpdate();
            
        } catch (SQLException ex) {
            
            ex.printStackTrace(System.out);
        }
      return registros;
    }
    
}
