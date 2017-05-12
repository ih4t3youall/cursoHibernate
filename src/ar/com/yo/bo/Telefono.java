package ar.com.yo.bo;

import java.util.Objects;
import javax.persistence.*;

@Entity
public class Telefono {

    public Telefono() {
    }

    public Telefono(String numero) {
        this.numero = numero;
    }

    @Id
    @GeneratedValue
    private long id;
    private String numero;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 97 * hash + Objects.hashCode(this.numero);
        return hash;
    }

    @Override
    public String toString() {
        return "Telefono{" + "id=" + id + ", numero=" + numero + '}';
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
        final Telefono other = (Telefono) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        return true;
    }

}
