
import java.util.Scanner;


class Persona
{
    String nombre;
    int edad;
}

public class Ejercicio1
{

    public static void inicializarDatos(Persona[] personas)
    {
        int i=0;

        for(i=0;i<personas.length;i++)
        {
            personas[i] = new Persona();

        }

    }
    public static void cargarPersona(Persona[] personas)
    {
        Scanner scanner = new Scanner(System.in);
        int i=0, op=0;
        
        for(i=0;i<personas.length;i++)
        {
            if(personas[i].edad == 0)
            {
                System.out.printf("Ingrese los datos de la persona n°%d: \n", i+1);
                System.out.println("NOMBRE:");
                personas[i].nombre = scanner.nextLine();
                System.out.println("EDAD:");
                personas[i].edad = scanner.nextInt();
                    while(personas[i].edad < 1)
                    {
                        System.out.println("ERROR. La edad deber ser mayor a 0, vuelva a intentarlo.");
                        personas[i].edad = scanner.nextInt();

                    }
                if( i < personas.length-1)
                {
                    System.out.println("¿Desea seguir cargando? 1/SI 2/NO");    
                    op = scanner.nextInt();

                        while(op<1 || op>2)
                        {
                            System.out.println("ERROR. Esa opcion no existe, vuelva a intentarlo. \n");
                            op = scanner.nextInt();
                        }
                    if(op == 2)
                    {
                        break;
                    }

                }
                else
                {
                    System.out.println("ERROR. No hay mas espacio para agregar personas.");
                }

            }
        }
        
    }

    public static void mostrarDatos(Persona[] personas)
    {
        int i=0;
        System.out.println("----------PERSONAS CARGADAS----------: \n");
        for(i=0;i<personas.length;i++)
        {

            if(personas[i].edad != 0)
            {
                System.out.printf("Nombre: %s -- edad: %d \n", personas[i].nombre, personas[i].edad);
            }

        }

    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Persona[] personas = new Persona[3];
        inicializarDatos(personas);
        
        int op=0, bandera=0;

        do
        {
            System.out.println("0. Para salir del menu.");
            System.out.println("1. Para cargar los datos.");
            System.out.println("2. Para ver los datos.");
            op = scanner.nextInt();
                while(op<0 || op>2)
                {
                    System.out.println("ERROR. Esa opcion no existe, vuelva a intentarlo:");
                    op = scanner.nextInt();
                }
            
            switch (op) {
                    case 1:

                        cargarPersona(personas);
                        bandera = 1;
                    break;
                    case 2:

                        if(bandera==1)
                        {
                           
                            mostrarDatos(personas);
                        }
                        else
                        {

                            System.out.println("ERROR. Para continuar debe cargar los datos.");
                        }

                    
                    break;
            
                
            }


        }while(op!=0);
        
        scanner.close();

    }
    

}