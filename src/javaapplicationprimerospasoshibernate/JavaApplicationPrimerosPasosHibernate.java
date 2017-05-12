package javaapplicationprimerospasoshibernate;

import ar.com.yo.bo.Persona;
import ar.com.yo.bo.Telefono;
import ar.com.yo.hibernate.NewHibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class JavaApplicationPrimerosPasosHibernate {

    public static void main(String[] args) {
        //tengo que guardar los telefonos y despues guardo las personas y hibernate cuando guarda las personas actualiza las fk de los telefonos
        SessionFactory factory = NewHibernateUtil.getSessionFactory();        
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        
        long idbuscar = 3;
        Persona persona = (Persona)session.load(Persona.class, idbuscar);
        
        
        Telefono t3 = new Telefono();
        t3.setNumero("1654685765");
        persona.getTelefonos().add(t3);
        session.save(persona);
                
        
        /*Persona persona = new Persona();
        persona.setNombre("unNombre");
        persona.setApellido("unApellido");
        
        
        
        Telefono telefono = new Telefono();
        telefono.setNumero("32165468");
        session.save(telefono);
        
        Telefono telefono1 = new Telefono();
        telefono1.setNumero("454654654");
        session.save(telefono1);
        
        persona.getTelefonos().add(telefono);
        persona.getTelefonos().add(telefono1);
        
        session.save(persona);
        transaction.commit();
*/
        session.close();
        factory.close();
        
    }
    
    public static void borrar(Persona persona){
        
    }

}
