package ejercicioAyEDII1;

public class Person {
    int id;
    String nombre;
    String descripcion;
    String estado;

    public static void inicializarDatos(Person listado[])
    {
        int i=0;

        for(i=0;i<listado.length;i++)
        {
            listado[i]= new Person();
        }
    }
}
