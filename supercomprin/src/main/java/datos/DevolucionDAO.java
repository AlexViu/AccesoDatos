/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import static datos.Conexion.*;
import domain.Compra;
import java.util.*;
import java.sql.*;
import domain.Devolucion;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alex_
 */
public class DevolucionDAO {
    
    private static final String SQL_INSERT="INSERT INTO devolucion(id_producto, id_cliente, importe, fecha, puntos) VALUES (?, ?, ?, ?, ?)";
   
    private Connection conexionTransaccional;
    
    public int insertar (Compra compra) {
        Connection conn = null;
        PreparedStatement stmt = null;
        
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, compra.getId_producto());
            stmt.setInt(2, compra.getId_cliente());
            stmt.setInt(3, compra.getImporte());
            stmt.setString(4, compra.getFecha());
            stmt.setInt(5, compra.getPuntos());
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
}
