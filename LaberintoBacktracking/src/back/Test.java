
package back;

import java.util.ArrayList;

public class Test {        
    public static void main(String[] args) {
        Casilla[][] tablero = {
            {
                new Casilla(0, 0, new boolean[]{false, true, true, false}, false),
                new Casilla(0, 1, new boolean[]{false, true, false, true}, false),
                new Casilla(0, 2, new boolean[]{false, false, true, true}, false),
                new Casilla(0, 3, new boolean[]{false, false, true, false}, false)
            },
            {
                new Casilla(1, 0, new boolean[]{true, true, true, false}, false),
                new Casilla(1, 1, new boolean[]{false, false, false, false}, false),
                new Casilla(1, 2, new boolean[]{false, true, true, false}, false),
                new Casilla(1, 3, new boolean[]{true, false, false, true}, false)
            },
            {
                new Casilla(2, 0, new boolean[]{true, true, true, false}, false),
                new Casilla(2, 1, new boolean[]{false, true, false, true}, false),
                new Casilla(2, 2, new boolean[]{true, true, true, true}, false),
                new Casilla(2, 3, new boolean[]{false, false, false, true}, false)
            },
            {
                new Casilla(3, 0, new boolean[]{true, true, false, false}, false),
                new Casilla(3, 1, new boolean[]{false, true, false, true}, false),
                new Casilla(3, 2, new boolean[]{true, true, false, true}, false),
                new Casilla(3, 3, new boolean[]{false, false, false, true}, true)
            }
        };

        ArrayList<Casilla> camino = new ArrayList<>();
        
        Laberinto laberinto = new Laberinto(tablero);        
        camino.add(tablero[0][0]);// este siempre sera el inicio                
        tablero[0][0].setVisitado(true);
        
        encontrarCaminos(laberinto, camino, tablero[0][0]);
        
        laberinto.mostrarCaminos();
    }
    
    
    public static void encontrarCaminos(Laberinto laberinto, ArrayList<Casilla> camino, 
            Casilla casillaActual) {
        
        if (casillaActual.isFin()) {
            laberinto.agregarCamino((ArrayList<Casilla>)camino.clone());
        } else {
            
            int[][] movimiento = {
                {-1, 0}, //arriba
                {0, 1}, //derecha
                {1, 0}, //abajo
                {0, -1} //izquierda          
            };
            
            int posX;
            int posY;
            Casilla casillaDestino;
            boolean agregar;
            
            for (int i = 0; i < movimiento.length; i++) {
                
                posX = casillaActual.getPosX() + movimiento[i][0];
                posY = casillaActual.getPosY() + movimiento[i][1];
                casillaDestino = laberinto.getCasillaAt(posX, posY);                
                
                agregar = false;
                switch (i) {
                    case 0:
                        if (laberinto.arribaDisponible(casillaActual, casillaDestino))
                            agregar = true;                                                    
                        break;
                    case 1:
                        if (laberinto.derechaDisponible(casillaActual, casillaDestino)) 
                            agregar = true;                                                    
                        break;
                    case 2:
                        if (laberinto.abajoDisponible(casillaActual, casillaDestino)) 
                            agregar = true;                                                    
                        break;
                    case 3:
                        if (laberinto.izquierdaDisponible(casillaActual, casillaDestino)) 
                            agregar = true;                                                    
                        break;                    
                }
                if (agregar) {
                    camino.add(casillaDestino);
                    casillaDestino.setVisitado(true);
                    encontrarCaminos(laberinto, camino, casillaDestino);
                    casillaDestino.setVisitado(false);
                    camino.remove(casillaDestino);                    
                }
            }
            
        }
        
    }
    
}
