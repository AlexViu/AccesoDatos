/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author alex_
 */
public class Usuario {
    private int idUsuario;
    private String Usuario;
    private String Password;
    
    public Usuario() {
        this.idUsuario = 0;
        this.Usuario = "";
        this.Password = "";
    }
    
    public Usuario(int idusuario) {
        this.idUsuario = idusuario;
    }
    
    public Usuario(String usuario, String password) {
        this.Usuario = usuario;
        this.Password = password;
    }
    
    public Usuario(int idusuario, String usuario, String password) {
        this.idUsuario = idusuario;
        this.Usuario = usuario;
        this.Password = password;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", Usuario=" + Usuario + ", Password=" + Password + '}';
    }
    
    
}
