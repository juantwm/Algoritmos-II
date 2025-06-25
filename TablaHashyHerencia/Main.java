import java.util.Scanner;


public class Main {

    public static void asigna(TablaDispersion tabla, Scanner input) {
        String nombre, descripcion, id, color;
        int estado = 0, tipoRegistro = 0;
        int bandera = 0; 

        for (int i = 0; i < 101; i++) {
            if (bandera == 0) {
                System.out.println("\n--- Nuevo Registro ---");

                System.out.println("¿Qué tipo de registro desea agregar?");
                System.out.println("1. Tarea");
                System.out.println("2. Notita");
                while (!input.hasNextInt()) {
                    System.out.println("ERROR. Debe ingresar un número.");
                    input.next();
                }
                tipoRegistro = input.nextInt();
                while (tipoRegistro < 1 || tipoRegistro > 2) {
                    System.out.println("ERROR. Esa opción no existe, vuelva a intentarlo:");
                    tipoRegistro = input.nextInt();
                }
                input.nextLine(); // Consumir el salto de línea

                System.out.println("Ingrese el nombre:");
                nombre = input.nextLine();

                System.out.println("Ingrese la descripción:");
                descripcion = input.nextLine();

                System.out.println("Ingrese el ID del registro (5-10 caracteres):");
                id = input.nextLine();

                // Valida que el ID no exista y cumpla con la longitud
                Registro registroExistente = tabla.buscar(id);
                while (registroExistente != null || id.length() < 5 || id.length() > 10) {
                    if (registroExistente != null) {
                        System.out.println("ERROR. Ese ID ya existe. Vuelva a intentarlo:");
                    } else {
                        System.out.println("ERROR. El ID debe tener entre 5 y 10 caracteres. Vuelva a intentarlo:");
                    }
                    id = input.nextLine();
                    registroExistente = tabla.buscar(id);
                }

                boolean esAlta = true; 

                if (tipoRegistro == 1) { // Es una Tarea
                    System.out.println("Ingrese el estado: 1- Pendiente  2-En progreso 3-Finalizada");
                    while (!input.hasNextInt()) {
                        System.out.println("ERROR. Debe ingresar un número, vuelva a intentarlo: ");
                        input.next();
                    }
                    estado = input.nextInt();
                    while (estado < 1 || estado > 3) {
                        System.out.println("ERROR. Esa opción no existe, vuelva a intentarlo:");
                        estado = input.nextInt();
                    }
                    input.nextLine(); 

                    Tarea nuevaTarea = new Tarea(id, nombre, descripcion, estado, esAlta);
                    if (tabla.insertar(nuevaTarea)) {
                        System.out.println("¡SE INSERTÓ UNA TAREA CORRECTAMENTE!");
                    } else {
                        System.out.println("ERROR AL INSERTAR LA TAREA.");
                    }

                } else { // Es una Notita
                    System.out.println("Ingrese el color de la notita:");
                    color = input.nextLine();

                    Notita nuevaNotita = new Notita(id, nombre, descripcion, color, esAlta);
                    if (tabla.insertar(nuevaNotita)) {
                        System.out.println("¡SE INSERTÓ UNA NOTITA CORRECTAMENTE!");
                    } else {
                        System.out.println("ERROR AL INSERTAR LA NOTITA.");
                    }
                }

                System.out.println("¿Desea seguir cargando registros (Tareas/Notitas)?");
                System.out.println("1. Si 2.No");
                while (!input.hasNextInt()) {
                    System.out.println("ERROR. Debe ingresar un número.");
                    input.next();
                }
                int op = input.nextInt();
                while (op < 1 || op > 2) {
                    System.out.println("ERROR. Esa opción no existe, vuelva a intentarlo:");
                    op = input.nextInt();
                }
                input.nextLine(); 

                if (op == 2) {
                    bandera = 1;
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
