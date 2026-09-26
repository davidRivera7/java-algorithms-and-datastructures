
package Ejercicio9;

public class ArrayInvertido {
    
    static void invertirArray(int[] numeros, int posIni, int posFin) {
        if (posIni < posFin) {
            int aux = numeros[posIni];
            numeros[posIni] = numeros[posFin];
            numeros[posFin] = aux;
            invertirArray(numeros, posIni + 1, posFin - 1);            
        }
    }
    
    static void invertirArray(int[] numeros, int i) {
        if (i <= (numeros.length - 1) / 2) {
            int aux = numeros[i];
            numeros[i] = numeros[numeros.length - 1 - i];
            numeros[numeros.length - 1 - i] = aux;
            invertirArray(numeros, i + 1);
        }
    }
    
    public static void main(String[] args) {
        int[] numeros = {};
        
        for (int i : numeros) 
            System.out.print(i + " ");
        
        System.out.println("");
//        invertirArray(numeros, 0, numeros.length - 1);
        invertirArray(numeros, 0);
        for (int i : numeros)
            System.out.print(i + " ");
        
        System.out.println("");
    }
    
}
