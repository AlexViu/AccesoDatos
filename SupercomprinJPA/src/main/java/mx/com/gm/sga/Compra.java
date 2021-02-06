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
@Table (name="compra")
public class Compra implements Serializable {
    private static final long SerialVersionUID=1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private int id_cliente;
    private int id_producto;
    private int importe;
    private String fecha;
    private int puntos;

    public Compra(int id_cliente, int id_producto, int importe, String fecha, int puntos) {
        this.id_cliente = id_cliente;
        this.id_producto = id_producto;
        this.importe = importe;
        this.fecha = fecha;
        this.puntos = puntos;
    }

    public Compra() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getImporte() {
        return importe;
    }

    public void setImporte(int importe) {
        this.importe = importe;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    @Override
    public String toString() {
        return "Compra{" + "id=" + id + ", id_cliente=" + id_cliente + ", id_producto=" + id_producto + ", importe=" + importe + ", fecha=" + fecha + ", puntos=" + puntos + '}';
    }
    
}
