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

/**
 *
 * @author alex_
 */
public class GestionClientes {
    private EntityManager getEntityManager(){
			EntityManagerFactory factory=Persistence.createEntityManagerFactory("SupercomprinPU");
			return factory.createEntityManager();
		}   
		
		public void altaCliente(String nombre, String apellidos, String dni, String fecha_nac, String email){
			Cliente c=new Cliente(nombre, apellidos, dni, fecha_nac, email, 0, 0);
			EntityManager em=getEntityManager();
			//la operación la incluimos en una transacción
			EntityTransaction tx=em.getTransaction();
			tx.begin();
			em.persist(c);
			tx.commit();
		}
		public void altaCliente(Cliente c){
			EntityManager em=getEntityManager();
			//la operación la incluimos en una transacción
			EntityTransaction tx=em.getTransaction();
			tx.begin();
			em.persist(c);
			tx.commit();
		}
		
		
		public List<Cliente> recuperarClientes(){
			EntityManager em=getEntityManager();
			/*Query qr=em.createQuery("Select c from cliente c");
			return (List<Cliente>)qr.getResultList();*/
			TypedQuery<Cliente> qr=em.createQuery("Select c from Cliente c",Cliente.class);
			return qr.getResultList();
		}
		
		public Cliente buscarCliente(String email){
			EntityManager em=getEntityManager();
			String jpql="Select c from Contacto c where c.email=?1";
			TypedQuery<Cliente> qr=em.createQuery(jpql,Cliente.class);
			qr.setParameter(1, email);
			//return qr.getSingleResult();
			return qr.getResultList().get(0);
		}
		
		public void eliminarCliente(int id){
			EntityManager em=getEntityManager();
			Cliente c=em.find(Cliente.class, id);
			EntityTransaction tx=em.getTransaction();
			//si el contacto existe lo eliminamos 
			tx.begin();
			if(c!=null){
				em.remove(c);
			}
			tx.commit();
		}
}
