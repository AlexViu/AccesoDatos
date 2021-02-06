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
import mx.com.gm.sga.Devolucion;
/**
 *
 * @author alex_
 */
public class GestionDevolucion {
    private EntityManager getEntityManager(){
			EntityManagerFactory factory=Persistence.createEntityManagerFactory("SupercomprinPU");
			return factory.createEntityManager();
		}   
		
		public void nuevoDevolucion(int id_producto, int id_cliente, int importe, String fecha, int puntos){
			Devolucion d=new Devolucion(id_producto, id_cliente, importe, fecha, puntos);
			EntityManager em=getEntityManager();
			//la operación la incluimos en una transacción
			EntityTransaction tx=em.getTransaction();
			tx.begin();
			em.persist(d);
			tx.commit();
		}
		public void nuevoDevolucion(Devolucion d){
			EntityManager em=getEntityManager();
			//la operación la incluimos en una transacción
			EntityTransaction tx=em.getTransaction();
			tx.begin();
			em.persist(d);
			tx.commit();
		}
		
		
		public List<Devolucion> recuperarDevolucion(){
			EntityManager em=getEntityManager();
			/*Query qr=em.createQuery("Select d from Devolucion d");
			return (List<Devolucion>)qr.getResultList();*/
			TypedQuery<Devolucion> qr=em.createQuery("Select d from Devolucion d",Devolucion.class);
			return qr.getResultList();
		}

}
