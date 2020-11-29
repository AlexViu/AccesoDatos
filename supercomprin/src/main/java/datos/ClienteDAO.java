/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import static datos.Conexion.*;
import java.util.*;
import java.sql.*;
import domain.Cliente;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aledom
 */
public class ClienteDAO {
    private static final String SQL_SELECT="SELECT id, nombre, apellidos, dni, fecha_nac, email, puntos, saldo FROM cliente";
    private static final String SQL_INSERT="INSERT INTO cliente(nombre, apellidos, dni, fecha_nac, email, puntos, saldo) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM cliente where id = ?";
    private static final String SQL_UPDATE = "UPDATE cliente SET nombre = ?, apellidos = ?, dni = ?, fecha_nac = ?, email = ? WHERE id = ?";
    private static final String SQL_UPDATE_COMPRA = "UPDATE cliente SET puntos = ?, saldo = ? WHERE id = ?";
    private static final String SQL_UPDATE_SALDO = "UPDATE cliente SET saldo = ? WHERE id = ?";
    private Connection conexionTransaccional;
    
    public ClienteDAO() {
    
    }
    
    public ClienteDAO(Connection conexionTransaccional) {
              this.conexionTransaccional = conexionTransaccional;
    }
    
    public List<Cliente> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = null;
        List<Cliente> clientes = new ArrayList<>();
        
         try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            //conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs=stmt.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String dni = rs.getString("dni");
                String fecha_nac = rs.getString("fecha_nac");
                String email = rs.getString("email");
                int puntos = rs.getInt("puntos");
                int saldo = rs.getInt("saldo");
                
                cliente = new Cliente(id, nombre, apellidos, dni, fecha_nac, email, puntos, saldo);
                clientes.add(cliente);
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
        
        return clientes;
    }
    
    
    public int insertar (Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellidos());
            stmt.setString(3, cliente.getDni());
            stmt.setString(4, cliente.getFecha_nac());
            stmt.setString(5, cliente.getEmail());
            stmt.setInt(6, cliente.getPuntos());
            stmt.setInt(7, cliente.getSaldo());
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
    
    public int delete(Cliente cliente) {

        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try {

            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_DELETE);
            stmt.setInt(1, cliente.getId());
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
    
     public int update(Cliente cliente) {
        
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try {
            
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_UPDATE);
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellidos());
            stmt.setString(3, cliente.getDni());
            stmt.setString(4, cliente.getFecha_nac());
            stmt.setString(5, cliente.getEmail());
            stmt.setInt(6, cliente.getId());
            registros = stmt.executeUpdate();
            
        } catch (SQLException ex) {
            
            ex.printStackTrace(System.out);
        }
      return registros;
    }

    public int update_compra(Cliente cliente) {
        
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try {
            
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_UPDATE_COMPRA);
            stmt.setInt(1, cliente.getPuntos());
            stmt.setInt(2, cliente.getSaldo());
            stmt.setInt(3, cliente.getId());
            registros = stmt.executeUpdate();
            
        } catch (SQLException ex) {
            
            ex.printStackTrace(System.out);
        }
      return registros;
    }
    
    public int update_recarga(Cliente cliente) {
        
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try {
            
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_UPDATE_SALDO);
            stmt.setInt(1, cliente.getSaldo());
            stmt.setInt(2, cliente.getId());
            registros = stmt.executeUpdate();
            
        } catch (SQLException ex) {
            
            ex.printStackTrace(System.out);
        }
      return registros;
    }
}
