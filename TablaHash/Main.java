package TablaHash;
import java.util.Scanner;


public class Main {

    public static void asigna(TablaDispersion tabla, Scanner input)
    {
        
        String nombre, descripcion, id;
        int estado=0, op=0, i=0, bandera = 0, encontrado=0;
        boolean esAlta = false;
       

        for(i=0;i<101;i++)
        {
            if(bandera == 0)
            {
                
                System.out.println("Tarea:");
                System.out.println("Ingrese el nombre:");
                nombre = input.nextLine();

                System.out.println("Ingrese la descripcion:");
                descripcion = input.nextLine();

                System.out.println("Ingrese el ID de la tarea:");
                id = input.nextLine();


                encontrado = tabla.buscar(id);
                while(encontrado != -1|| id.length()<5 || id.length()>10)
                {
                    System.out.println("ERROR. Ese ID ya existe o el ID debe tener entre 5-10 caracteres, vuelva a intentarlo:");
                    id = input.nextLine();

                    encontrado = tabla.buscar(id);
                }

                System.out.println("Ingrese el estado: 1- Pendiente  2-En progreso 3-Finalizada");
                while(!input.hasNextInt())
                {
                    System.out.println("ERROR. Debe ingresar un numero, vuelva a intentarlo: ");
                    input.next();
                }
                estado = input.nextInt();

                while(estado<1 || estado>3)
                {
                    System.out.println("ERROR. Esa opcion no existe, vuelva a intentarlo:");
                    estado = input.nextInt();
                }
                input.nextLine();

                
                esAlta = true;

                Tarea instanciaTarea = new Tarea(nombre, descripcion, estado, esAlta, id);
                esAlta = tabla.insertar(instanciaTarea);

                if(esAlta == true)
                {
                    System.out.println("¡SE INSERTO UNA TAREA CORRECTAMENTE!");
                }

                System.out.println("¿Desea seguir cargando tareas?");
                System.out.println("1. Si 2.No");
                while(!input.hasNextInt())
                {
                    System.out.println("ERROR. Debe ingresar un numero.");
                    input.next();
                }
                op = input.nextInt();
                while(op<1 || op>2)
                {
                    System.out.println("ERROR. Esa opcion no existe, vuelva a intentarlo:");
                    op = input.nextInt();
                }
                input.nextLine();
                
                if(op==2)
                {
                    bandera=1;
                    break;
                }
                
            }
        }
        

    }
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int op=0;
        boolean bandera = false;
        
        

        TablaDispersion tabla = new TablaDispersion();

        do {
            System.out.println("-----MENU-----");
            System.out.println("0). Para salir del menu.");
            System.out.println("1). Para agregar una tarea.");
            System.out.println("2). Para eliminar una tarea.");
            System.out.println("3). Ver tareas.");
            System.out.println("4). Dar de alta una tarea eliminada.");
            System.out.println("5). Modificar una tarea.");

        
            while(!scanner.hasNextInt())
            {
                System.out.println("ERROR. Debe ingresar un numero.");
                scanner.next();

            }
            op = scanner.nextInt();

            while(op<0 || op>5)
            {
                System.out.println("ERROR. Esa opcion no existe. Vuelva a intentarlo: ");
                op = scanner.nextInt();
            }
            scanner.nextLine();

            switch (op) {
                case 1:

                    asigna(tabla, scanner);

                    bandera = true;
                break;

                case 2:
                    if(bandera == true)
                    {
                        
                        tabla.eliminar(scanner);

                        
                    }
                    else
                    {
                        System.out.println("ERROR. Para continuar debe agregar al menos una tarea:");
                    }

                break;

                case 3:
                    if(bandera == true)
                    {
                        System.out.println("\n---LISTA DE TAREAS---");
                        tabla.verDatos();
                        System.out.println("----------------\n");
                    }
                    else
                    {
                            System.out.println("ERROR. Para continuar debe agregar al menos una tarea:");
                    }

                break;
                case 4:

                    if(bandera == true)
                    {
                        tabla.darAlta(scanner);
                    }
                    else
                    {
                            System.out.println("ERROR. Para continuar debe agregar al menos una tarea:");
                    }

                break;

                case 5:

                    if(bandera == true)
                    {
                        tabla.modificarTarea(scanner);
                    }
                    else
                    {
                            System.out.println("ERROR. Para continuar debe agregar al menos una tarea:");
                    }

                break;
            }


            
        } while (op!=0);

        scanner.close();
    }
}
