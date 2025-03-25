
import java.util.Scanner;


class Persona {
    private  String nombre;
    private int edad;

    //constructor: inicializa atributos y crea un objeto persona
    public Persona (String nombre, int edad)
    {
        this.nombre = nombre; //this.nombre se refiere al atributo de la clase y nombre(sin this.) es el parametro recibido en el constructor
        this.edad = edad;
    }
    //Getters (accesores)

    public String getNombre()
    {
        return nombre;
    }

    public int getEdad()
    {
        return edad;
    }

    //Setters (modificadores)

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    
    public void setEdad(int edad)
    {
        this.edad = edad;
    }

}

public class Ejercicio1
{

    public static void inicializarDatos(Persona[] personas)
    {
        int i=0;

        for(i=0;i<personas.length;i++)
        {
            personas[i] = new Persona("", 0);

        }

    }

    public static void cargarPersona(Persona[] personas)
    {
        Scanner scanner = new Scanner(System.in);
        int i=0, op=0, edad=0;
        String nombre;
        
        for(i=0;i<personas.length;i++)
        {
            if(personas[i] == null || personas[i].getEdad() == 0)
            {
                System.out.printf("Ingrese los datos de la persona n°%d: \n", i+1);
                System.out.println("NOMBRE:");
                nombre = scanner.nextLine();

                do
                {
                    System.out.println("EDAD:");
                        while(!scanner.hasNextInt())
                        {
                            System.out.println("ERROR. No ingreso un numero valido, vuelva a intentarlo.");
                            scanner.next();
                        }
                        edad = scanner.nextInt();
                        scanner.nextLine();

                        if(edad<1)
                        {
                            System.out.println("ERROR. La edad debe ser mayor que 0, vuelva a intentarlo:");
                        }

                }while(edad<1);

                personas[i] = new Persona(nombre, edad);

                    
                if( i < personas.length-1)
                {
                    
                    do
                    {
                        System.out.println("¿Desea seguir cargando? 1/SI 2/NO");    
                        while(!scanner.hasNextInt())
                        {
                            System.out.println("ERROR. No ingresó un numero invalido, vuelva a intentarlo. \n");
                            scanner.next();
                        }
                        op = scanner.nextInt();
                        scanner.nextLine();
                        if(op!=1 && op!=2)
                        {
                            System.out.println("ERROR. Esa opcion no existe, vuelva a intentarlo:");
                        }

                    }while(op!=1 && op!=2);

                        
                        
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

            if(personas[i].getEdad() != 0)
            {
                System.out.printf("Nombre: %s -- edad: %d \n", personas[i].getNombre(), personas[i].getEdad());
            }

        }

    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Persona[] personas = new Persona[3];
        inicializarDatos(personas);
        
        int op=0;
        boolean bandera = false;

        do
        {
            System.out.println("\nMENÚ:");
            System.out.println("0. Salir");
            System.out.println("1. Cargar los datos");
            System.out.println("2. Ver los datos");
            System.out.println("Seleccione una opción: ");

            do
            {
                while(!scanner.hasNextInt())
                {
                    System.out.println("ERROR. No ingreso un numero valido, vuelva a intentarlo:");
                    scanner.next();
                    
                }
                
                op = scanner.nextInt();
                scanner.nextLine();

                if(op<0 || op>2)
                {
                    System.out.println("ERROR. Esa opción no existe, vuelva a intentarlo:");
                }

            }while(op<0 || op>2);
            
                
            
            switch (op) {
                    case 1:

                        cargarPersona(personas);
                        bandera = true;
                    break;
                    case 2:

                        if(bandera)
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