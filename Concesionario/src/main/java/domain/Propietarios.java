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
public class Propietarios {
    private String DNI;
    private String Nombre;
    private int Edad;
    
    public Propietarios() {
        this.DNI = "";
        this.Nombre = "";
        this.Edad = 0;
    }
    
    public Propietarios(String dni) {
        this.DNI = dni;
    }
    
    public Propietarios(String dni, String nombre, int edad) {
        this.DNI = dni;
        this.Nombre = nombre;
        this.Edad = edad;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    @Override
    public String toString() {
        return "Propietarios{" + "DNI=" + DNI + ", Nombre=" + Nombre + ", Edad=" + Edad + '}';
    }
    
}
