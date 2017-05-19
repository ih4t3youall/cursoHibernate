/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationprimerospasoshibernate;

import ar.com.yo.entity.Auto;
import ar.com.yo.entity.Concesionario;
import ar.com.yo.hibernate.NewHibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author educacionit
 */
class InicioAuto {

    public InicioAuto() {
        
        
        
        SessionFactory sf =NewHibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        Concesionario conse = new Concesionario();
        
        conse.setNombre("nombreConcesionario");
        conse.setDireccion("asdasd");
        session.save(conse);
        
        Auto a = new Auto();
        a.setMarca("a");
        a.setModelo("b");
        a.setConcesionario(conse);
        conse.getAutos().add(a);
        session.save(a);
        
        a = new Auto();
        a.setMarca("a");
        a.setModelo("b");
        a.setConcesionario(conse);
        conse.getAutos().add(a);
        session.save(a);
        
        transaction.commit();
        session.close();
        sf.close();
    }
    
}
