
package ejercicios;

public class Ejercicio3 {
    
    public static String recorrerMatriz(int[][] matriz, int fila, int columna) {
        if (fila == matriz.length) {
            return "";
        } else {
            if (columna < matriz[fila].length)
                return matriz[fila][columna] + " - " + recorrerMatriz(matriz, fila, columna + 1);
            
            return "\n" + recorrerMatriz(matriz, fila + 1, 0);
        }        
    }
    
    public static int valorPosicionFibonacci(int pos) {
        if (pos >= 0 && pos <= 2) {
            
            if (pos == 0)
                return 0;
            
            return 1;
            
        } else             
            return valorPosicionFibonacci(pos - 1) + valorPosicionFibonacci(pos - 2);                    
    }
    
    public static int loopFibonacci(int posFibonacci) {
                        
        if (posFibonacci == 0) 
            return 0;
        
        if (posFibonacci == 1 || posFibonacci == 2)
            return 1;
               
        int anteriorPos = 1;
        int siguientePos = 1;
        int nuevaPos = 0;
        
        for (int i = 0; i < posFibonacci - 2; i++) {
            nuevaPos = anteriorPos + siguientePos;
            anteriorPos = siguientePos;
            siguientePos = nuevaPos;
        }        
        return nuevaPos;
    }
            
    public static void main(String[] args) {
//        int[][] matriz = {
//            {1, 2, 4, 6},
//            {19, 67, 2},
//            {100, 200}
//        };
        
//        System.out.print(recorrerMatriz(matriz, 0, 0));
        int posFibonacci = 40;
        System.out.println("Posicion fibonacci: " + posFibonacci);        
        System.out.println("Valor recursivo: " + valorPosicionFibonacci(posFibonacci)); //lento
        System.out.println("Valor loop: " + loopFibonacci(posFibonacci)); //rapido
    }
    
}
