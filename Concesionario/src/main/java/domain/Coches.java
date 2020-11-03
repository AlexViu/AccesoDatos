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
public class Coches {
    private String Matricula;
    private String Marca;
    private int Precio;
    private String DNI;
    
    public Coches() {
        this.Matricula = "";
        this.Marca = "";
        this.Precio = 0;
        this.DNI = "";
    }
    
    public Coches(String matricula) {
        this.Matricula = matricula;
    }
    
    public Coches( String matricula, String marca, int precio, String dni) {
        this.Matricula = matricula;
        this.Marca = marca;
        this.Precio = precio;
        this.DNI = dni;
    }

    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula(String Matricula) {
        this.Matricula = Matricula;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int Precio) {
        this.Precio = Precio;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    @Override
    public String toString() {
        return "Coches{" + "Matricula=" + Matricula + ", Marca=" + Marca + ", Precio=" + Precio + ", DNI=" + DNI + '}';
    }
    
    
}
