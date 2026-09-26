
package laberinto;

public class Celda {
    String id;
    boolean[] direcciones;    
    
    Celda(String id, boolean arriba, boolean derecha, boolean abajo, boolean izquierda) {
        this.id = id;
        direcciones = new boolean[4];
        direcciones[0] = arriba;
        direcciones[1] = derecha;
        direcciones[2] = abajo;
        direcciones[3] = izquierda;
    }
    
    @Override
    public String toString() {
        return id;
    }
                    
}
