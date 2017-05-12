package javaapplicationprimerospasoshibernate;

import ar.com.yo.bo.Direccion;
import ar.com.yo.bo.Localidad;
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
//        Persona persona = (Persona)session.load(Persona.class, idbuscar);
        
        
        /*Telefono t3 = new Telefono();
        t3.setNumero("1654685765");
        persona.getTelefonos().add(t3);*/
        
        Persona persona = new Persona();
        persona.setNombre("martin1");
        persona.setApellido("trump1");
        session.save(persona);
        
        
        Direccion direccion = new Direccion();
        direccion.setCalle("una calle");
        
        Direccion direccion1 = new Direccion();
        direccion.setCalle("una calle");
        
        direccion.setPersona(persona);
        direccion1.setPersona(persona);
        
        
        persona.setDireccion(direccion);
        session.save(direccion);
                
        
        Telefono tel = new Telefono();
        Telefono tel2 = new Telefono();
        tel.setNumero("123654");
        tel2.setNumero("123654789");
        
        session.save(tel);
        session.save(tel2);
        tel.setPersona(persona);
        tel2.setPersona(persona);
        persona.getTelefonos().add(tel);
        persona.getTelefonos().add(tel);
                
        Localidad localidad = new Localidad();
        localidad.setNombre("nombre localidad 3");
        Localidad localidad1 = new Localidad();
        localidad1.setNombre("nombre localidad 4");
        session.save(localidad);
        session.save(localidad1);
        
        persona.getLocalidades().add(localidad);
        persona.getLocalidades().add(localidad1);
        localidad.getPersonas().add(persona);
        localidad1.getPersonas().add(persona);
        
        
                
        
        
                
        
        
        
        
        
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
        transaction.commit();
        session.close();
        factory.close();
        
    }
    
    public static void borrar(Persona persona){
        
    }

}
