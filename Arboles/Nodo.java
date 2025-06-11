


public class Nodo {
    private int value;
    private Nodo right;
    private Nodo left;

        public Nodo(int value)
        {
            this.value = value;
            right = null;
            left = null;
        }

        public Nodo(Nodo left, int value, Nodo rigth)
        {
            this.value=value;
            this.right = rigth;
            this.left = left;
        }

        public int getValue() //Obtiene el valor del nodo
        {
            return value;
        }
        public Nodo getLeft() //Obtiene al hijo izquierdo
        {
            return left;
        }
        
        public Nodo getRight() //Obtiene al hijo derecho
        {
            return right;
        }
        public void setLeft(Nodo nodo) //Asigna el hijo izquierdo
        {
            this.left = nodo;
        }
        public void setRight(Nodo nodo) //Asigna el hijo derecho
        {
            this.right = nodo;
        }
    

}
