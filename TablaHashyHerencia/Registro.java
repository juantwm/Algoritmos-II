
import java.time.LocalDate; 

public abstract class Registro {

    private String id;
    private String nombre;
    private String descripcion;
    private boolean esAlta;
    private LocalDate fechaCreacion; 

    public Registro(String id, String nombre, String descripcion, boolean esAlta) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.esAlta = esAlta;
        this.fechaCreacion = LocalDate.now(); 
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean getEsAlta() {
        return esAlta;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEsAlta(boolean esAlta) {
        this.esAlta = esAlta;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    // Método abstracto 
    
    @Override
    public String toString() {
        return "ID='" + id + '\'' +
            ", Nombre='" + nombre + '\'' +
            ", Descripción='" + descripcion + '\'' +
            ", Estado de Alta=" + (esAlta ? "Activo" : "Eliminado") +
            ", Fecha de Creación=" + fechaCreacion;
    }
}
