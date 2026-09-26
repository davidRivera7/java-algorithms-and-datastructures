
package multiplicacion;

public class Main {
    
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        
        System.out.println("Multiplicacion = " + multiplicacionArray(array, 0, array.length - 1));
    }
    
    static int multiplicacionArray(int[] array, int inicio, int fin) {
        if (inicio == fin) 
            return array[inicio];
        else {
            int mitad = (inicio + fin) / 2;
            return multiplicacionArray(array, inicio, mitad) * 
                    multiplicacionArray(array, mitad + 1, fin);
        }
    }
    
}
