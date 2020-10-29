/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.*;
/**
 *
 * @author aledom
 */
public class Persona {
    private int idPersona;
    private String nombre;
    private String apellidos;
    private int edad;
    private String email;
    
    public Persona() {
        this.idPersona = 0;
        this.nombre = "";
        this.apellidos = "";
        this.edad = 0;
        this.email = "";
    }
    
    public Persona(int idpersona) {
        this.idPersona = idpersona;
    }
    
    public Persona(String Nombre, String Apellidos,String Email, int Edad) {
        this.nombre = Nombre;
        this.apellidos = Apellidos;
        this.email = Email;
        this.edad = Edad;
    }
    
    public Persona(int IdPersona, String Nombre, String Apellidos, int Edad, String Email) {
        this.idPersona = IdPersona;
        this.nombre = Nombre;
        this.apellidos = Apellidos;
        this.edad = Edad;
        this.email = Email;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad + ", email=" + email + '}';
    }
    
}
