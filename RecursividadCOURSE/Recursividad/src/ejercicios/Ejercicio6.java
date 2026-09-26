
package ejercicios;

public class Ejercicio6 {
    
    public static int maximo(int[] array, int i, int max) {
        if (i == array.length) 
            return max;
        else {            
            if (array[i] > max) 
                return maximo(array, i + 1, array[i]);
            
            return maximo(array, i + 1, max);            
        }
    }
    
    public static int maximo(int[] array, int i) {
        if (i == array.length - 1) {
            return array[i];
        } else {            
            int max = maximo(array, i + 1);
            return (array[i] < max) ? max : array[i];
        }
    }
    
    public static void main(String[] args) {
        int[] array = {1000, 70, 4, 51, 2000, 500};
        
        System.out.println("MaximoV1: " + maximo(array, 0));
        System.out.println("MaximoV2: " + maximo(array, 0, array[0]));
    }
    
}
