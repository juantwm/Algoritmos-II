
public class Notita extends Registro {

    private String color;

    public Notita(String id, String nombre, String descripcion, String color, boolean esAlta) {
        // Llama al constructor de la clase padre (Registro)
        super(id, nombre, descripcion, esAlta);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Sobrescribe el método toString para incluir la información de Notita
    @Override
    public String toString() {
        return "Notita [" +
               super.toString() + // Llama al toString de la clase padre para los atributos comunes
            ", Color='" + color + '\'' +
            ']';
    }
}