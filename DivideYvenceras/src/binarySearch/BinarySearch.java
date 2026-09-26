
package binarySearch;

public class BinarySearch {
    
    public static void binarySearch(int[] array, int start, int end, int search, int turns) {
        
        int media = (start + end) / 2;       
        
        if (array[media] == search) 
            System.out.println("i: " + media + " -> " + array[media]);
            
        else if (search < array[media] && turns != 0)             
            binarySearch(array, start, media - 1, search, turns - 1);
            
        else if (search > array[media] && turns != 0) 
            binarySearch(array, media + 1, end, search, turns - 1);                       
    }         
    
}
