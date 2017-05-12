package ar.com.yo.bo;

import java.util.Date;
import java.util.Objects;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "Personas")
public class Persona {

    public Persona() {
    }

    
    
    @Id
    @GeneratedValue
    private long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Direccion direccion;
    
    private String nombre;
    private String apellido;
    @Column(length = 500, name = "segundoNombre", unique = false) //tiene mas weas
    private String segundoNombre;
    @Transient // no entra dentro del contexto de hibernate osea nunca sera persistido
    private int ejemploTmp;
    @Basic(fetch = FetchType.LAZY) //le digo como levantar este campo, hasta que no haga getNotas, no va a hacer el select ojo que son dos select, uno para la persona y otro despues para las notas
    private String notas;
    @Temporal(TemporalType.TIME)
    java.util.Date tiempo;
//    @Enumerated(EnumType.STRING) ara enums
//    @Embebed @Embedebbeable para hacer dos objetos de una misma tabla
    //todas las colecciones son lazy por defecto todo lo que no sea conexion es eager por defecto
    //ver ExtraLazy

    //con el eager , le digo que levante todo de una, nada que ver con cascade, es solo para levantar datos
    //cascade all hace para los hijos
    //attach cuando hacemos new y no lo guardamos, para hibernate es transient (sin nocion de existencia) con save o saveOrUpdate ya deja de ser transiet 
    //despues de save or update pasa a persistent, esta dentro del contextod e hibernate
    // esto significa que esta mappeado por el atributo persona que existe en telefono
    @OneToMany(mappedBy = "persona")
    private List<Telefono> telefonos = new ArrayList<Telefono>();

    @ManyToMany
    private List<Localidad> localidades = new ArrayList<Localidad>();
    

    public List<Localidad> getLocalidades() {
        return localidades;
    }

    public void setLocalidades(List<Localidad> localidades) {
        this.localidades = localidades;
    }

    public List<Telefono> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<Telefono> telefonos) {
        this.telefonos = telefonos;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    
    
    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the ejemploTmp
     */
    public int getEjemploTmp() {
        return ejemploTmp;
    }

    /**
     * @return the segundoNombre
     */
    public String getSegundoNombre() {
        return segundoNombre;
    }

    /**
     * @param segundoNombre the segundoNombre to set
     */
    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    /**
     * @param ejemploTmp the ejemploTmp to set
     */
    public void setEjemploTmp(int ejemploTmp) {
        this.ejemploTmp = ejemploTmp;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public Date getTiempo() {
        return tiempo;
    }

    public void setTiempo(Date tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 17 * hash + Objects.hashCode(this.nombre);
        hash = 17 * hash + Objects.hashCode(this.apellido);
        hash = 17 * hash + Objects.hashCode(this.segundoNombre);
        hash = 17 * hash + this.ejemploTmp;
        hash = 17 * hash + Objects.hashCode(this.notas);
        hash = 17 * hash + Objects.hashCode(this.tiempo);
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
        final Persona other = (Persona) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.ejemploTmp != other.ejemploTmp) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellido, other.apellido)) {
            return false;
        }
        if (!Objects.equals(this.segundoNombre, other.segundoNombre)) {
            return false;
        }
        if (!Objects.equals(this.notas, other.notas)) {
            return false;
        }
        if (!Objects.equals(this.tiempo, other.tiempo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", segundoNombre=" + segundoNombre + ", ejemploTmp=" + ejemploTmp + ", notas=" + notas + ", tiempo=" + tiempo + '}';
    }

}
