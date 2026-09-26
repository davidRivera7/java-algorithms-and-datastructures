
package bstEjercicio7;

public class ArbolBinario {        
    private Nodo raiz;

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }
                
    public Nodo insertar(char valor, Nodo r) {
        if (r == null) {
            return new Nodo(valor);
        } else {
            if (valor < r.valor)
                r.izq = insertar(valor, r.izq);
            else 
                r.der = insertar(valor, r.der);
            
            return r;
        }
    }
    
    public String recorridoPreOrden(Nodo r) {
        if (r == null) 
            return "";
        else {             
            return r.valor + " --> " + recorridoPreOrden(r.izq) + recorridoPreOrden(r.der);            
        }
    }
    
    public int contarNodos(Nodo r) {
        if (r == null) 
            return 0;
         else 
            return 1 + contarNodos(r.izq) + contarNodos(r.der);        
    }
    
    public int contarNodosHoja(Nodo r) {
        if (r == null) 
            return 0;
        else if (r.izq == null && r.der == null) 
            return 1;
        else 
            return contarNodosHoja(r.izq) + contarNodosHoja(r.der);
    }
    
}
