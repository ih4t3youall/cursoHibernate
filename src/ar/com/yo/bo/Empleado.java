/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.yo.bo;

import javax.persistence.Entity;

/**
 *
 * @author educacionit
 */
@Entity
public class Empleado extends Persona{

    private int sueldo;

    public Empleado(int sueldo,String nombre,String apellido) {
        this.sueldo = sueldo;
        
        super.setNombre(nombre);
        super.setApellido(apellido);
    }

    
    
    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

}
