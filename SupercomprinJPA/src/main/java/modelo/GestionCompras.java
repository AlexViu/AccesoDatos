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
import mx.com.gm.sga.Compra;
/**
 *
 * @author alex_
 */
public class GestionCompras {
    private EntityManager getEntityManager(){
			EntityManagerFactory factory=Persistence.createEntityManagerFactory("SupercomprinPU");
			return factory.createEntityManager();
		}   
		
		public void nuevoCompra(int id_cliente, int id_producto, int importe, String fecha, int puntos){
			Compra p=new Compra(id_cliente, id_producto, importe, fecha, puntos);
			EntityManager em=getEntityManager();
			//la operación la incluimos en una transacción
			EntityTransaction tx=em.getTransaction();
			tx.begin();
			em.persist(p);
			tx.commit();
		}
		public void nuevoCompra(Compra c){
			EntityManager em=getEntityManager();
			//la operación la incluimos en una transacción
			EntityTransaction tx=em.getTransaction();
			tx.begin();
			em.persist(c);
			tx.commit();
		}
		
		
		public List<Compra> recuperarCompras(){
			EntityManager em=getEntityManager();
			/*Query qr=em.createQuery("Select c from Compra c");
			return (List<Compra>)qr.getResultList();*/
			TypedQuery<Compra> qr=em.createQuery("Select c from Compra c",Compra.class);
			return qr.getResultList();
		}

}
