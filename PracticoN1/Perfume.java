package PracticoN1;

import java.util.Scanner;

public class Perfume {
    private String id;
    private String nombre;
    private String marca;
    private double precio;
    private int stock;


    //CONSTRUCTURES
    public Perfume(String id, String nombre, String marca, double precio, int stock)
    {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.stock = stock;
    }

    public String getId()
    {
        return id;
    }
    public String getNombre()
    {
        return nombre;
    }
    
    public String getMarca()
    {
        return marca;
    }
    
    public double getPrecio()
    {
        return precio;
    }
    
    public int getStock()
    {
        return stock;
    }

    public void setId(String id)
    {
        this.id = id;
    }
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    public void setMarca(String marca)
    {
        this.marca = marca;
    }
    public void setPrecio(double precio)
    {
        this.precio = precio;
    }
    public void setStock(int stock)
    {
        this.stock = stock;
    }

    public static boolean esIdValido(String id) {
        // Solo letras y números, sin espacios ni símbolos, y máximo 10 caracteres
        return id.matches("^[a-zA-Z0-9]{1,10}$");
    }
    
    public static void cargarPerfume(Perfume[] perfume)
    {

        Scanner scanner = new Scanner(System.in);
        int i=0, op=0, resultado=0;
        String nombre, marca, id;
        double precio=0;
        int stock =0 ;

        for(i=0;i<perfume.length;i++)
        {
            if(perfume[i] == null || perfume[i].getStock()==0)
            {
                System.out.printf("Ingrese los datos del perfume n°%d: \n", i+1);
                System.out.println("Ingrese el nombre:");
                nombre = scanner.nextLine();

                while(nombre.length()<3 || nombre.length()>50)
                {
                    System.out.println("ERROR. El nombre debe ser entre 3 y 50 caracteres. Vuelva a intentarlo:");
                    nombre = scanner.nextLine();
                }
                
                System.out.println("Ingrese la marca:");
                marca = scanner.nextLine();

                while(marca.length()<2 || marca.length()>30)
                {
                    System.out.println("ERROR. La marca debe ser entre 2 y 30 caracteres. Vuelva a intentarlo:");
                    marca = scanner.nextLine();
                }

                System.out.println("Ingrese el precio:");
                precio = scanner.nextDouble();
                    while(precio<= 0)
                    {
                        System.out.println("ERROR. El precio debe ser mayor a 0, vuelva a intentarlo: \n");
                        precio = scanner.nextDouble();
                    }
                System.out.println("Ingrese el stock:");
                stock = scanner.nextInt();
                    while(stock<1)
                    {
                        System.out.println("ERROR. El stock debe ser mayor a 0, vuelva a intentarlo:");
                        stock = scanner.nextInt();

                    }
                scanner.nextLine();
                do {
                    System.out.println("Ingrese el ID (máximo 10 caracteres, solo letras y números):");
                    id = scanner.nextLine();
                
                    if (!esIdValido(id)) {
                        System.out.println("ERROR. El ID debe tener solo letras o números, sin espacios ni caracteres especiales, y hasta 10 caracteres.");
                    } else if (validarId(perfume, id) == 1) {
                        System.out.println("ERROR. Ese ID ya existe, vuelva a intentarlo:");
                        id = "";
                    }
                
                } while (!esIdValido(id) || validarId(perfume, id) == 1);
                

                perfume[i] = new Perfume(id, nombre, marca, precio, stock);

                if(i<perfume.length-1)
                {
                    System.out.println("¿Desea seguir cargando? 1/SI     2/NO");
                    op = scanner.nextInt();

                    while(op<1 || op>2)
                    {
                        System.out.println("ERROR. Esa opcion no existe. Vuelva a intentarlo");
                        op = scanner.nextInt();
                    }
                    if(op == 2)
                    {
                        break;
                    }
                }
                else
                {
                    System.out.println("¡ERROR. NO HAY ESPACIO DISPONIBLE!");
                }
            }
        }
    }

    public static int validarId(Perfume[] perfume, String id)
    {
        int i=0;

        for(i=0;i<perfume.length;i++)
        {
            if(perfume[i] != null && perfume[i].getStock()!= 0)
            {
                if(id.equals(perfume[i].getId()))
                {
                    return 1;

                }
                else
                {
                    return -1;
                }
            }

        }

        return 0;
    }

    public static void verDatos(Perfume[] perfume)
    {
        int i=0;

        if(contadorValidos(perfume)>0)
        {
            
            System.out.println("************************* PERFUMES CARGADOS: *************************");

            for(i=0;i<perfume.length;i++)
            {
                if(perfume[i] != null && perfume[i].getStock() >0)
                {

                    System.out.printf("DATOS DEL PERFUME N°%d: \n", i+1);
                    System.out.println("Nombre:" + perfume[i].getNombre());
                    System.out.println("Marca:" + perfume[i].getMarca());
                    System.out.println("Precio:" + perfume[i].getPrecio());
                    System.out.println("Stock:" + perfume[i].getStock());
                    System.out.println("ID:" + perfume[i].getId());
                    System.out.println("**************************************************");

                }
            }

        }
        else
        {
            System.out.println("ERROR. No existen perfumes para ver porque ya fueron eliminados o no han sido cargados.");

        }
        
    }

    public static void modificarPerfume(Perfume[] perfume)
    {
        Scanner scanner = new Scanner(System.in);
        int i=0, op=0, resultado = 0, stock;
        String idBuscado, nombre, marca;
        double precio;
        
        
        if(contadorValidos(perfume)>0)
        {

            for(i=0;i<perfume.length;i++)
            {

                if(perfume[i] != null && perfume[i].getStock()>0)
                {
                    System.out.println("**************************************************");
                    System.out.println("Nombre:" + perfume[i].getNombre());
                    System.out.println("ID:" + perfume[i].getId());
                }
            }

            System.out.println("Ingrese el ID del perfume que desea modificar:");
            idBuscado = scanner.nextLine();

            resultado = validarId(perfume, idBuscado);

            while(resultado == -1)
            {
                System.out.println("ERROR. Ese ID no existe, vuelva a intentarlo:");
                idBuscado = scanner.nextLine();
                resultado = validarId(perfume, idBuscado);
            }

            do
            {

                System.out.println("¿Que desea modificar?");
                System.out.println("0. Salir del menu.");
                System.out.println("1. Nombre.");
                System.out.println("2. Marca.");
                System.out.println("3. Precio.");
                System.out.println("4. Stock.");
                op = scanner.nextInt();
                    while(op<0 || op>4)
                    {
                        System.out.println("ERROR. Esa opcion no existe, vuelva a intentarlo:");
                        op = scanner.nextInt();
                    }
                scanner.nextLine();
                switch(op)
                {
                    case 1:

                        for(i=0;i<perfume.length;i++)
                        {
                            if(perfume[i] != null && perfume[i].getId().equals(idBuscado))
                            {
                                System.out.println("Ingrese el nombre:");
                                nombre = scanner.nextLine();

                                while(nombre.length()<3 || nombre.length()>50)
                                {
                                    System.out.println("ERROR. El nombre debe ser entre 3 y 50 caracteres. Vuelva a intentarlo:");
                                    nombre = scanner.nextLine();
                                }

                                perfume[i].setNombre(nombre);


                            }
                        }

                    break;

                    case 2:
                        for(i=0;i<perfume.length;i++)
                        {
                            if(perfume[i] != null && perfume[i].getId().equals(idBuscado))
                            {
                                System.out.println("Ingrese la marca:");
                                marca = scanner.nextLine();

                                while(marca.length()<2 || marca.length()>3)
                                {
                                    System.out.println("ERROR. La marca debe ser entre 2 y 30 caracteres. Vuelva a intentarlo:");
                                    marca = scanner.nextLine();
                                }

                                perfume[i].setMarca(marca);

                            }
                        }

                    break;
                    case 3:
                        
                        for(i=0;i<perfume.length;i++)
                        {
                            if(perfume[i] != null && perfume[i].getId().equals(idBuscado))
                            {
                                System.out.println("Ingrese el precio:");
                                precio = scanner.nextDouble();

                                while(precio<= 0)
                                {
                                System.out.println("ERROR. El precio debe ser mayor a 0, vuelva a intentarlo: \n");
                                precio = scanner.nextDouble();
                                }

                                perfume[i].setPrecio(precio);

                            }
                        }

                    break;
                    case 4:

                        for(i=0;i<perfume.length;i++)
                        {
                            if(perfume[i] != null && perfume[i].getId().equals(idBuscado))
                            {
                                System.out.println("Ingrese el stock:");
                                stock = scanner.nextInt();

                                while(stock<1)
                                {
                                    System.out.println("ERROR. El stock debe ser mayor a 0, vuelva a intentarlo:");
                                    stock = scanner.nextInt();

                                }

                                perfume[i].setStock(stock);

                            }
                        }
                        
                    break;
                }
            }while(op!=0);


        }
        else
        {
            System.out.println("ERROR. No existen perfumes para modificar porque ya fueron eliminados o no han sido cargados.");
        }
        
    }


    public static void eliminarPerfume(Perfume[] perfume)
    {
        Scanner scanner = new Scanner(System.in);
        int i=0, op=0, resultado = 0;
        String idBuscado;

        if(contadorValidos(perfume)>0)
        {

            for(i=0;i<perfume.length;i++)
            {

                if(perfume[i] != null && perfume[i].getStock()>0)
                {
                    System.out.println("**************************************************");
                    System.out.println("Nombre:" + perfume[i].getNombre());
                    System.out.println("ID:" + perfume[i].getId());
                }
            }


            System.out.println("Ingrese el ID del perfume que desea eliminar:");
            idBuscado = scanner.nextLine();

            resultado = validarId(perfume, idBuscado);

            while(resultado == -1)
            {
                System.out.println("ERROR. Ese ID no existe, vuelva a intentarlo:");
                idBuscado = scanner.nextLine();
                resultado = validarId(perfume, idBuscado);
            }

            for(i=0;i<perfume.length;i++)
            {
                if(perfume[i] != null && perfume[i].getId().equals(idBuscado))
                {
                    perfume[i].setStock(-1);
                }
            }
            System.out.println("¡PERFUME ELIMINADO CON EXITO!");


        }
        else
        {
            System.out.println("ERROR. No existen perfumes para eliminar porque ya fueron eliminados o no han sido cargados.");

        }

        


    }

    public static void darAltaEliminados(Perfume[] perfume)
    {
        Scanner scanner = new Scanner(System.in);

        int i=0, resultado=0, stock=0;
        String idBuscado;

        if(contadorEliminados(perfume)>0)
        {
            for(i=0;i<perfume.length;i++)
            {

                if(perfume[i] != null && perfume[i].getStock()== -1)
                {
                    System.out.println("**************************************************");
                    System.out.println("Nombre:" + perfume[i].getNombre());
                    System.out.println("ID:" + perfume[i].getId());
                }
            }


            System.out.println("Ingrese el ID del perfume que desea dar de alta:");
            idBuscado = scanner.nextLine();

            resultado = validarId(perfume, idBuscado);

            while(resultado == -1)
            {
                System.out.println("ERROR. Ese ID no existe, vuelva a intentarlo:");
                idBuscado = scanner.nextLine();
                resultado = validarId(perfume, idBuscado);
            }

            for(i=0;i<perfume.length;i++)
            {
                if(perfume[i] != null && perfume[i].getId().equals(idBuscado))
                {
                    System.out.println("Ingrese el stock:");
                     stock = scanner.nextInt();
                    while(stock<1)
                    {
                        System.out.println("ERROR. El stock debe ser mayor a 0, vuelva a intentarlo:");
                        stock = scanner.nextInt();

                    }
                    
                    perfume[i].setStock(stock);
                }
            }
            System.out.println("¡PERFUME DADO DE ALTA CON EXITO!");
        }
        else
        {
            System.out.println("ERROR. Si no hay perfumes eliminados no puede continuar.");
        }


    }
    public static int contadorValidos(Perfume[] perfume)
    {
        int i=0, cont=0;

        for(i=0;i<perfume.length;i++)
        {
            if(perfume[i] != null && perfume[i].getStock()>0)
            {
                return cont = cont +1;
            }
        }
        return 0;
    }

    public static int contadorEliminados(Perfume[] perfume)
    {
        int i=0, cont=0;

        for(i=0;i<perfume.length;i++)
        {
            if(perfume[i] != null && perfume[i].getStock() == -1)
            {
                return cont = cont +1;
            }
        }

        return 0;
    }



}
