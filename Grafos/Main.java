public class Main {
    public static void main(String[] args) {
        GrafoMatriz grafo = new GrafoMatriz();

        try {
            grafo.nuevoVertice("Alicante");
            grafo.nuevoVertice("Cartagena");
            grafo.nuevoVertice("Murcia");
            grafo.nuevoVertice("Barcelona");
            grafo.nuevoVertice("Reus");

            grafo.nuevoArco("Alicante", "Cartagena", 5);
            grafo.nuevoArco("Alicante", "Murcia", 3);
            grafo.nuevoArco("Cartagena", "Murcia", 3);
            grafo.nuevoArco("Cartagena", "Alicante", 3); // Arco de regreso para formar un ciclo
            grafo.nuevoArco("Murcia", "Barcelona", 5);
            grafo.nuevoArco("Murcia", "Reus", 6);
            grafo.nuevoArco("Barcelona", "Reus", 3);
            grafo.nuevoArco("Reus", "Barcelona", 1); // Arco de regreso para formar un ciclo

            System.out.println("Grafo Original:");
            grafo.mostrarMatriz();
            System.out.println();

            // Encontrar y mostrar las componentes fuertemente conexas
            ComponentesFuertes cfc = new ComponentesFuertes();
            cfc.encontrarComponentesFuertes(grafo);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}