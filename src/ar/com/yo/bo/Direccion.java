package ar.com.yo.bo;

import java.util.Objects;
import javax.persistence.*;

@Entity
public class Direccion {

    @Id
    @GeneratedValue
    private long id;
    
    @OneToOne(mappedBy = "direccion")
    private Persona persona;

    @Override
    public String toString() {
        return "Direccion{" + "id=" + id + ", calle=" + calle + '}';
    }
    private String calle;

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Direccion() {
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 29 * hash + Objects.hashCode(this.calle);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Direccion other = (Direccion) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.calle, other.calle)) {
            return false;
        }
        return true;
    }

}
