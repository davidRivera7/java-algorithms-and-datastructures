//si se repiten combinaciones
package dardos;

public class Main {

    public static void main(String[] args) {
        int[] regions = {10, 25, 50, 75};        
        combinations(regions, new int[5], 0);

//        int[] best = {1, 1, 1, 1, 1};//rellenamos para que el numero de tiros sea lo mas alto posible
//        bestShot(regions, new int[5], 0, best);
//        
//        for (int i : best) {
//            if (i != 0)
//            System.out.print(i + ", ");
//        }
//        System.out.println("= " + getPunctuation(best) + ", n tiros = " + countShots(best));
    }
    
    /**
     * el jugador debe alcanzar la puntuacion de 100 con n dardos, al alcanzarlo deja 
     * de lanzar
     * @param regions
     * @param shots
     * @param stage 
     */
    public static void combinations(int[] regions, int[] shots, int stage) {
        
        int punctuation = getPunctuation(shots);
        
        if (punctuation >= 100) { //100 es la puntuacion a lograr o superar
            
            for (int i : shots) {
                if (i != 0)
                    System.out.print(i + ", ");
            }
            System.out.println("= " + punctuation + ", tiros = " + stage);
            
        } else {
            
            for (int i = 0; i < regions.length; i++) {
                
                if (stage < 5) { //5 el numero de dardos
                    shots[stage] = regions[i];                                        
                    combinations(regions, shots, stage + 1);
                    shots[stage] = 0;
                }
            }
            
        }
        
    }
    
    public static int getPunctuation(int[] shots) {
        int sum = 0;
        
        for (int i : shots) {
            sum += i;
        }
        
        return sum;
    }
    
    public static int countShots(int[] shots) {
        int n = 0;
        
        for (int i : shots) {
            if (i != 0) 
                n++;
        }
        
        return n;
    }
    
    /**
     * mejor tiro, mayor puntuacion que supere 100 y con menos tiros posibles
     * @param regions
     * @param shots
     * @param stage
     * @param best 
     */
    public static void bestShot(int[] regions, int[] shots, int stage, 
            int[] best) {
        
        int punctuation = getPunctuation(shots);
        
        if (punctuation >= 100) {
            
            if (punctuation >= getPunctuation(best) && stage < countShots(best)) {
                
                for (int i = 0; i < best.length; i++) {
                    best[i] = shots[i];
                }                                                                
            }                        
            
        } else {
            
            for (int i = 0; i < regions.length; i++) {
                
                if (stage < 5) {
                    shots[stage] = regions[i];                                        
                    bestShot(regions, shots, stage + 1, best);
                    shots[stage] = 0;
                }
            }
            
        }
        
    }
    
    
    
}
