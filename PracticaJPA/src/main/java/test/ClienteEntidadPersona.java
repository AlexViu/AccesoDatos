package test;

import javax.persistence.*;
import mx.com.gm.SGA.domain.Persona;
import org.apache.logging.log4j.*;
/**
 *
 * @author aledom
 */
public class ClienteEntidadPersona {
    static Logger log=LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("PersonaPU");
        EntityManager em=emf.createEntityManager();
        EntityTransaction tx=em.getTransaction();
        
        
        //Empezamos transaccion
        tx.begin();
        
        Persona persona1=new Persona("MariPepa", "Perez", 24, "pepa@gmail.com");
        log.debug("Objeto a persistir es: " + persona1);
        
        em.persist(persona1);
        
        
        tx.commit();
        log.debug("Objeto persistido: " + persona1);
        
        
        em.merge(persona1);
        persona1.setNombre("Mari Josefa");
        
        em.close();
    }
}
