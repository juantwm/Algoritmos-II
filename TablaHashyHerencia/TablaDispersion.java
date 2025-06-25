
import java.util.Scanner;
import java.util.LinkedList; // Necesario para usar LinkedList

public class TablaDispersion {

    static final int m = 101;
    private int numElementos; // Total de elementos (Tareas y Notitas) en la tabla
    private double factorCarga;
    // Ahora la tabla es un array de LinkedLists, donde cada LinkedList guarda objetos Registro
    private LinkedList<Registro>[] tabla;

    public TablaDispersion() {
        tabla = new LinkedList[m]; // Inicializa el array de LinkedLists
        numElementos = 0;
        factorCarga = 0.0;
        // Cada posición del array debe inicializarse con una nueva LinkedList
        for (int i = 0; i < m; i++) {
            tabla[i] = new LinkedList<>();
        }
    }

    // El método insertar ahora acepta un objeto de tipo Registro
    public boolean insertar(Registro reg) {
        int posicion = calcularPosicion(reg.getId());

        // Antes de insertar, verifica si ya existe un elemento con el mismo ID y activo
        // Si ya existe uno activo con ese ID, no se inserta.
        for (Registro r : tabla[posicion]) {
            if (r.getId().equals(reg.getId()) && r.getEsAlta()) {
                System.out.println("ERROR: Ya existe un registro activo con el ID " + reg.getId());
                return false; // No se permite insertar duplicados activos
            }
        }

        // Añade
        tabla[posicion].add(reg);
        numElementos++;
        factorCarga = (double) numElementos / m;

        if (factorCarga > 0.75) { 
            System.out.println("ADVERTENCIA: FACTOR DE CARGA SUPERA EL 75%. CONSIDERE AUMENTAR EL TAMAÑO DE LA TABLA.");
        }
        return true;
    }

    // Método de transformación de cadena para calcular la posición
    public long transformaCadena(String id) {
        long d = 0;
        for (int i = 0; i < Math.min(5, id.length()); i++) {
            d = d * 27 + (int) id.charAt(i);
        }
        if (d < 0) d = -d;
        return d;
    }

    // Método para calcular la posición en la tabla
    public int calcularPosicion(String id) {
        double R = 0.6180339; 
        long valor = transformaCadena(id);

        double total = R * valor;
        double decimal = total - Math.floor(total);

        return (int) (decimal * m); // Usa 'm' que es el tamaño del array
    }

    
    /*
    public int resolverColision(int posicionInicial, int i) {
        return (posicionInicial + i * i) % m;
    }
    */

    public Registro buscar(String codigo) {
        int posicion = calcularPosicion(codigo);

        // Busca dentro de la LinkedList en esa posición
        for (Registro r : tabla[posicion]) {
            if (r.getId().equals(codigo)) {
                return r; // Retorna el objeto Registro si lo encuentra
            }
        }
        return null; // Retorna null si no lo encuentra
    }

    public void eliminar(Scanner input) {
        String idBuscado;
        Registro registroEncontrado;

        if (contarValidos() >= 1) {
            verDatos();
            System.out.println("Ingrese el ID del registro (Tarea/Notita) que desea eliminar:");
            idBuscado = input.nextLine();

            registroEncontrado = buscar(idBuscado);

            // Valida que el registro exista y esté activo
            while (registroEncontrado == null || !registroEncontrado.getEsAlta()) {
                System.out.println("ERROR. Ese ID no existe o ya está eliminado. Vuelva a intentarlo:");
                idBuscado = input.nextLine();
                registroEncontrado = buscar(idBuscado);
            }

            // Marca el registro como eliminado (esAlta = false)
            registroEncontrado.setEsAlta(false);
            System.out.println("¡REGISTRO ELIMINADO CON ÉXITO!");
        } else {
            System.out.println("ERROR. No existen registros (Tareas/Notitas) para eliminar.");
        }
    }

    public void verDatos() {
        if (contarValidos() >= 1) {
            System.out.println("\n---LISTA DE REGISTROS (TAREAS Y NOTITAS)---");
            for (int i = 0; i < m; i++) {
                for (Registro r : tabla[i]) { // Itera sobre cada LinkedList y sus elementos
                    if (r.getEsAlta()) { 
                        System.out.println("POSICION EN LA TABLA HASH: " + i);
                        System.out.println(r); 
                        System.out.println("------------------------------");
                    }
                }
            }
            System.out.println("-----------------------------------------\n");
        } else {
            System.out.println("ERROR. No hay registros activos (Tareas/Notitas) para mostrar.");
        }
    }

    public int contarValidos() {
        int cont = 0;
        for (int i = 0; i < m; i++) {
            for (Registro r : tabla[i]) {
                if (r.getEsAlta()) {
                    cont++;
                }
            }
        }
        return cont;
    }

    public int contarEliminados() {
        int cont = 0;
        for (int i = 0; i < m; i++) {
            for (Registro r : tabla[i]) {
                if (!r.getEsAlta()) {
                    cont++;
                }
            }
        }
        return cont;
    }

    public void darAlta(Scanner input) {
        String idBuscado;
        Registro registroEncontrado;

        if (contarEliminados() >= 1) {
            System.out.println("\n-----REGISTROS (TAREAS/NOTITAS) ELIMINADOS----");
            // Muestra los registros que están marcados como eliminados
            for (int i = 0; i < m; i++) {
                for (Registro r : tabla[i]) {
                    if (!r.getEsAlta()) {
                        System.out.println("POSICION EN LA TABLA HASH: " + i);
                        System.out.println(r);
                        System.out.println("------------------------------");
                    }
                }
            }

            System.out.println("Ingrese el ID del registro (Tarea/Notita) que desea dar de alta:");
            idBuscado = input.nextLine();
            registroEncontrado = buscar(idBuscado);

            // Valida que el registro exista y esté marcado como eliminado
            while (registroEncontrado == null || registroEncontrado.getEsAlta()) {
                System.out.println("ERROR. Ese ID no existe o ya está de alta. Vuelva a intentarlo:");
                idBuscado = input.nextLine();
                registroEncontrado = buscar(idBuscado);
            }

            // Marca el registro como activo (esAlta = true)
            registroEncontrado.setEsAlta(true);
            System.out.println("¡REGISTRO DADO DE ALTA CON ÉXITO!");
        } else {
            System.out.println("ERROR. No existen REGISTROS ELIMINADOS para dar de alta.");
        }
    }

    public void modificarTarea(Scanner input) {
        int op = 0;
        String idBuscado, nuevoNombre, nuevaDescripcion, nuevoColor;
        int nuevoEstado;
        Registro registroAModificar;

        if (contarValidos() >= 1) {
            System.out.println("Ingrese el ID del registro (Tarea/Notita) que desea modificar:");
            idBuscado = input.nextLine();
            registroAModificar = buscar(idBuscado);

            // Valida que el registro exista y esté activo
            while (registroAModificar == null || !registroAModificar.getEsAlta()) {
                System.out.println("ERROR. Ese ID no existe o fue eliminado. Vuelva a intentarlo:");
                idBuscado = input.nextLine();
                registroAModificar = buscar(idBuscado);
            }

            do {
                System.out.println("0. Para volver al menu principal.");
                System.out.println("1. Para modificar el nombre.");
                System.out.println("2. Para modificar la descripción.");

                // Opciones específicas según el tipo de registro
                if (registroAModificar instanceof Tarea) {
                    System.out.println("3. Para modificar el estado (Solo Tarea).");
                } else if (registroAModificar instanceof Notita) {
                    System.out.println("3. Para modificar el color (Solo Notita).");
                }

                while (!input.hasNextInt()) {
                    System.out.println("ERROR. Debe ingresar un numero.");
                    input.next();
                }
                op = input.nextInt();

                // Validación de opciones
                if (registroAModificar instanceof Tarea) {
                    while (op < 0 || op > 3) {
                        System.out.println("ERROR. Esa opción no existe. Vuelva a intentarlo: ");
                        op = input.nextInt();
                    }
                } else if (registroAModificar instanceof Notita) {
                    while (op < 0 || op > 3 || op == 3) { 
                        System.out.println("ERROR. Esa opción no existe. Vuelva a intentarlo: ");
                        op = input.nextInt();
                    }
                }
                input.nextLine(); 

                switch (op) {
                    case 1:
                        System.out.println("Ingrese el nuevo nombre:");
                        nuevoNombre = input.nextLine();
                        registroAModificar.setNombre(nuevoNombre);
                        System.out.println("Nombre modificado con éxito.");
                        break;
                    case 2:
                        System.out.println("Ingrese la nueva descripción:");
                        nuevaDescripcion = input.nextLine();
                        registroAModificar.setDescripcion(nuevaDescripcion);
                        System.out.println("Descripción modificada con éxito.");
                        break;
                    case 3:
                        if (registroAModificar instanceof Tarea) {
                            Tarea tareaAModificar = (Tarea) registroAModificar; // Casteo a Tarea
                            System.out.println("Ingrese el nuevo estado: 1- Pendiente  2-En progreso 3-Finalizada");
                            while (!input.hasNextInt()) {
                                System.out.println("ERROR. Debe ingresar un número, vuelva a intentarlo: ");
                                input.next();
                            }
                            nuevoEstado = input.nextInt();
                            while (nuevoEstado < 1 || nuevoEstado > 3) {
                                System.out.println("ERROR. Esa opción no existe, vuelva a intentarlo:");
                                nuevoEstado = input.nextInt();
                            }
                            input.nextLine();
                            tareaAModificar.setEstado(nuevoEstado);
                            System.out.println("Estado de tarea modificado con éxito.");
                        } else if (registroAModificar instanceof Notita) {
                            Notita notitaAModificar = (Notita) registroAModificar; // Casteo a Notita
                            System.out.println("Ingrese el nuevo color:");
                            nuevoColor = input.nextLine();
                            notitaAModificar.setColor(nuevoColor);
                            System.out.println("Color de notita modificado con éxito.");
                        }
                        break;
                    case 0:
                        System.out.println("Volviendo al menú principal.");
                        break;
                }
            } while (op != 0);

        } else {
            System.out.println("ERROR. No existen registros (Tareas/Notitas) activos para modificar.");
        }
    }
}