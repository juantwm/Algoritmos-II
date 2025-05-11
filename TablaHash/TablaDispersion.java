package TablaHash;

import java.util.Scanner;



public class TablaDispersion {

    static final int m=101;
    private int numElementos;
    private double factorCarga;
    private Tarea [] tabla;

    public TablaDispersion()
    {
        tabla = new Tarea[m];
        int i=0;
        for(i=0;i<m;i++)
        {
            tabla[i] = null;
            numElementos = 0;
            factorCarga = 0.0;
        }
    }
    
    public boolean insertar(Tarea t)
    {   
        int posicionInicial = calcularPosicion(t.getId());
        int posicion = posicionInicial;
        int i=0;

        while(tabla[posicion] != null)
        {
            
            i++;

            //RESUELVE LA COLISION
            posicion = resolverColision(posicionInicial, i);

            //COMPRUEBA SI TABLA HASH ESTA LLENA
            if(i>=m)
            {
                return false;
            }
        }

        //ASIGNA EL OBJETO A INSERTAR EN UNA NUEVA POSICION VACIA
        tabla[posicion] = t;
        numElementos++;
        factorCarga = (double) numElementos / m;
        if(factorCarga > 0.5)
        {
            System.out.println("FACTOR DE CARGA SUPERA EL 50%. CONVIENE AUMENTAR EL TAMAÑO DE LA TABLA.");
        }

        return true;
    }
    public long transformaCadena(String id)
    {
        long d=0;
        int i=0;

        for(i=0;i< Math.min(5, id.length());i++)
        {
            d = d *27 + (int)id.charAt(i);

        }
        if(d<0) d = -d;
        return d;
    }

   public int calcularPosicion(String id)
   {
        
        double R=0.6180339;
        double valor = transformaCadena(id);

        double total = R*valor;
        double decimal = total - Math.floor(total);
        
        return (int) (decimal * 101);
   }

   public int resolverColision(int posicionInicial, int i)
   {
        return(posicionInicial + i*i) % 101;
   }

   public int buscar(String codigo)
   {
    int i=0;

    for(i=0;i<101;i++)
    {
        if(tabla[i]!=null && tabla[i].getId().equals(codigo))
        {
            return i;
        }
    }
   

    return -1;
   }
    

    

   public void eliminar(Scanner input)
   {    
    
    int posicion=0;
    String idBuscado;

    if(contarValidos()>=1)
    {
        System.out.println("Ingrese el ID de la tarea que desea eliminar:");
        idBuscado = input.nextLine();
        posicion = buscar(idBuscado);
            while(posicion == -1 || tabla[posicion].getEsAlta() == false)
            {
                System.out.println("ERROR. Ese ID no existe o no fue cargado, vuelva a intentarlo:");
                idBuscado = input.nextLine();

                posicion = buscar(idBuscado);
                
            }
        
            tabla[posicion].setEsAlta(false);

            System.out.println("¡TAREA ELIMINADA CON EXITO!");
        }
        else
        {
            System.out.println("ERROR. No existen tareas para eliminar.");
        }
   }

   public void verDatos()
   {

        if(contarValidos()>=1)
        {
            for(int i=0;i<101;i++)
            {
                if(tabla[i] != null && tabla[i].getEsAlta() == true)
                {
                    if(tabla[i].getEstado() == 1)
                    {
                        System.out.println("TAREAS PENDIENTES:");
                        System.out.println("POSICION EN LA TABLA: "+i);
                        System.out.println("Nombre: "+tabla[i].getNombre());
                        System.out.println("Descripcion: "+tabla[i].getDescripcion());
                        System.out.println("ID: "+tabla[i].getId());
                        System.out.println("------------------------------");
                    }
                    if(tabla[i].getEstado() == 2)
                    {
                        System.out.println("TAREAS EN PROGRESO:");
                        System.out.println("POSICION EN LA TABLA: "+i);
                        System.out.println("Nombre: "+tabla[i].getNombre());
                        System.out.println("Descripcion: "+tabla[i].getDescripcion());
                        System.out.println("ID: "+tabla[i].getId());
                        System.out.println("------------------------------");
                    }
                    if(tabla[i].getEstado() == 3)
                    {
                        System.out.println("TAREAS FINALIZADAS:");
                        System.out.println("POSICION EN LA TABLA: "+i);
                        System.out.println("Nombre: "+tabla[i].getNombre());
                        System.out.println("Descripcion: "+tabla[i].getDescripcion());
                        System.out.println("ID: "+tabla[i].getId());
                        System.out.println("------------------------------");
                    }
                    
                }
            }
        }
        else
        {
            System.out.println("ERROR. La tareas fueron eliminadas o no han sido cargadas.");
        }
        
   }

   public int contarValidos()
   {
    int i=0, cont=0;


    for(i=0;i<101;i++)
    {
        if(tabla[i]!=null && tabla[i].getEsAlta() == true)
        {
            return cont++;
        }
    }
    return 0;

   }
   

}
