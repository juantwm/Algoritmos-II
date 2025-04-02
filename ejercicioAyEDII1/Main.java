package ejercicioAyEDII1;

public class Main {
    public static void main(String[] args) {
        
        Person listado[] = new Person[2];
        Person.inicializarDatos(listado);

        int i=0;

        listado[0].id= 1;
        listado[0].nombre= "Gaston";
        listado[0].descripcion = "Resumen AyEDII";
        listado[0].estado= "Pendiente";
        listado[1].id= 2;
        listado[1].nombre= "Santiago";
        listado[1].descripcion = "Preparación del final de fisica";
        listado[1].estado= "Finalizada";

        for(i=0;i<2;i++)
        {   

            System.out.println("*******************************************************");
            System.out.printf("Nombre: %s \n", listado[i].nombre);
            System.out.printf("Descripción: %s \n", listado[i].descripcion);
            System.out.printf("Estado: %s \n", listado[i].estado);
            System.out.printf("ID: %d \n", listado[i].id);
            


        }
    }
}
