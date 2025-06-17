import java.util.LinkedList;
import java.util.NoSuchElementException;

public class PilaLista {
    private LinkedList<Integer> lista;

    public PilaLista() {
        lista = new LinkedList<>();
    }

    // Inserta un elemento en la cima de la pila
    public void insertar(int elemento) {
        lista.addFirst(elemento);
    }

    // Quita y devuelve el elemento de la cima de la pila
    public int quitar() {
        if (pilaVacia()) {
            throw new NoSuchElementException("La pila está vacía");
        }
        return lista.removeFirst();
    }

    // Verifica si la pila está vacía
    public boolean pilaVacia() {
        return lista.isEmpty();
    }

    // Devuelve el elemento de la cima sin quitarlo
    public int cima() {
        if (pilaVacia()) {
            throw new NoSuchElementException("La pila está vacía");
        }
        return lista.getFirst();
    }

    // Devuelve el número de elementos en la pila
    public int tamano() {
        return lista.size();
    }
}