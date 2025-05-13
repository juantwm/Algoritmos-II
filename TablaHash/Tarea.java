package TablaHash;
public class Tarea {

    private String nombre;
    private String descripcion;
    private int estado;
    private boolean esAlta;
    private String id;

    public Tarea(String nombre, String descripcion, int estado, boolean esAlta, String id)
    {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.esAlta = esAlta;
        this.id = id;

    }

    public String getNombre()
    {
        return nombre;
    }
    public String getDescripcion()
    {
        return descripcion;
    }
    public int getEstado()
    {
        return estado;
    }
    public boolean getEsAlta()
    {
        return esAlta;
    }
    public String getId()
    {
        return id;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }
    public void setEstado(int estado)
    {
        this.estado = estado;
    }
    public void setEsAlta(boolean esAlta)
    {
        this.esAlta = esAlta;
    }
    public void setId(String id)
    {
        this.id=id;
    }

     @Override
    public String toString() {
        return "Tarea [" +
               "ID='" + id + '\'' +
               ", Nombre='" + nombre + '\'' +
               ", Descripción='" + descripcion + '\'' +
               ", Estado=" + estadoToString() +
               ", esAlta=" + esAlta +
               ']';
    }

    private String estadoToString() {
        switch (estado) {
            case 1: return "Pendiente";
            case 2: return "En Progreso";
            case 3: return "Finalizada";
            default: return "Desconocido";
        }
    }
}


