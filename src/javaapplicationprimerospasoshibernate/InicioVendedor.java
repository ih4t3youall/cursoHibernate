/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationprimerospasoshibernate;

import ar.com.yo.entity.Auto;
import ar.com.yo.entity.Concesionario;
import ar.com.yo.entity.Vendedor;
import ar.com.yo.hibernate.NewHibernateUtil;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author educacionit
 */
class InicioVendedor {

    public InicioVendedor() {
        
        
        SessionFactory sf =NewHibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        
        Vendedor vendedor = new Vendedor("123564", new Date());
        vendedor.setNombre("jose");
        vendedor.setApellido("ivatis");
        vendedor.setDireccion("una calle");
        session.save(vendedor);
        transaction.commit();
        session.close();
        sf.close();
        
    }
    
}
