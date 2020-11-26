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
public class Cliente {
    private int Id;
    private String Nombre;
    private String Apellidos;
    private String Dni;
    private String Fecha_nac;
    private String Email;
    private int Puntos;
    private int Saldo;
    
    public Cliente(){
        this.Id = 0;
        this.Nombre = "";
        this.Apellidos = "";
        this.Dni = "";
        this.Fecha_nac = "";
        this.Email = "";
        this.Puntos = 0;
        this.Saldo = 0;
    }
    
    public Cliente(int id) {
        this.Id = id;
    }
    
    public Cliente(String nombre, String apellidos, String dni, String fecha_nac, String email, int puntos, int saldo) {
        this.Nombre = nombre;
        this.Apellidos = apellidos;
        this.Dni = dni;
        this.Fecha_nac = fecha_nac;
        this.Email = email;
        this.Puntos = puntos;
        this.Saldo = saldo;
    }
    
    public Cliente(int id, String nombre, String apellidos, String dni, String fecha_nac, String email, int puntos, int saldo) {
        this.Id = id;
        this.Nombre = nombre;
        this.Apellidos = apellidos;
        this.Dni = dni;
        this.Fecha_nac = fecha_nac;
        this.Email = email;
        this.Puntos = puntos;
        this.Saldo = saldo;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getDni() {
        return Dni;
    }

    public void setDni(String Dni) {
        this.Dni = Dni;
    }

    public String getFecha_nac() {
        return Fecha_nac;
    }

    public void setFecha_nac(String Fecha_nac) {
        this.Fecha_nac = Fecha_nac;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getPuntos() {
        return Puntos;
    }

    public void setPuntos(int Puntos) {
        this.Puntos = Puntos;
    }

    public int getSaldo() {
        return Saldo;
    }

    public void setSaldo(int Saldo) {
        this.Saldo = Saldo;
    }

    @Override
    public String toString() {
        return "Cliente{" + "Id=" + Id + ", Nombre=" + Nombre + ", Apellidos=" + Apellidos + ", Dni=" + Dni + ", Fecha_nac=" + Fecha_nac + ", Email=" + Email + ", Puntos=" + Puntos + ", Saldo=" + Saldo + '}';
    }
}
