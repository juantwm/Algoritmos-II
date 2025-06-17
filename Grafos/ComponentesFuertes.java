import java.util.Stack;
import java.util.ArrayList;
import java.util.List;

public class ComponentesFuertes {

    // Método principal para encontrar y mostrar las componentes fuertemente conexas
    public void encontrarComponentesFuertes(GrafoMatriz grafo) throws Exception {
        int numVertices = grafo.orden();

        // Paso 1: Realiza un recorrido en profundidad en el grafo original y guardar los vértices en orden
        Stack<Integer> pila = new Stack<>();
        boolean[] visitado = new boolean[numVertices];

        for (int i = 0; i < numVertices; i++) {
            if (!visitado[i]) {
                dfs(grafo, i, visitado, pila);
            }
        }

        // Paso 2: Construye el grafo transpuesto
        GrafoMatriz grafoTranspuesto = construirGrafoTranspuesto(grafo);

        // Paso 3: Realizar un recorrido en profundidad en el grafo transpuesto usando el orden de finalización
        visitado = new boolean[numVertices]; // Reiniciar el arreglo de visitados
        System.out.println("Componentes fuertemente conexas:");

        while (!pila.isEmpty()) {
            int v = pila.pop();
            if (!visitado[v]) {
                List<String> componente = new ArrayList<>();
                dfsTranspuesto(grafoTranspuesto, v, visitado, componente);
                System.out.println(componente);
            }
        }
    }

    // recorrido en profundidad para el grafo original
    private void dfs(GrafoMatriz grafo, int u, boolean[] visitado, Stack<Integer> pila) throws Exception {
        visitado[u] = true;
        for (int v = 0; v < grafo.orden(); v++) {
            if (grafo.adyacente(grafo.vertices[u].getNombre(), grafo.vertices[v].getNombre()) && !visitado[v]) {
                dfs(grafo, v, visitado, pila);
            }
        }
        pila.push(u); // Empuja el vértice a la pila una vez que todos sus adyacentes han sido visitados
    }

    // Construye el grafo transpuesto
    private GrafoMatriz construirGrafoTranspuesto(GrafoMatriz grafo) throws Exception {
        int numVertices = grafo.orden();
        GrafoMatriz gt = new GrafoMatriz(numVertices);

        // Copiar los vértices al grafo transpuesto
        for (int i = 0; i < numVertices; i++) {
            gt.nuevoVertice(grafo.vertices[i].getNombre());
        }

        // Invertir las aristas
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                // Si existe una arista de i a j en el grafo original, añadir una de j a i en el transpuesto
                if (grafo.matrizAdyacencia[i][j] != 0) {
                    gt.matrizAdyacencia[j][i] = grafo.matrizAdyacencia[i][j]; // Mantener el mismo peso, o usar 1 si no importa
                }
            }
        }
        return gt;
    }

    // recorrido en profundidad para el grafo transpuesto
    private void dfsTranspuesto(GrafoMatriz grafo, int u, boolean[] visitado, List<String> componente) throws Exception {
        visitado[u] = true;
        componente.add(grafo.vertices[u].getNombre());
        for (int v = 0; v < grafo.orden(); v++) {
            if (grafo.adyacente(grafo.vertices[u].getNombre(), grafo.vertices[v].getNombre()) && !visitado[v]) {
                dfsTranspuesto(grafo, v, visitado, componente);
            }
        }
    }
}