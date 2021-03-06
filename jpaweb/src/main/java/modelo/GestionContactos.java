/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import mx.com.gm.SGA.domain.Contacto;


/**
 *
 * @author aledom
 */
public class GestionContactos {
    public static void altaContacto(String nombre, String email, String telefono){
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("ContactoPU");
        EntityManager em=emf.createEntityManager();
        EntityTransaction tx=em.getTransaction();
        
        //Empezamos transaccion
        tx.begin();
        
        Contacto contacto=new Contacto(nombre, email, telefono);
        
        em.persist(contacto);
        
        tx.commit();
        
        em.close();
    }
    
    public static void eliminarContacto(int id) {
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("ContactoPU");
        EntityManager em=emf.createEntityManager();
        EntityTransaction tx=em.getTransaction();
        
        //Empezamos transaccion
        tx.begin();
        
        em.remove(id);
        
        tx.commit();
    }
    
    public static void recuperarContactos() {
        
    }
}
