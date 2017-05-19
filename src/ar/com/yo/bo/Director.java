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
public class Director extends Persona {

    public String area;

    public Director(String area,String nombre, String apellido) {
        this.area = area;
        
        super.setNombre(nombre);
        super.setApellido(apellido);
    }

    
    
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

}
