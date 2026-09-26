package bstEjercicio7;

public class Nodo {
    char valor;
    Nodo der;
    Nodo izq;

    Nodo(char valor) {
        this.valor = valor;
    }

    public char getValor() {
        return valor;
    }

    public void setValor(char valor) {
        this.valor = valor;
    }
    
    @Override
    public String toString() {
        return valor + "";
    }
}
