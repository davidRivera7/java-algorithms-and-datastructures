
package arraysIguales;

public class ArraysIguales {
    
    public static boolean equals(int[] arr1, int[] arr2, int start, int end) {
        
        if (arr1.length != arr2.length) 
            return false;
        
        if (start == end) 
            return arr1[start] == arr2[start];
        else {
            boolean e;
            
            e = equals(arr1, arr2, start, (start + end) / 2);
            
            if (!e) 
                return false;
            else 
                return equals(arr1, arr2, ((start + end) / 2) + 1, end);                       
        }        
    }
    
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8}; 
        
        System.out.println(equals(arr1, arr, 0, arr1.length - 1));
    }
    
}
