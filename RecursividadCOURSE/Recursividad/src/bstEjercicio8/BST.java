
package bstEjercicio8;

public class BST {
    Integer valor;
    BST izq;
    BST der;
            
    void insertar(int valor) {
        if (this.valor == null) 
            this.valor = valor;
        else {
            if (valor < this.valor) {                
                if (izq == null) izq = new BST();
                izq.insertar(valor);
            } else {
                if (der == null) der = new BST();
                der.insertar(valor);
            }
        }        
    }
    
    String preOrden() {
        if (valor == null) 
            return "";
        else {
            String treeText = valor + " -> ";
            if (izq != null) 
                treeText += izq.preOrden();
            
            if (der != null)
                treeText += der.preOrden();
            
            return treeText;
        }
    }
    
    public static void main(String[] args) {
        BST bst = new BST();
        
        bst.insertar(10);
        bst.insertar(9);
        bst.insertar(8);
        
        System.out.println(bst.preOrden());
    }
            
}
