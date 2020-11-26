/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import static datos.Conexion.*;
import java.util.*;
import java.sql.*;
import domain.Compra;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alex_
 */
public class CompraDAO {
    private static final String SQL_SELECT="SELECT id, id_cliente, id_producto, importe, fecha, puntos FROM compra";
    private static final String SQL_INSERT="INSERT INTO compra(id_cliente, id_producto, importe, fecha, puntos) VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM compra where id = ?";
    private static final String SQL_UPDATE = "UPDATE cliente SET id_cliente = ?, id_producto = ?, importe = ?, fecha = ?, puntos = ? WHERE id = ?";
    private Connection conexionTransaccional;
    
    public CompraDAO() {
    
    }
    
    public CompraDAO(Connection conexionTransaccional) {
              this.conexionTransaccional = conexionTransaccional;
    }
    
    public List<Compra> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Compra compra = null;
        List<Compra> compras = new ArrayList<>();
        
         try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            //conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs=stmt.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                int id_cliente = rs.getInt("id_cliente");
                int id_producto = rs.getInt("id_producto");
                int importe = rs.getInt("importe");
                String fecha = rs.getString("fecha");
                int puntos = rs.getInt("puntos");
                compra = new Compra(id, id_cliente, id_producto, importe, fecha, puntos);
                compras.add(compra);
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
        
        return compras;
    }
    
    
    public int insertar (Compra compra) {
        Connection conn = null;
        PreparedStatement stmt = null;
        
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, compra.getId_cliente());
            stmt.setInt(2, compra.getId_producto());
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
    
    public int delete(Compra compra) {

        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try {

            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_DELETE);
            stmt.setInt(1, compra.getId());
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
    
     public int update(Compra compra) {
        
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try {
            
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, compra.getId_cliente());
            stmt.setInt(2, compra.getId_producto());
            stmt.setInt(3, compra.getImporte());
            stmt.setString(4, compra.getFecha());
            stmt.setInt(5, compra.getPuntos());
            stmt.setInt(6, compra.getId());
            registros = stmt.executeUpdate();
            
        } catch (SQLException ex) {
            
            ex.printStackTrace(System.out);
        }
      return registros;
    }
}
