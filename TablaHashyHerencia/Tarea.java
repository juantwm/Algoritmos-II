public class Tarea extends Registro {

    private int estado; // 1-Pendiente, 2-En progreso, 3-Finalizada

    public Tarea(String id, String nombre, String descripcion, int estado, boolean esAlta) {
        // Llama al constructor de la clase padre (Registro)
        super(id, nombre, descripcion, esAlta);
        this.estado = estado;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    // Sobrescribe el método toString para incluir la información de Tarea
    @Override
    public String toString() {
        return "Tarea [" +
            super.toString() + // Llama al toString de la clase padre para los atributos comunes
            ", Estado=" + estadoToString() +
            ']';
    }

    // Método auxiliar para convertir el estado numérico a String
    private String estadoToString() {
        switch (estado) {
            case 1: return "Pendiente";
            case 2: return "En Progreso";
            case 3: return "Finalizada";
            default: return "Desconocido";
        }
    }
}