/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import datos.Conexion;
import datos.ClienteDAO;
import datos.CompraDAO;
import datos.CompraPuntosDAO;
import datos.DevolucionDAO;
import datos.ProductoDAO;
import domain.Cliente;
import domain.Compra;
import domain.Devolucion;
import domain.Producto;
import domain.CompraPuntos;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.*;

/**
 *
 * @author aledom
 */
public class Test {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        
        Connection conexion = Conexion.getConnection();
        
        int opcion;
        
        menu();
        opcion = sc.nextInt();
        sc.nextLine();

            while (opcion != 0) {
                switch (opcion) {
                    case 1:
                        crear_clientes();
                        break;
                    case 2:
                        eliminar_clientes();
                        break;
                    case 3:
                        actualizar_clientes();
                        break;
                    case 4:
                        listar_clientes();
                        break;
                    case 5:
                        crear_producto();
                        break;
                    case 6:
                        actualizar_productos();
                        break;
                    case 7:
                        listar_productos();
                        break;
                    case 8:
                        compra_euros();
                        break;
                    case 9:
                        recarga_saldo();
                        break;
                    case 10:
                        compra_puntos();
                        break;
                    case 11:
                        devolver_compra();
                        break;
                }
                menu();
                opcion = sc.nextInt();
                sc.nextLine();
            }
            System.out.println("Gracias por usar SuperComprin");
    }
    
    public static void menu() {
        System.out.println("-------------------------------"); 
        System.out.println("1- Crear Clientes");
        System.out.println("2- Eliminar Clientes");
        System.out.println("3- Actualizar Clientes");
        System.out.println("4- Listar Clientes");
        System.out.println("5- Crear Productos");
        System.out.println("6- Modificar Productos");
        System.out.println("7- Listar Productos");
        System.out.println("8- Hacer compra(EUROS)");
        System.out.println("9- Recargar saldo");
        System.out.println("10- Hacer compra(PUNTOS)");
        System.out.println("11- Devolver compra");
        System.out.println("0- Salir");
        System.out.println("-------------------------------");   
        System.out.println("Introduce una opcion: ");
    }
    
    public static void crear_clientes() throws SQLException {
        Scanner sc = new Scanner(System.in);
        
        ClienteDAO clienteDao = new ClienteDAO();
        String nombre;
        String apellidos;
        String dni;
        String fecha;
        String email;
        int puntos = 0;
        int saldo = 0;
        
        System.out.println("Escribe el nombre: ");
        nombre = sc.nextLine();
        System.out.println("Escribe los apellidos: ");
        apellidos = sc.nextLine();
        System.out.println("Escribe el dni: ");
        dni = sc.nextLine();
        System.out.println("Escribe la fecha de nacimiento(YYYY-MM-DD): ");
        fecha = sc.nextLine();
        System.out.println("Escribe el email: ");
        email = sc.nextLine();
        
        Cliente clienteNuevo = new Cliente(nombre, apellidos, dni, fecha, email, puntos, saldo);
        clienteDao.insertar(clienteNuevo);
    }
    
    public static void eliminar_clientes() throws SQLException {
        Scanner sc = new Scanner(System.in);
        
        ClienteDAO clienteDao = new ClienteDAO();
        
        int id;
        
        System.out.println("Escribe id del cliente que deseas eliminar: ");
        id = sc.nextInt();
        sc.nextLine();
        
        Cliente clienteDelete =new Cliente(id);
        clienteDao.delete(clienteDelete);
    }
    
    public static void actualizar_clientes() throws SQLException {
        Scanner sc = new Scanner(System.in);
        
        ClienteDAO clienteDao = new ClienteDAO();
        
        int id;
        String nombre;
        String apellidos;
        String dni;
        String fecha;
        String email;
        
        System.out.println("Escribe id del cliente que deseas actualizar: ");
        id = sc.nextInt();
        sc.nextLine();
        System.out.println("Escribe el nombre: ");
        nombre = sc.nextLine();
        System.out.println("Escribe los apellidos: ");
        apellidos = sc.nextLine();
        System.out.println("Escribe el dni: ");
        dni = sc.nextLine();
        System.out.println("Escribe la fecha de nacimiento(YYYY-MM-DD): ");
        fecha = sc.nextLine();
        System.out.println("Escribe el email: ");
        email = sc.nextLine();
        
        Cliente clienteUpdate = new Cliente(id, nombre, apellidos, dni, fecha, email);
        clienteDao.update(clienteUpdate);
    }
    
    public static void listar_clientes() throws SQLException {
        ClienteDAO clienteDao = new ClienteDAO();
        List<Cliente> listaClientes = clienteDao.seleccionar();
         
        listaClientes.forEach(clientes -> {
            System.out.println("Clientes = " + clientes);
        });
    }
    
    public static void crear_producto() throws SQLException {
        Scanner sc = new Scanner(System.in);
        
        ProductoDAO productoDao = new ProductoDAO();
        
        String nombre;
        int precio;
        int puntos;
        
        System.out.println("Escribe nombre del producto: ");
        nombre = sc.nextLine();
        System.out.println("Escribe el precio del producto: ");
        precio = sc.nextInt();
        sc.nextLine();
        System.out.println("Escribe los puntos del producto: ");
        puntos = sc.nextInt();
        sc.nextLine();
        
        Producto productoNuevo = new Producto(nombre, precio, puntos);
        productoDao.insertar(productoNuevo);
    }
    
    public static void actualizar_productos() throws SQLException {
        Scanner sc = new Scanner(System.in);
        
        ProductoDAO productoDao = new ProductoDAO();
        
        int id;
        String nombre;
        int precio;
        int puntos;
        
        System.out.println("Escribe el id del producto: ");
        id = sc.nextInt();
        sc.nextLine();
        System.out.println("Escribe el nombre: ");
        nombre = sc.nextLine();
        System.out.println("Escribe el precio: ");
        precio = sc.nextInt();
        sc.nextLine();
        System.out.println("Escribe los puntos: ");
        puntos = sc.nextInt();
        sc.nextLine();
        
        Producto productosUpdate = new Producto(id, nombre, precio, puntos);
        productoDao.update(productosUpdate);
    }
    
    public static void listar_productos() throws SQLException {
        ProductoDAO productoDao = new ProductoDAO();
        List<Producto> listaProductos = productoDao.seleccionar();
        
        listaProductos.forEach(productos -> {
            System.out.println("Productos = " + productos);
        });
    }
     
    public static void compra_euros() throws SQLException {
        Scanner sc = new Scanner(System.in);
        
        ClienteDAO clienteDao = new ClienteDAO();
        ProductoDAO productoDao = new ProductoDAO();
        CompraDAO compraDao = new CompraDAO();
        List<Cliente> listaClientes = clienteDao.seleccionar();
        List<Producto> listaProductos = productoDao.seleccionar();
       
        boolean verificar_dni = false;
        boolean verificar_producto = false;
        String dni = "";
        String dni_escan = "";
        int id_producto = 0;
        int id_producto_scan = 0;
        int id_cliente = 0;
        int puntos = 0;
        int importe = 0;
        int saldo = 0;
        int puntos_cliente = 0;
        
        SimpleDateFormat fecha = new SimpleDateFormat("yyyy/MM/dd");
        String fechaComoCadena = fecha.format(new Date());
        
        while (verificar_dni == false) {

            System.out.print("Introduzca el DNI: ");
            dni_escan = sc.nextLine();
            for (Cliente cliente : listaClientes) {

                dni = cliente.getDni();

                if (dni.equals(dni_escan)) {
                    verificar_dni = true;
                    id_cliente = cliente.getId();
                    saldo = cliente.getSaldo();
                    puntos_cliente = cliente.getPuntos();
                }
            }
            if (verificar_dni == false) {
                System.out.println("El DNI " + dni_escan + " no existe");
            } 
        }
        
        while (verificar_producto == false) {

            System.out.print("Introduzca el ID del producto: ");
            id_producto_scan = sc.nextInt();
            sc.nextLine();
            for (Producto producto : listaProductos) {

                id_producto = producto.getId();

                if (id_producto == id_producto_scan) {
                    verificar_producto = true;
                    puntos = producto.getPuntos();
                    importe = producto.getPrecio();
                }
            }
            if (verificar_producto == false) {
                System.out.println("El producto con id " + id_producto_scan + " no existe");
            } 
        }
        if (saldo >= importe) {
        saldo = saldo - importe;
        puntos_cliente = puntos_cliente + puntos;
        //Hace la compra
        Compra compraNueva = new Compra(id_cliente, id_producto_scan, importe, fechaComoCadena, puntos);
        compraDao.insertar(compraNueva);
        //modifica el cliente
        Cliente clienteUpdate = new Cliente(id_cliente, puntos_cliente, saldo);
        clienteDao.update_compra(clienteUpdate);
        
        } else {
            System.out.println("No tienes suficiente saldo para comprar este producto");
        }
    }
    
    public static void recarga_saldo() throws SQLException {
        Scanner sc = new Scanner(System.in);
        
        ClienteDAO clienteDao = new ClienteDAO();
        List<Cliente> listaClientes = clienteDao.seleccionar();
        
        boolean verificar_dni = false;
        String dni_escan = "";
        String dni = "";
        int saldo_actual = 0;
        int saldo = 0;
        int id = 0;
        
        Calendar fecha_hoy = Calendar.getInstance();
        
        //Comprueba que la fecha sea entre el dia 1 y el 5 de cada mes
        if (fecha_hoy.get(Calendar.DAY_OF_MONTH) <= 5) {
            while (verificar_dni == false) {

                System.out.print("Introduzca el DNI: ");
                dni_escan = sc.nextLine();
                for (Cliente cliente : listaClientes) {

                    dni = cliente.getDni();

                    if (dni.equals(dni_escan)) {
                        verificar_dni = true;
                        id = cliente.getId();
                        saldo_actual = cliente.getSaldo();
                    }
                }
                if (verificar_dni == false) {
                    System.out.println("El DNI " + dni_escan + " no existe");
                } 
            }
            
            System.out.println("Cuanto Saldo quieres ingresar: ");
            saldo = sc.nextInt();
            sc.nextLine();

            saldo = saldo + saldo_actual;
            
            Cliente clienteUpdate = new Cliente(id, saldo);
            clienteDao.update_recarga(clienteUpdate);
        } else {
            System.out.println("Hoy no se puede recargar el saldo");
        }
    }
    
    public static void compra_puntos() throws SQLException {
        Scanner sc = new Scanner(System.in);
        
        ClienteDAO clienteDao = new ClienteDAO();
        ProductoDAO productoDao = new ProductoDAO();
        CompraPuntosDAO compraPuntosDao = new CompraPuntosDAO();
        List<Cliente> listaClientes = clienteDao.seleccionar();
        List<Producto> listaProductos = productoDao.seleccionar();
       
        boolean verificar_dni = false;
        boolean verificar_producto = false;
        String dni = "";
        String dni_escan = "";
        int id_producto = 0;
        int id_producto_scan = 0;
        int id_cliente = 0;
        int puntos = 0;
        int importe = 0;
        int saldo = 0;
        int puntos_cliente = 0;
        
        SimpleDateFormat fecha = new SimpleDateFormat("yyyy/MM/dd");
        String fechaComoCadena = fecha.format(new Date());
        
        while (verificar_dni == false) {

            System.out.print("Introduzca el DNI: ");
            dni_escan = sc.nextLine();
            for (Cliente cliente : listaClientes) {

                dni = cliente.getDni();

                if (dni.equals(dni_escan)) {
                    verificar_dni = true;
                    id_cliente = cliente.getId();
                    saldo = cliente.getSaldo();
                    puntos_cliente = cliente.getPuntos();
                }
            }
            if (verificar_dni == false) {
                System.out.println("El DNI " + dni_escan + " no existe");
            } 
        }
        
        while (verificar_producto == false) {

            System.out.print("Introduzca el ID del producto: ");
            id_producto_scan = sc.nextInt();
            sc.nextLine();
            for (Producto producto : listaProductos) {

                id_producto = producto.getId();

                if (id_producto == id_producto_scan) {
                    verificar_producto = true;
                    puntos = producto.getPuntos();
                    importe = producto.getPrecio();
                }
            }
            if (verificar_producto == false) {
                System.out.println("El producto con id " + id_producto_scan + " no existe");
            } 
        }
        if (importe >= 5 && puntos_cliente >= puntos) {
            puntos_cliente = puntos_cliente - puntos;
            //Hace la compra
            CompraPuntos compraNueva = new CompraPuntos(id_cliente, id_producto_scan, fechaComoCadena, puntos);
            compraPuntosDao.insertar(compraNueva);
            //modifica el cliente
            Cliente clienteUpdate = new Cliente(id_cliente, puntos_cliente, saldo);
            clienteDao.update_compra(clienteUpdate);
            System.out.println("Compra realizada");
        } else {
            System.out.println("No tienes suficientes puntos para comprar este producto");
        }
    }
    
    public static void devolver_compra() throws SQLException {
        Scanner sc = new Scanner(System.in);
        
        ClienteDAO clienteDao = new ClienteDAO();
        ProductoDAO productoDao = new ProductoDAO();
        CompraDAO compraDao = new CompraDAO();
        List<Cliente> listaClientes = clienteDao.seleccionar();
        List<Producto> listaProductos = productoDao.seleccionar();
       
        boolean verificar_dni = false;
        boolean verificar_producto = false;
        String dni = "";
        String dni_escan = "";
        int id_producto = 0;
        int id_producto_scan = 0;
        int id_cliente = 0;
        int puntos = 0;
        int importe = 0;
        int saldo = 0;
        int puntos_cliente = 0;
        
        SimpleDateFormat fecha = new SimpleDateFormat("yyyy/MM/dd");
        String fechaComoCadena = fecha.format(new Date());
        
        while (verificar_dni == false) {

            System.out.print("Introduzca el DNI: ");
            dni_escan = sc.nextLine();
            for (Cliente cliente : listaClientes) {

                dni = cliente.getDni();

                if (dni.equals(dni_escan)) {
                    verificar_dni = true;
                    id_cliente = cliente.getId();
                    saldo = cliente.getSaldo();
                    puntos_cliente = cliente.getPuntos();
                }
            }
            if (verificar_dni == false) {
                System.out.println("El DNI " + dni_escan + " no existe");
            } 
        }
        
        while (verificar_producto == false) {

            System.out.print("Introduzca el ID del producto: ");
            id_producto_scan = sc.nextInt();
            sc.nextLine();
            for (Producto producto : listaProductos) {

                id_producto = producto.getId();

                if (id_producto == id_producto_scan) {
                    verificar_producto = true;
                    puntos = producto.getPuntos();
                    importe = producto.getPrecio();
                }
            }
            if (verificar_producto == false) {
                System.out.println("El producto con id " + id_producto_scan + " no existe");
            } 
        }
        
        saldo = saldo + importe;
        puntos_cliente = puntos_cliente - puntos;
        //Hace la compra
        Compra compraNueva = new Compra(id_cliente, id_producto_scan, importe, fechaComoCadena, puntos);
        compraDao.insertar(compraNueva);
        //modifica el cliente
        Cliente clienteUpdate = new Cliente(id_cliente, puntos_cliente, saldo);
        clienteDao.update_compra(clienteUpdate);
    }
}
