/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import static datos.Conexion.*;
import java.util.*;
import java.sql.*;
import domain.Coches;
import domain.Propietarios;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author alex_
 */
public class CochesDAO {
    private static final String SQL_SELECT = "SELECT Matricula, Marca, Precio, DNI FROM coches";
    private static final String SQL_INSERT = "INSERT INTO coches(Matricula, Marca, Precio, DNI) VALUES (?, ?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM coches where Matricula = ?";
    private static final String SQL_UPDATE = "UPDATE coches SET Marca = ?, Precio = ?, DNI = ? WHERE Matricula = ?";
                                                
    
    public List<Coches> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Coches coche = null;
        List<Coches> listaCoches = new ArrayList<>();
        
         try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs=stmt.executeQuery();
            while (rs.next()){
                String matricula = rs.getString("Matricula");
                String marca = rs.getString("Marca");
                int precio = rs.getInt("Precio");
                String dni = rs.getString("DNI");
                
                coche = new Coches(matricula, marca, precio, dni);
                listaCoches.add(coche);
            }
            
        } catch (SQLException ex) {
           ex.printStackTrace(System.out);
        }
        finally {
            Conexion.close(conn);
            Conexion.close(rs);
            Conexion.close(stmt);
        }
        
        return listaCoches;
    }
    
    
   public int insertar (Coches coches) {
        Connection conn = null;
        PreparedStatement stmt = null;
        
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, coches.getMatricula());
            stmt.setString(2, coches.getMarca());
            stmt.setInt(3, coches.getPrecio());
            stmt.setString(4, coches.getDNI());

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
    
   public int delete(Coches coches) {

        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try {

            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_DELETE);
            stmt.setString(1, coches.getMatricula());
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
    
     public int update(Coches coches) {
        
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try {
            
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_UPDATE);
            stmt.setString(1, coches.getMarca());
            stmt.setInt(2, coches.getPrecio());
            stmt.setString(3, coches.getDNI());
             stmt.setString(4, coches.getMatricula());
            registros = stmt.executeUpdate();
            
        } catch (SQLException ex) {
            
            ex.printStackTrace(System.out);
        }
      return registros;
    }
    
}
