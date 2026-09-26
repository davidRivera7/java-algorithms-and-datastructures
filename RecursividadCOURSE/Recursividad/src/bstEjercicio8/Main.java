
package bstEjercicio8;

import bstEjercicio8.BST_Estructura_Interna.NodoBST;
import bstEjercicio8.SimpleList.NodoList;

public class Main {
    
    public static void main(String[] args) {                                                 
        BST_Estructura_Interna tree = new BST_Estructura_Interna();
        
        tree.raiz = tree.insertar(8, tree.raiz);        
        tree.raiz = tree.insertar(4, tree.raiz);//        
        tree.raiz = tree.insertar(10, tree.raiz);
        tree.raiz = tree.insertar(12, tree.raiz);
        tree.raiz = tree.insertar(1, tree.raiz);
        tree.raiz = tree.insertar(0, tree.raiz);        
        tree.raiz = tree.insertar(4, tree.raiz);//        
        tree.raiz = tree.insertar(2, tree.raiz);
        tree.raiz = tree.insertar(9, tree.raiz);
        tree.raiz = tree.insertar(13, tree.raiz);      
        tree.raiz = tree.insertar(20, tree.raiz);
        tree.raiz = tree.insertar(30, tree.raiz);        
        tree.raiz = tree.insertar(4, tree.raiz);//        
        tree.raiz = tree.insertar(14, tree.raiz);
        tree.raiz = tree.insertar(16, tree.raiz);
        tree.raiz = tree.insertar(15, tree.raiz);        
        tree.raiz = tree.insertar(4, tree.raiz);//                
        tree.raiz = tree.insertar(13, tree.raiz);
        
        SimpleList list = new SimpleList();
        
        arbolTrasladoLista(tree.raiz, list, 5, 12);
        System.out.println("Arbol InOrden: " + tree.recorridoPreOrden(tree.raiz));
        System.out.println("Lista: " + list.recorrerLista());
        
        int valor = 13;      
        System.out.println("Suma nodo " + valor + ": " + contarNodoParticularArbol(tree.raiz, valor));
    }
    
    static void arbolTrasladoLista(NodoBST raiz, SimpleList list) {
        if (raiz != null) {
            list.insertar(raiz.valor);
            arbolTrasladoLista(raiz.getIzq(), list);
            arbolTrasladoLista(raiz.getDer(), list);
        }
    }
    
    static void listaTrasladoArbol(BST_Estructura_Interna bst, NodoList list) {
        if (list != null) {                    
            bst.raiz = bst.insertar(list.valor, bst.raiz);
            listaTrasladoArbol(bst, list.siguiente);            
        }
    }
    
    static void arbolTrasladoLista(NodoBST raiz, SimpleList list, int min, int max) {
        if (raiz != null) {                    
            if (raiz.valor >= min && raiz.valor <= max)
                list.insertar(raiz.valor);
            
            arbolTrasladoLista(raiz.getIzq(), list, min, max);
            arbolTrasladoLista(raiz.getDer(), list, min, max);
        }
    }
    
    static int contarNodoParticularArbol(NodoBST r, int v) {
        if (r == null) 
            return 0;
        else                     
            return ((r.valor == v) ? 1 : 0) 
                    + contarNodoParticularArbol(r.getIzq(), v) 
                    + contarNodoParticularArbol(r.getDer(), v);                    
    }
    
}
