
package quicksort;

public class Quicksort {
    
    static void quicksort(int[] array, int posStart, int posEnd) {
        if (posStart < posEnd) {
            
            int posLower = posStart - 1;
            int pivotValue = array[posEnd];            
            
            for (int i = posStart; i < posEnd; i++) {
                if (array[i] < pivotValue) {
                    int aux = array[posLower + 1];
                    array[posLower + 1] = array[i];
                    array[i] = aux;
                    
                    posLower++;
                }                
                
            }
                        
            int aux = array[posLower + 1];
            array[posLower + 1] = pivotValue;
            array[posEnd] = aux;
            
            int posPivot = posLower + 1;
            
            quicksort(array, posStart, posPivot - 1);
            quicksort(array, posPivot + 1, posEnd);
        } 
    }
    
    public static void main(String[] args) {
        int[] array = {10, 7, 8, 9, 1, 5};
        
        quicksort(array, 0, array.length - 1);
        
        for (int i : array) 
            System.out.print(i + " - ");
            
        System.out.println("");        
    }
    
}
