/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import static datos.Conexion.*;
import domain.Producto;
import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alex_
 */
public class ProductoDAO {
    private static final String SQL_SELECT="SELECT id, nombre, precio, puntos FROM producto";
    private static final String SQL_INSERT="INSERT INTO producto(nombre, precio, puntos) VALUES (?, ?, ?)";
     private static final String SQL_UPDATE = "UPDATE PRODUCTO SET nombre = ?, precio = ?, puntos = ? WHERE id = ?";
   
    private Connection conexionTransaccional;
    
    public List<Producto> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Producto producto = null;
        List<Producto> productos = new ArrayList<>();
        
         try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            //conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs=stmt.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                int precio = rs.getInt("precio");
                int puntos = rs.getInt("puntos");
                producto = new Producto(id, nombre, precio, puntos);
                productos.add(producto);
            }
            
        } catch (SQLException ex) {
           ex.printStackTrace(System.out);
        }
        finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(conn);
            }
            //Conexion.close(conn);
            //Conexion.close(rs);
            //Conexion.close(stmt);
        }
        
        return productos;
    }
    
    
    public int insertar (Producto producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, producto.getNombre());
            stmt.setInt(2, producto.getPrecio());
            stmt.setInt(3, producto.getPuntos());
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
    
    public int update(Producto producto) {
        
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try {
            
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_UPDATE);
            stmt.setString(1, producto.getNombre());
            stmt.setInt(2, producto.getPrecio());
            stmt.setInt(3, producto.getPuntos());
            stmt.setInt(4, producto.getId());
            registros = stmt.executeUpdate();
            
        } catch (SQLException ex) {
            
            ex.printStackTrace(System.out);
        }
      return registros;
    }
}
