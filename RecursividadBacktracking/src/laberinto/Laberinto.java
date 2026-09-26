//esta bien
package laberinto;

import java.util.ArrayList;

public class Laberinto {
    
    static Celda[][] laberinto = {
            {
                new Celda("00", false, true, true, false), new Celda("01", false, true, false, true), 
                new Celda("02", false, false, true, true), new Celda("03", false, false, true, false)
            },
            {
                new Celda("10", true, true, true, false), new Celda("11", false, true, false, true), 
                new Celda("12", true, true, true, true), new Celda("13", true, false, false, true)
            },
            {
                new Celda("20", true, true, true, false), new Celda("21", false, true, false, true), 
                new Celda("22", true, true, true, true), new Celda("23", false, false, false, true)
            },
            {
                new Celda("30", true, true, false, false), new Celda("31", false, true, false, true), 
                new Celda("32", true, true, false, true), new Celda("33", false, false, false, true)
            }
        };        
    
    static int[][] movimientos = {
            {-1, 0},//arriba
            {0, 1},//derecha
            {1, 0},//abajo
            {0, -1}//izquierda
        };        
    
    //f y c marcan mi celda de inicio
    static void caminos(int f, int c, Celda fin,
            ArrayList<Celda> ruta) {
        
        if (laberinto[f][c] == fin) {
        
            System.out.print("(inicio) ");
            
            for (Celda celda : ruta)
                System.out.print(celda + " -> ");
                                        
            System.out.println("(fin).");
        } else {
                                    
            for (int i = 0; i < movimientos.length; i++) {
                
                f += movimientos[i][0];
                c += movimientos[i][1];
                
                if (esMovimientoValido(f, c) 
                    && laberinto[f - movimientos[i][0]][c - movimientos[i][1]].direcciones[i] 
                    && esCeldaPermitida(laberinto[f][c], ruta)) {
                    
                    ruta.add(laberinto[f][c]);                    
                    caminos(f, c, fin, ruta);    
                    ruta.removeLast();
                }
                
                f -= movimientos[i][0];
                c -= movimientos[i][1];                                                    
            }
            
        }
    }
    
    static boolean esMovimientoValido(int f, int c) {
        return f >= 0 && f < laberinto.length && 
                c >= 0 && c < laberinto[0].length;
    }
    
    static boolean esCeldaPermitida(Celda celdaNueva, ArrayList<Celda> ruta) {
        for (Celda c : ruta)
            if (celdaNueva == c)
                return false;
        
        return true;
    }        
    
    //f y c marcan mi celda de inicio
    static ArrayList<Celda> mejorCamino(int f, int c, Celda fin,
            ArrayList<Celda> ruta, ArrayList<Celda> mejor) {
        
        if (laberinto[f][c] == fin) {
        
            if (ruta.size() < mejor.size() || mejor.isEmpty()) {            
                mejor.clear();
                for (Celda celda : ruta) 
                    mejor.add(celda);                        
            }
            
        } else {
                                    
            for (int i = 0; i < movimientos.length; i++) {
                
                f += movimientos[i][0];
                c += movimientos[i][1];
                
                if (esMovimientoValido(f, c) 
                    && laberinto[f - movimientos[i][0]][c - movimientos[i][1]].direcciones[i] 
                    && esCeldaPermitida(laberinto[f][c], ruta)) {
                    
                    ruta.add(laberinto[f][c]);                    
                    mejorCamino(f, c, fin, ruta, mejor);
                    ruta.removeLast();
                }
                
                f -= movimientos[i][0];
                c -= movimientos[i][1];                                                    
            }
            
        }
        
        return mejor;
    }
    
    public static void main(String[] args) {        
        int fila = 0;
        int columna = 0;
        Celda fin = laberinto[3][3];
        
        
        ArrayList<Celda> ruta = new ArrayList<>();               
        ruta.add(laberinto[fila][columna]);                               
        caminos(fila, columna, fin, ruta);                        
        
        
        ruta.clear();
        ruta.add(laberinto[fila][columna]);
        
        System.out.println("");
        System.out.print("Mejor camino: ");
        for (Celda c : mejorCamino(fila, columna, fin, ruta, new ArrayList<>())) 
            System.out.print(c + " -> ");
        
        System.out.println("");
    }
}
