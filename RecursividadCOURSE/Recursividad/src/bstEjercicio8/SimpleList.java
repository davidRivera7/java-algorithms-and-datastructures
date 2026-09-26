
package bstEjercicio8;

public class SimpleList {
    class NodoList {
        int valor;
        NodoList siguiente;
        
        public NodoList(int valor) {
            this.valor = valor;
            siguiente = null;
        }
        
        @Override 
        public String toString() {
            return valor + "";
        }
    }
    
    NodoList inicio;
    
    public void insertar(int valor) {
        if (inicio == null) 
            inicio = new NodoList(valor);
        else {
            NodoList puntero = inicio;
            
            while (puntero.siguiente != null) 
                puntero = puntero.siguiente;
            
            puntero.siguiente = new NodoList(valor);
        }
    }
    
    private NodoList insertarRecursivo(int valor, NodoList l) {
        if (l == null) 
            return new NodoList(valor);
        else {
            l.siguiente = insertarRecursivo(valor, l.siguiente);            
            return l;
        }
    }
    
    public void deInsertarRecursivo(int valor) {
        inicio = insertarRecursivo(valor, inicio);
    }
    
    public String recorrerLista() {
        NodoList puntero = inicio;
        String listaText = "";
        
        while (puntero != null) {
            listaText += puntero + " -> ";
            puntero = puntero.siguiente;
        }
        
        return listaText;
    }
}
