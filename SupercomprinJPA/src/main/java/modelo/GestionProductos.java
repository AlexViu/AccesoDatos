/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import mx.com.gm.sga.Producto;

/**
 *
 * @author alex_
 */
public class GestionProductos {
    private EntityManager getEntityManager(){
			EntityManagerFactory factory=Persistence.createEntityManagerFactory("SupercomprinPU");
			return factory.createEntityManager();
		}   
		
		public void nuevoProducto(String nombre, int precio, int puntos){
			Producto p=new Producto(nombre, precio, puntos);
			EntityManager em=getEntityManager();
			//la operación la incluimos en una transacción
			EntityTransaction tx=em.getTransaction();
			tx.begin();
			em.persist(p);
			tx.commit();
		}
		public void nuevoProducto(Producto p){
			EntityManager em=getEntityManager();
			//la operación la incluimos en una transacción
			EntityTransaction tx=em.getTransaction();
			tx.begin();
			em.persist(p);
			tx.commit();
		}
		
		
		public List<Producto> recuperarProductos(){
			EntityManager em=getEntityManager();
			/*Query qr=em.createQuery("Select p from Producto p");
			return (List<Producto>)qr.getResultList();*/
			TypedQuery<Producto> qr=em.createQuery("Select p from Producto p",Producto.class);
			return qr.getResultList();
		}
		
		public void eliminarProducto(int id){
			EntityManager em=getEntityManager();
			Producto p=em.find(Producto.class, id);
			EntityTransaction tx=em.getTransaction();
			//si el contacto existe lo eliminamos 
			tx.begin();
			if(p!=null){
				em.remove(p);
			}
			tx.commit();
		}
}
