
public class Main {
    
        public static void main(String[] args) {

            System.out.println("Arbol binario de busqueda de números enteros\n");
            BinaryTree arbolBinario = new BinaryTree();
            try 
            {
                arbolBinario.insert(10);
                arbolBinario.insert(15);
                arbolBinario.insert(7);
                arbolBinario.insert(3);
                arbolBinario.insert(9);
                arbolBinario.insert(8);
                System.out.println("Buscando el valor 15 = " + arbolBinario.find(15));
                
                
                System.out.println("\nPre orden");
                arbolBinario.preOrder();
                System.out.println("\nIn orden");
                arbolBinario.inOrder();
                System.out.println("\nPost orden");
                arbolBinario.postOrder();
            }
            catch (Exception e)
            {
            System.out.println(e.getMessage());
            }
                }
}
