public class GrafoMatriz {

    private int numVertice;
    static int MaxVertices = 20;
    Vertice [] vertices;
    int [][] matrizAdyacencia;

    public GrafoMatriz()
    {
        this(MaxVertices);
    }

    // constructor: crea una matriz de adyacencia
    public GrafoMatriz(int maxVert)
    {
        matrizAdyacencia = new int [maxVert][maxVert];
        vertices = new Vertice[maxVert];
        for(int i=0;i<maxVert;i++)
        {
            for(int j=0;j<maxVert;j++)
            {
                matrizAdyacencia[i][j]=0;
                
            }
        }
        numVertice=0;
    }

    // agrega un nuevo vertice
    public void nuevoVertice(String nombre)
    {
        int esta;
        esta = numVertice(nombre);
        if(esta == -1)
        {
            Vertice v = new Vertice(nombre);
            v.asigVert(numVertice);
            vertices[numVertice++] = v;
        }
    }
    // busca si el nuevo vertice que se esta por agregar ya existe
    int numVertice(String currentVertice)
    {
        Vertice v= new Vertice(currentVertice);
        int i=0;
        for(i=0;i<numVertice;i++)
        {
            if(vertices[i].equals(v))
            {
                return i;
            }
        }
        return -1;
    }
     // añade un arco

    public void nuevoArco(String a, String b, int peso) throws Exception
    {
        int va, vb;
        va=numVertice(a);
        vb=numVertice(b);
        if(va< 0 || vb<0) throw new Exception("Vertice no existe");
        matrizAdyacencia[va][vb] = peso;
    }
    
    // determina si dos vertices forman un arco

    public boolean adyacente(String a, String b) throws Exception
    {
        int va, vb;
        va = numVertice(a);
        vb = numVertice(b);
        if(va<0 || vb<0) throw new Exception("Vertice no existe");
        return matrizAdyacencia[va][vb] != 0;
    }

    // Devuelve el número de vértices del grafo
    public int orden() {
        return numVertice;
    }

    public void mostrarMatriz() {
    System.out.println("Matriz de adyacencia con pesos:");
    for (int i = 0; i < numVertice; i++) {
        for (int j = 0; j < numVertice; j++) {
            System.out.print(matrizAdyacencia[i][j] + "\t");
        }
        System.out.println();
    }
    }
}