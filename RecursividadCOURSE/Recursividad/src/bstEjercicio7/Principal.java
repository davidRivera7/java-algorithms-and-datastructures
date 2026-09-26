
package bstEjercicio7;

public class Principal {
    
    public static void main(String[] args) {
        ArbolBinario bst = new ArbolBinario();
        
        bst.setRaiz(bst.insertar('F', bst.getRaiz()));
        bst.setRaiz(bst.insertar('B', bst.getRaiz()));     
        bst.setRaiz(bst.insertar('A', bst.getRaiz()));        
        bst.setRaiz(bst.insertar('G', bst.getRaiz()));
        bst.setRaiz(bst.insertar('I', bst.getRaiz()));
        bst.setRaiz(bst.insertar('H', bst.getRaiz()));        
        bst.setRaiz(bst.insertar('D', bst.getRaiz()));
        bst.setRaiz(bst.insertar('C', bst.getRaiz()));        
        bst.setRaiz(bst.insertar('E', bst.getRaiz()));
                                        
        System.out.println(bst.recorridoPreOrden(bst.getRaiz()));
        System.out.println("Total nodos: " + bst.contarNodos(bst.getRaiz()));
        System.out.println("Nodos hoja: " + bst.contarNodosHoja(bst.getRaiz()));
    }
    
}
