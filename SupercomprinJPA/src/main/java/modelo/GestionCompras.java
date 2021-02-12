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

import mx.com.gm.sga.Cliente;
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
		
		public void nuevoCompra(Cliente cliente, int id_producto, int importe, String fecha, int puntos){
			Compra p=new Compra( id_producto, cliente, importe, fecha, puntos);
			EntityManager em=getEntityManager();
			EntityTransaction tx=em.getTransaction();
                        TypedQuery<Cliente> qr=em.createQuery("SELECT c FROM Cliente c WHERE c.id=?1",Cliente.class);
                       
			tx.begin();
                        
                        qr.setParameter(1, cliente.getId());
                        updateSaldo(qr.getSingleResult(), importe, cliente.getId());
                        
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

                public Cliente updateSaldo(Cliente c,int saldo, int id){
                    EntityManager em=getEntityManager();
                        EntityTransaction tx=em.getTransaction();
                        
                        TypedQuery<Cliente> qr=em.createQuery("UPDATE Cliente SET saldo=?1 WHERE id=?2",Cliente.class);
                        
                        
                        tx.begin();
                        int saldoa = c.getSaldo();
                        int saldofinal= saldoa - saldo;
                        
                        qr.setParameter(1, saldofinal);
                        qr.setParameter(2, id);
                        
                        qr.executeUpdate();
                        tx.commit();    
                    
                        return c;   
                }
}
