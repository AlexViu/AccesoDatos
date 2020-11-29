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
public class CompraPuntos {
    private int Id;
    private int Id_cliente;
    private int Id_producto;
    private String Fecha;
    private int Puntos;
    
    public CompraPuntos() {
        this.Id = 0;
        this.Id_cliente = 0;
        this.Id_producto = 0;
        this.Fecha = "";
        this.Puntos = 0;
    }
    
    public CompraPuntos(int id) {
        this.Id = id;
    }
    
    public CompraPuntos(int id_cliente, int id_producto, String fecha, int puntos) {
        this.Id_cliente = id_cliente;
        this.Id_producto = id_producto;
        this.Fecha = fecha;
        this.Puntos = puntos;
    }
    
    public CompraPuntos(int id, int id_cliente, int id_producto, String fecha, int puntos) {
        this.Id = id;
        this.Id_cliente = id_cliente;
        this.Id_producto = id_producto;
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
        return "CompraPuntos{" + "Id=" + Id + ", Id_cliente=" + Id_cliente + ", Id_producto=" + Id_producto + ", Fecha=" + Fecha + ", Puntos=" + Puntos + '}';
    }
}
