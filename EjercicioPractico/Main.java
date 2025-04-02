package EjercicioPractico;

import java.util.Scanner;




public class Main
{

    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Persona[] personas = new Persona[3];
        Persona.inicializarDatos(personas);
        
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

                        Persona.cargarPersona(personas);
                        bandera = true;
                    break;
                    case 2:

                        if(bandera)
                        {
                           
                            Persona.mostrarDatos(personas);
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