
package sumaArray;

public class Main {
    
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};        
        
        System.out.println("Suma array = " + sumaArray(array, 0, array.length - 1));
    }
    
    static int sumaArray(int[] array, int posInicio, int posFin) {
        if (posInicio == posFin) {
            return array[posInicio];
        } else {
            int mitad = (posInicio + posFin) / 2;
            return sumaArray(array, posInicio, mitad) + sumaArray(array, mitad + 1, posFin);            
        }
    }        
    
}
