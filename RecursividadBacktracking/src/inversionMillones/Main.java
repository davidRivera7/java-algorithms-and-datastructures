//esta correcto, MUY BUENA SOLUCION.
//comienza de atras. Es meramente recursivo.
package inversionMillones;

public class Main {
    
    public static void main(String[] args) {
        int numeroMillones = 4;
        int[][] bancos = {            
            {0, 2, 5, 6, 7}, //Banco 1
            {0, 1, 3, 6, 7},
            {0, 1, 2, 5, 8} //... Banco 3
        };
        
        int[] mejoresInversiones = new int[bancos.length];
        invirtiendoMillones(bancos, new int[bancos.length], 
                mejoresInversiones, 0, numeroMillones);
        
        for (int i = 0; i < mejoresInversiones.length; i++)
            System.out.println("Banco " + (i + 1) + ": Millones invertidos = " + mejoresInversiones[i] +
                    ", Rentabilidad = " + bancos[i][mejoresInversiones[i]]);
        
        System.out.println("Rentabilidad total = " + getTotalInversion(bancos, mejoresInversiones));
    }
    
    /**
     * 
     * @param bancos
     * @param pruebaInversiones guarda la cantidad de millones a invertir, no la rentabilidad que
     * recibimos por invertir ese numero de millones.
     * @param mejoresInversiones
     * @param etapa
     * @param millones 
     */
    static void invirtiendoMillones(int[][] bancos, int[] pruebaInversiones, 
            int[] mejoresInversiones, int etapa, int millones) {
        
        if (millones == 0) {
            
            if (esMayorPruebaInversion(bancos, pruebaInversiones, mejoresInversiones)) {                
                for (int i = 0; i < pruebaInversiones.length; i++) 
                    mejoresInversiones[i] = pruebaInversiones[i];                
            }                        
            
        } else {
                            
            for (int i = 0; i <= millones; i++) {
                      
                if (etapa == bancos.length - 1) { //invertimos todo, no nos puede sobrar.                                        
                    
                    pruebaInversiones[etapa] = millones;
                    invirtiendoMillones(bancos, pruebaInversiones,
                            mejoresInversiones, etapa, millones - millones);
                    pruebaInversiones[etapa] = 0;
                    break;
                } else {
                    
                    pruebaInversiones[etapa] = i;
                    invirtiendoMillones(bancos, pruebaInversiones, 
                            mejoresInversiones, etapa + 1, millones - i);
                    pruebaInversiones[etapa] = 0;
                }
                                
            }                                    
                                            
        }
        
    }
    
    static boolean esMayorPruebaInversion(int[][] bancos, int[] pruebaInversion, int[] mejorInversion) {
        int pruebaInv = 0;
        int mejorInv = 0;
        
        for (int i = 0; i < pruebaInversion.length; i++) {            
            pruebaInv += bancos[i][pruebaInversion[i]];
            mejorInv += bancos[i][mejorInversion[i]];
        }
        
        return pruebaInv > mejorInv;       
    }
    
    static int getTotalInversion(int[][] bancos, int[] inversion) {
        int total = 0;
        
        for (int i = 0; i < inversion.length; i++)
            total += bancos[i][inversion[i]];
        
        return total;
    }
    
}
