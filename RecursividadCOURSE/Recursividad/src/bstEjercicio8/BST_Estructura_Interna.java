
package bstEjercicio8;

public class BST_Estructura_Interna {   
    public class NodoBST {
        int valor;
        private NodoBST izq;
        private NodoBST der;

        public NodoBST(int valor) {
            this.valor = valor;
            izq = null;
            der = null;
        }

        public int getValor() {
            return valor;
        }              
        
        public NodoBST getIzq() {
            return izq;
        }

        public NodoBST getDer() {
            return der;
        }
        
        @Override
        public String toString() {
            return valor + "";
        }
    }
    NodoBST raiz;
    
    public NodoBST insertar(int valor, NodoBST r) {
        if (r == null) 
            return new NodoBST(valor);
        else {
            if (valor <= r.valor)
                r.izq = insertar(valor, r.izq);
            else 
                r.der = insertar(valor, r.der);
           
            return r;
        }
    }        
    
    public String recorridoPreOrden(NodoBST r) {
        if (r == null) 
            return "";
       else 
            return r + " -> " + recorridoPreOrden(r.izq) + recorridoPreOrden(r.der);
    }
    
    public String recorridoInOrden(NodoBST r) {
        if (r == null) 
            return "";
        else 
            return recorridoInOrden(r.izq) + r + " -> " + recorridoInOrden(r.der);        
    }
    
    public String recorridoPostOrden(NodoBST r) {
        if (r == null) 
            return "";
        else 
            return recorridoPostOrden(r.izq) + recorridoPostOrden(r.der) + r + " -> ";
    }
    
    public String recorridoReverso(NodoBST r) {
        if (r == null) 
            return "";
        else 
            return recorridoReverso(r.der) + r + " - " + recorridoReverso(r.izq);
    }
}
