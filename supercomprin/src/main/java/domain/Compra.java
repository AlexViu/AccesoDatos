/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.*;

/**
 *
 * @author alex_
 */
public class Compra {
    private int Id;
    private int Id_cliente;
    private int Id_producto;
    private int Importe;
    private String Fecha;
    private int Puntos;
    
    public Compra() {
        this.Id = 0;
        this.Id_cliente = 0;
        this.Id_producto = 0;
        this.Importe = 0;
        this.Fecha = "";
        this.Puntos = 0;
    }
    
    public Compra(int id) {
        this.Id = id;
    }
    
    public Compra(int id_cliente, int id_producto, int importe, String fecha, int puntos) {
        this.Id_cliente = id_cliente;
        this.Id_producto = id_producto;
        this.Importe = importe;
        this.Fecha = fecha;
        this.Puntos = puntos;
    }
    
    public Compra(int id, int id_cliente, int id_producto, int importe, String fecha, int puntos) {
        this.Id = id;
        this.Id_cliente = id_cliente;
        this.Id_producto = id_producto;
        this.Importe = importe;
        this.Fecha = fecha;
        this.Puntos = puntos;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getId_cliente() {
        return Id_cliente;
    }

    public void setId_cliente(int Id_cliente) {
        this.Id_cliente = Id_cliente;
    }

    public int getId_producto() {
        return Id_producto;
    }

    public void setId_producto(int Id_producto) {
        this.Id_producto = Id_producto;
    }

    public int getImporte() {
        return Importe;
    }

    public void setImporte(int Importe) {
        this.Importe = Importe;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public int getPuntos() {
        return Puntos;
    }

    public void setPuntos(int Puntos) {
        this.Puntos = Puntos;
    }

    @Override
    public String toString() {
        return "Compra{" + "Id=" + Id + ", Id_cliente=" + Id_cliente + ", Id_producto=" + Id_producto + ", Importe=" + Importe + ", Fecha=" + Fecha + ", Puntos=" + Puntos + '}';
    }
}
