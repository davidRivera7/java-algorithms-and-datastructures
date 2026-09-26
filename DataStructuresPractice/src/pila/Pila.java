//correcta
package pila;

public class Pila {
    private class Nodo {
        private int valor;
        private Nodo siguiente;
        
        public Nodo(int valor) {
            this.valor = valor;
        }
        
        @Override
        public String toString() {
            return valor + "";
        }
    }
        
    private Nodo inicio;   
    private Nodo fin;
    private int size;
    
    void push(int valor) {
        if (inicio == null) 
            inicio = fin = new Nodo(valor);            
        else {
            Nodo newNodo = new Nodo(valor);            
            fin.siguiente = newNodo;            
            fin = newNodo;
        }        
        size++;
    }
    
    void pop() {
        if (inicio == null)
            return;
        
        if (size == 1) {
            inicio = fin = null;
            size = 0;
            return;
        }
        
        int i = 0;
        Nodo puntero = inicio;
        
        while (i < size - 2) {            
            i++;
            puntero = puntero.siguiente;
        }        
        
        puntero.siguiente = null;
        fin = puntero;
        size--;
    }    
    
    Nodo peek() {
        if (inicio == null)
            return null;
        
        int i = 0;
        Nodo puntero = inicio;
        
        while (i < size - 1) {
            i++;
            puntero = puntero.siguiente;
        }
        
        return puntero;
    }
    
    boolean isEmpty() {
        return size == 0;
    }
    
    int getSize() {
        return size;
    }
    
    void imprimir() {
        Nodo puntero = inicio;
        
        while (puntero != null) {
            System.out.print(puntero + " ");
            puntero = puntero.siguiente;
        }
        
        System.out.println("");
    }        
    
}
