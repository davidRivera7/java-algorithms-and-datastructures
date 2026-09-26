
package dardos;

public class Main {
    
    public static void main(String[] args) {
        int[] regiones = {0, 10, 25, 50, 75};
        int numeroDardos = 5;
        int[] tirosRegistrados = new int[numeroDardos];        
        int puntuacionAlcanzar = 100;
        
        primeraSolucionDardos(regiones, tirosRegistrados, 0, puntuacionAlcanzar);
        
        int[] tirosMejor = new int[numeroDardos];
        mejorSolucionDardos(regiones, tirosRegistrados, tirosMejor, 0, puntuacionAlcanzar);
        
        System.out.println("Mejor solucion:");
        for (int i : tirosMejor) 
            System.out.print(i + " - ");
        
//        System.out.println("\n\nTodas las combinaciones");
//        todasCombinacionesDardos(regiones, tirosRegistrados, 0, puntuacionAlcanzar);
    }
    
    static boolean primeraSolucionDardos(int[] regiones, int[] tiros,
            int iteradorTiros, int puntuacionAlcanzar) {                
        
        if (getSumaTiros(tiros) >= puntuacionAlcanzar) {
            
            System.out.println("Primera solucion:");
            for (int t : tiros) 
                System.out.print(t + " - ");
            
            System.out.println("");    
            return true;
            
        } else if (iteradorTiros < tiros.length) {                        
            
            boolean parar = false;
            
            for (int i = 0; i < regiones.length && !parar; i++) {                
                tiros[iteradorTiros] = regiones[i];
                parar = primeraSolucionDardos(regiones, tiros, iteradorTiros + 1, puntuacionAlcanzar);
                tiros[iteradorTiros] = 0;
            }
                        
            return parar;
        }
        return false;
    }
    
    static void mejorSolucionDardos(int[] regiones, int[] tirosAux, int[] tirosMejor, 
            int iteradorTirosAux, int puntuacionAlcanzar) {
        
        if (iteradorTirosAux == tirosAux.length) {
            
            int sumaTirosAux;
            
            if ((sumaTirosAux = getSumaTiros(tirosAux)) < puntuacionAlcanzar)
                return;
            
            if (sumaTirosAux > getSumaTiros(tirosMejor)) {                
                for (int i = 0; i < tirosAux.length; i++)
                    tirosMejor[i] = tirosAux[i];                                    
            }
            
        } else {
            
            for (int i = 0; i < regiones.length; i++) {                
                tirosAux[iteradorTirosAux] = regiones[i];
                mejorSolucionDardos(regiones, tirosAux, tirosMejor,
                        iteradorTirosAux + 1, puntuacionAlcanzar);
                tirosAux[iteradorTirosAux] = 0;
            }
            
        }
        
    }
    
    static void todasCombinacionesDardos(int[] regiones, int[] tiros, 
            int iteradorTiros, int puntuacionAlcanzar) {
        
        if (iteradorTiros == tiros.length) {
                                    
            if (getSumaTiros(tiros) >= puntuacionAlcanzar) {                            
                for (int i : tiros)
                    System.out.print(i + " - "); 
                
                System.out.println("");
            }
            
            
        } else {
            
            for (int i = 0; i < regiones.length; i++) {                
                tiros[iteradorTiros] = regiones[i];
                todasCombinacionesDardos(regiones, tiros, iteradorTiros + 1,
                        puntuacionAlcanzar);
                tiros[iteradorTiros] = 0;
            }
            
        }
        
    }        
    
    static int getSumaTiros(int[] tiros) {
        int suma = 0;
        
        for (int t : tiros)
            suma += t;
        
        return suma;
    }
    
}
