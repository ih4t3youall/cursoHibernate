/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationprimerospasoshibernate;

import ar.com.yo.entity.Auto;
import ar.com.yo.entity.Persona;
import ar.com.yo.hibernate.NewHibernateUtil;
import java.util.List;
import jdk.nashorn.internal.objects.NativeArray;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author educacionit
 */
class InicioHql {

    public InicioHql() {
        
        
        SessionFactory sf =NewHibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        
        Query query = session.createQuery("from Persona as p order by p.nombre");
        List<Persona> personas = query.list();
        
        System.out.println("javaapplicationprimerospasoshibernate.InicioHql.<init>()");
        recorrer(personas);
        
        Query query2 =session.createQuery("from Personas as p where p.id = :idBuscar");
        query2.setLong("idBuscar", 1l);
        Persona persona2 = (Persona) query2.uniqueResult();
        System.out.println("persona nombre:"+persona2.getId());
        
        
        Query query3 =session.createQuery("from Auto as a where a.concesionario.id =:idConcesionario");
        query3.setParameter("idConcesionario", 1l);
        List<Auto> auto = query3.list();
        
//        levanto la marca del auto sin levantar la concecionaria
        Query query4 = session.createQuery("select a.marca from Auto as a where a.id =:idBuscar");
        query4.setLong("idBuscar", 1);
        Auto auto1 = (Auto)query4.uniqueResult();
            
//        busca una coleccion de autos en cocesionaria
        Query query5 = session.createQuery("select c.autos from Concesionarios as c where c.id = :idbuscar");
        query5.setLong("idbuscar", 1l);
        List<Auto> auto2 = query5.list();
        
        
        //esta no va a andar porque la entidad persona se refiere a la vieja
        Query query6 = session.createQuery("from Persona as p join p.telefonos as t where t.numero like :numeroBuscar");
        query6.setString("numeroBuscar", "455%");
        List<Persona> personas2 = query6.list();
        
//        quiero el nombre de una persona espesifica
        Query query7 = session.createQuery("select p.nombre from Persona as p where .id = :idbuscar");
        query7.setLong("numeroBuscar", 1);
        String personas23 =(String) query6.uniqueResult();
        
        //me traigo dos cmapos y me devuelve un array de una persona
        Query query8 = session.createQuery("select p.nombre, p.apellido from Persona as p where .id = :idbuscar");
        query8.setLong("numeroBuscar", 1);
        String personas24 =(String) query8.uniqueResult();
        
        
        //me traigo dos cmapos de todas las personas, devuelve un list y dentro del list un campo con vectores
        Query query9 = session.createQuery("select p.nombre, p.apellido from Persona ");
        query8.setLong("numeroBuscar", 1);
        List<Object[]> rows =(List<Object[]>) query8.list();
        
        
        
        
        
        transaction.commit();
        session.close();
        sf.close();
        
    }
    
    public void recorrer (List<Persona> personas){
        for(Persona p : personas){
            System.out.println("persona.nombre = "+p.getNombre());
        }
        System.out.println("javaapplicationprimerospasoshibernate.InicioHql.recorrer()");
        
    }
    
}
