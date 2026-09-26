
package cola;

public class Cola {
    private class Nodo {
        private int valor;
        private Nodo siguiente;
        
        Nodo(int valor) {
            this.valor = valor;
        }                
        
        @Override
        public String toString() {
            return valor + "";
        }
    }
    
    private Nodo inicio;
    private Nodo fin;
    private int tamanio;
    
    void encolar(int valor) {
        if (inicio == null) {
            inicio = fin = new Nodo(valor);                        
        } else {        
            Nodo newNodo = new Nodo(valor);
            fin.siguiente = newNodo;
            fin = newNodo;
        }
        tamanio++;        
    }
    
    void desencolar() {
        if (inicio == null)
            return;
        
        if (inicio == fin) {
            inicio = fin = null;
            tamanio = 0;
            return;
        }
        
        inicio = inicio.siguiente;
        tamanio--;
    }
    
    int frente() throws Exception {
        if (inicio == null) 
            throw new Exception("No existe elemento");
                
        return inicio.valor;
    }
    
    int getTamanio() {
        return tamanio;
    }
    
    void imprimir() {
        Nodo puntero = inicio;
        
        while (puntero != null) {
            System.out.print(puntero + " -> ");
            puntero = puntero.siguiente;
        }
    }
    
    public static void main(String[] args) {
        Cola cola = new Cola();                
        
        cola.encolar(1);
        cola.encolar(2);
        cola.encolar(3);
        cola.encolar(4);
        cola.encolar(5);
        
        cola.desencolar();
        cola.desencolar();
        cola.desencolar();
        cola.desencolar();
        cola.desencolar();
        cola.desencolar();
        
        cola.imprimir();
        
        try {
            System.out.println("\nFrente: " + cola.frente());
        } catch (Exception e) {}
    }
    
    
}
