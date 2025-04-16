package ejercicioAyEDII1;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    
    Scanner scanner = new Scanner(System.in);
    Person[] persona= new Person[2];
    
        int op=0;
        boolean bandera = false;

        do
        {
            System.out.println("\nMENÚ:");
            System.out.println("0. Salir");
            System.out.println("1. Cargar tarea");
            System.out.println("2. Modifidicar tarea");
            System.out.println("3. Para ver las tareas");
            System.out.println("Seleccione una opción: ");

            do
            {
                while(!scanner.hasNextInt())
                {
                    System.out.println("ERROR. No ingreso un numero valido, vuelva a intentarlo:");
                    scanner.nextInt();
                    
                }
                
                op = scanner.nextInt();
                scanner.nextLine();

                if(op<0 || op>3)
                {
                    System.out.println("ERROR. Esa opción no existe, vuelva a intentarlo:");
                }

            }while(op<0 || op>3);
            
                
            
            switch (op) {
                    case 1:

                        Person.cargarTareas(persona);
                        
                        bandera = true;
                    break;
                    case 2:

                        if(bandera)
                        {
                           
                            Person.modificarTarea(persona);
                           
                        }
                        else
                        {

                            System.out.println("ERROR. Para continuar debe cargar los datos.");
                        }

                    
                    break;
                    case 3:

                        if(bandera)
                        {
                           
                            Person.verTareas(persona);
                           
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
