package PracticoN1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Perfume[] perfume = new Perfume[1000]; 
        
        int op=0;
        boolean bandera = false;

        do
        {
            System.out.println("\nMENÚ:");
            System.out.println("0. Salir");
            System.out.println("1. Cargar un perfume");
            System.out.println("2. Ver los datos de un perfume");
            System.out.println("3. Modificar los datos de un perfume");
            System.out.println("4. Eliminar los datos de un perfume");
            System.out.println("5. Para dar de alta un perfume eliminado.");
            System.out.println("Seleccione una opción: ");

           
                while(!scanner.hasNextInt())
                {
                    System.out.println("ERROR. No ingreso un numero valido, vuelva a intentarlo:");
                    scanner.next();
                    
                }
                op = scanner.nextInt();
                while(op<0 || op>5)
                {
                    System.out.println("ERROR. Esa opción no existe, vuelva a intentarlo:");
                    op = scanner.nextInt();
                }

                scanner.nextLine();

            switch (op) {
                    case 1:

                            Perfume.cargarPerfume(perfume);
                        
                        bandera = true;
                    break;
                    case 2:

                        if(bandera)
                        {
                            Perfume.verDatos(perfume);
                           
                        }
                        else
                        {

                            System.out.println("ERROR. Para continuar debe cargar los datos.");
                        }

                    
                    break;
                    case 3:

                        if(bandera)
                        {
                           Perfume.modificarPerfume(perfume);
                           
                        }
                        else
                        {

                            System.out.println("ERROR. Para continuar debe cargar los datos.");
                        }

                    
                    break;
                    case 4:

                        if(bandera)
                        {
                            Perfume.eliminarPerfume(perfume);
                           
                        }
                        else
                        {

                            System.out.println("ERROR. Para continuar debe cargar los datos.");
                        }

                    
                    break;
                    case 5:

                        if(bandera)
                        {
                            Perfume.darAltaEliminados(perfume);
                           
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

