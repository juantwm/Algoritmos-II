
public class BinaryTree {

    private Nodo root;

    public BinaryTree() //Constructor del arbol vacio
    {
        root = null;
    }
    public BinaryTree(Nodo root) //Constructor del arbol, inserta el valor a una raiz
    {
        this.root = root;
    }

    public void insert(int newvalue) throws Exception //Verifica si existe ya una raiz, o sea, si el arbol esta vacio, si es asi, inserta. Si no, llama al metodo recursivo insert
    {

        if(root == null)
        {
            root = new Nodo(newvalue);
            
        }
        else
        {
            this.insert(this.root, newvalue);
        }
    }
    private void insert(Nodo current, int dato) throws Exception
    {
        if(dato > current.getValue()) //pregunta si el dato a ingresar es mayor que el nodo actual, en este caso, la raiz (primera llamada), luego va recorriendo
        {
            if(current.getRight() == null) //Si es mayor, se inserta la derecha, si en el nodo de la derecha hay un null, inserta ahi. Sino llama de nuevo a la funcion recursiva, y va recorriendo el sub arbol derecho
            {
                current.setRight(new Nodo(dato));
            }
            else
            {
                this.insert(current.getRight(), dato);
            }
        }
        else if (dato < current.getValue())//pregunta si el dato a ingresar es menor que el nodo actual, en este caso, la raiz(primera llamada), luego va recorriendo e insertando en el sub arbol izquierdo
        {
            if(current.getLeft()==null) // Si ya se comprobo que era menor, pregunta si el nodo a la izquierda del actual es null, si lo es, inserta ahi. Sino, llama a la funcion recursiva para ir recoriendo el sub arbol izquierdo, hasta encontrar un lugar e insertar.
            {
                current.setLeft(new Nodo(dato));
            }
            else
            {
                this.insert(current.getLeft(), dato);
            }
        }
        else if (dato == current.getValue()) //Si el dato no es ni mayor ni menor, sino que igual. Entonces, lanza una excepcion.
        {
            throw new Exception("ERROR. No puede haber valores duplicados");
        }
    }

    public int find(int value) throws Exception
    {
        if(root == null)
        {
            throw new Exception("ERROR. El arbol está vacio.");
            
        }
        Nodo result = this.find(this.root, value);

        if(result == null)
        {
            return 0;
        }
        else
        {
            return result.getValue();
        }
        

    }
    private Nodo find(Nodo current, int value) throws Exception
    {
        if(value > current.getValue())
        {
            if(current.getRight() != null)
            {
                return this.find(current.getRight(), value);
            }
        }
        else if(value < current.getValue())
        {
            if(current.getLeft()!=null)
            {
                return this.find(current.getLeft(), value);
            }
        }
        else
        {
            return current;
        }
        
        return null;
        
    }

    public void preOrder()
    {
        preOrder(root);
    }
    public void inOrder()
    {
        inOrder(root);
    }
    public void postOrder()
    {
        postOrder(root);
    }
    private void preOrder(Nodo root)
    {
        if(root!=null)
        {
            System.out.println(root.getValue() + "");
            preOrder(root.getLeft());
            preOrder(root.getRight());

        }
    }
    private void inOrder(Nodo root)
    {
        if(root!= null)
        {
            inOrder(root.getLeft());
            System.out.println(root.getValue() + "");
            inOrder(root.getRight());
        }
    }
    private void postOrder(Nodo root)
    {
        if(root != null)
        {
            postOrder(root.getLeft());
            postOrder(root.getRight());
            System.out.println(root.getValue() + "");
        }
    }


}
