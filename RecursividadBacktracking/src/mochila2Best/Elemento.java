
package mochila2Best;

public class Elemento {
    int beneficio;
    int peso;
    String id;
    
    public Elemento(int beneficio, int peso, String id) {
        this.beneficio = beneficio;
        this.peso = peso;
        this.id = id;
    }
    
    @Override
    public String toString() {
        return "id: " + id + ", b: " + beneficio + ", p: " + peso;
    }
    
}
