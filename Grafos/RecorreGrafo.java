public class RecorreGrafo {
    public static final int CLAVE = 0xffff; // Valor para indicar que un vértice no ha sido visitado

    // Recorrido en profundidad del grafo
    public static int[] recorrerProf(GrafoMatriz g, String org) throws Exception {
        int n = g.orden(); // Obtiene el número de vértices en el grafo
        int[] m = new int[n]; // Arreglo para marcar los vértices visitados
        for (int i = 0; i < n; i++) m[i] = CLAVE; // Inicializa todos los vértices como no visitados

        PilaLista pila = new PilaLista(); // Pila para el recorrido
        int v = g.numVertice(org); // Obtiene el índice del vértice de origen
        if (v == -1) throw new Exception("Vértice origen no existe"); // Lanza excepción si el origen no existe

        m[v] = 0; // Marca el vértice de origen como visitado
        pila.insertar(v); // Inserta el vértice de origen en la pila

        while (!pila.pilaVacia()) { // Mientras la pila no esté vacía
            int w = pila.quitar(); // Saca un vértice de la pila
            for (int i = 0; i < n; i++) { // Itera sobre todos los vértices adyacentes
                // Verifica si hay una arista entre w e i, y si i no ha sido visitado
                if (g.adyacente(g.vertices[w].getNombre(), g.vertices[i].getNombre()) && m[i] == CLAVE) { //
                    m[i] = 1; // Marca el vértice i como visitado
                    pila.insertar(i); // Inserta el vértice i en la pila
                }
            }
        }

        return m; // Devuelve el arreglo de vértices visitados
    }
}