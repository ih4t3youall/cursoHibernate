/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationprimerospasoshibernate;

import ar.com.yo.bo.Director;
import ar.com.yo.bo.Empleado;
import ar.com.yo.bo.Persona;
import ar.com.yo.hibernate.NewHibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author educacionit
 */
class Inicio {

    SessionFactory factory = NewHibernateUtil.getSessionFactory();

    public Inicio() {

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        
        Empleado emp = new Empleado(110, "nombreEmpleado", "apellidoEmpleado");
        Director direct= new Director("areaDirector", "Nombre Director", "apelldo director");
        
        
        session.save(emp);
        session.save(direct);
        transaction.commit();
        session.close();
        factory.close();

    }

    public void borrar(Persona persona){
        
        
        
    }
    
}
