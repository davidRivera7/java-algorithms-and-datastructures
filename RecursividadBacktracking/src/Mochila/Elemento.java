
package Mochila;

public class Elemento {
    String id;
    int beneficio;
    int peso;
    
    public Elemento(String id, int beneficio, int peso) {
        this.id = id;
        this.beneficio = beneficio;
        this.peso = peso;
    }
    
    @Override
    public String toString() {
        return "id = " + id + ", b = " + beneficio + ", peso = " + peso;
    }
    
}
