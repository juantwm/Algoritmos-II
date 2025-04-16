package ejercicioAyEDII1;

import java.util.Scanner;

public class Person {
    
    private String nombre;
    private String descripcion;
    private int id;
    private String estado;

    /* public static void inicializarDatos(Person listado[])
    {
        int i=0;

        for(i=0;i<listado.length;i++)
        {
            listado[i]= new Person();
        }
    }*/

    //CONSTRUCTOR
    public Person(String nombre, String descripcion, int id)
    {
        
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.id += id;
        this.estado = "PENDIENTE";
    }
     
    //GETTERS
    public String getNombre()
    {
        return nombre;
    }
    public String getDescripcion()
    {
        return descripcion;
    }
    public int getId()
    {
        return id;
    }
    public String getEstado()
    {
        return estado;
    }

    //SETTERS 
    
    public void setNombre(String nombre)
    {
        this.nombre=nombre;
    }
    public void setDescripcion(String descripcion)
    {
        this.descripcion= descripcion;
    }
    public void setId(int id)
    {
        this.id=id;
    }
    public void setEstado(String estado)
    {
        this.estado=estado;
    }

    public static void cargarTareas(Person[] persona)
    {
        Scanner scanner = new Scanner(System.in);
        int op=0, i=0;
        String nombre, descripcion;

        for(i=0;i<persona.length;i++)
        {
            if(persona[i] == null)
            {
                System.out.println("Ingrese el nombre de la tarea:");
                nombre = scanner.nextLine();

                System.out.println("Ingrese la descripcion de la tarea:");
                descripcion = scanner.nextLine();

                persona[i] = new Person(nombre, descripcion, i+1);
                
                if(i<persona.length-1)
                {
                    System.out.println("Desea seguir cargando? 1/SI 2/NO");
                    op = scanner.nextInt();

                    while(op<1 || op>2)
                    {
                        System.out.println("ERROR. Esa opcion no existe, vuelva a intentarlo:");
                        op = scanner.nextInt();
                    }
                    if(op==2)
                    {
                        break;
                    }

                }
                else
                {
                    System.out.println("¡No hay mas espacio para cargar!");
                }
            }
           

            
        }

        
    }

    public static int validarId(Person[] persona, int idBuscado)
    {
        int i=0;

        for(i=0;i<persona.length;i++)
        {
            if(persona[i]!=null && persona[i].getId() == idBuscado)
            {
                return 1;
            }

        }
        return 0;

    }
    public static void modificarTarea(Person[] persona)
    {
        Scanner scanner = new Scanner(System.in);
        int i=0, op=0, idBuscado=0, resultado=0;

        System.out.println("Ingrese el ID de la tarea que desea modificar:");
        idBuscado = scanner.nextInt();

        resultado = Person.validarId(persona, idBuscado);

        while(resultado != 1)
        {
            System.out.println("ERROR. Ese ID no existe, vuelva a intentarlo:");
            idBuscado = scanner.nextInt();

            resultado = Person.validarId(persona, idBuscado);
        }
        System.out.println("Elija el estado de la tarea:");
        System.out.println("1/ PENDIENTE 2/ FINALIZADO 3/ EN CURSO 4/ CANCELADA");
        op = scanner.nextInt();
        while(op<1 || op>4)
        {
            System.out.println("ERROR. No existe esa opcion, vuelva a intentarlo:");
            System.out.println("Elija el estado de la tarea:");
            System.out.println("1/ PENDIENTE 2/ FINALIZADO 3/ EN CURSO 4/ CANCELADA");
            op = scanner.nextInt();
        }

        switch(op)
        {
            case 1:
                for(i=0;i<persona.length;i++)
                {
                    if(persona[i] != null && persona[i].getId() == idBuscado)
                    {
                        persona[i].setEstado("PENDIENTE");
                    }
                }
            break;
            case 2:
                
                for(i=0;i<persona.length;i++)
                {
                    if(persona[i] != null && persona[i].getId() == idBuscado)
                    {
                        persona[i].setEstado("FINALIZADO");
                    }
                }
            break;
            case 3:

                for(i=0;i<persona.length;i++)
                {
                    if(persona[i] != null && persona[i].getId() == idBuscado)
                    {
                        persona[i].setEstado("EN CURSO");
                    }
                }
            break;
            case 4:

                for(i=0;i<persona.length;i++)
                {
                    if(persona[i] != null && persona[i].getId() == idBuscado)
                    {
                        persona[i].setEstado("CANCELADA");
                    }
                }
            break;
        }
    }

    public static void verTareas(Person [] persona)
    {
        int i=0;
        System.out.println("LISTA DE TAREAS:");
        for(i=0;i<persona.length;i++)
        {
            if(persona[i] != null)
            {
                System.out.printf("Tarea n°%d: \n", i+1);
                System.out.printf("Nombre: %s \n", persona[i].getNombre());
                System.out.printf("Descripcion: %s \n", persona[i].getDescripcion());
                System.out.printf("Estado: %s \n", persona[i].getEstado());
                System.out.printf("ID: %d \n", persona[i].getId());
            }    
        }
    }
}
