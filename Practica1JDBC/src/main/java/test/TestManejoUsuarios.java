/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import datos.UsuarioDAO;
import domain.Usuario;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author alex_
 */
public class TestManejoUsuarios {
    public static void main(String[] args) throws SQLException {
        UsuarioDAO usuarioDao = new UsuarioDAO();
        List<Usuario> personas = usuarioDao.seleccionar();
        
        //Crear usuario
        //Usuario usuarioNuevo = new Usuario("pepe", "12345");
        //usuarioDao.insertar(usuarioNuevo);
        
        //Eliminar usuario
        //Usuario usuarioDelete = new Usuario(2);
        //usuarioDao.delete(usuarioDelete);
        
        //modificar usuario
        //Usuario usuarioUpdate= new Usuario(1, "alex", "12345");
        //usuarioDao.update(usuarioUpdate);
        
        //Mostrar usuarios
        personas.forEach(usuario -> {
            System.out.println("usuario = " + usuario);
        });
       
       
    }
}
