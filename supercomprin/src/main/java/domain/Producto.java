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
public class Producto {
    private int Id;
    private String Nombre;
    private int Precio;
    private int Puntos;
    
    public Producto() {
        this.Id = 0;
        this.Nombre = "";
        this.Precio = 0;
        this.Puntos = 0;
    }
    
    public Producto(int id) {
        this.Id = id;
    }
    
    public Producto(String nombre, int precio, int puntos) {
        this.Nombre = nombre;
        this.Precio = precio;
        this.Puntos = puntos;
    }
    
    public Producto(int id, String nombre, int precio, int puntos) {
        this.Id = id;
        this.Nombre = nombre;
        this.Precio = precio;
        this.Puntos = puntos;
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

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int Precio) {
        this.Precio = Precio;
    }

    public int getPuntos() {
        return Puntos;
    }

    public void setPuntos(int Puntos) {
        this.Puntos = Puntos;
    }

    @Override
    public String toString() {
        return "Producto{" + "Id=" + Id + ", Nombre=" + Nombre + ", Precio=" + Precio + ", Puntos=" + Puntos + '}';
    }
    
    
}
