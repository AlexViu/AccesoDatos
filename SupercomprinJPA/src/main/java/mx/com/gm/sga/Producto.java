/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author alex_
 */

@Entity
@Table (name="producto")
public class Producto implements Serializable {
    private static final long SerialVersionUID=1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idProducto;
    private String nombre;
    private int precio;
    private int puntos;

    public Producto(String nombre, int precio, int puntos) {
        this.nombre = nombre;
        this.precio = precio;
        this.puntos = puntos;
    }

    public Producto() {
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idProducto + ", nombre=" + nombre + ", precio=" + precio + ", puntos=" + puntos + '}';
    }
    
    
}
