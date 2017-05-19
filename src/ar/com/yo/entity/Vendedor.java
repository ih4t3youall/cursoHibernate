/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.yo.entity;

import java.util.Date;
import javax.persistence.Entity;

/**
 *
 * @author educacionit
 */
@Entity
public class Vendedor extends Persona{

    private String legajo;
    private Date fechaIngreso;

    public Vendedor() {
    }

    public Vendedor(String legajo, Date fechaIngreso) {
        this.legajo = legajo;
        this.fechaIngreso = fechaIngreso;
    }

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    
    
            
    
}
