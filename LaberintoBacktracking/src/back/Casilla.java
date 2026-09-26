
package back;

public class Casilla {
    private int posX;
    private int posY;
    private boolean visitado;
    private boolean fin;
    private boolean[] paso; //0 = arriba, 1 = derecha, 2 = abajo, 3 = izquierda

    public Casilla(int posX, int posY, boolean[] paso, boolean fin) {
        this.posX = posX;
        this.posY = posY;
        this.visitado = false;
        this.paso = paso;
        this.fin = fin;        
    }

    public boolean isFin() {
        return fin;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }      

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }        
    
    public boolean arribaDisponible() {
        return paso[0];
    }
        
    public boolean derechaDisponible() {
        return paso[1];
    }
        
    public boolean abajoDisponible() {
        return paso[2];
    }
        
    public boolean izquierdaDisponible() {
        return paso[3];
    }

    @Override
    public String toString() {
        return "posX = " + posX + ", posY = " + posY;
    }                
            
}
