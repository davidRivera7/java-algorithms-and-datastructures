
package divide_y_venceras;

public class Quicksort {

    public static void quicksort(int[] arr, int start, int end) {
        
        if (start < end) {

            int small = start -1;
            int pivot = arr[end];

            for (int i = start; i < end; i++) {
                if (arr[i] < pivot) {
                    small++;
                    int current = arr[i];
                    arr[i] = arr[small];
                    arr[small] = current;
                }
            }
                                    
            int aux = arr[small + 1];
            arr[small + 1] = pivot;
            arr[end] = aux;
            
            pivot = small + 1;
            
            quicksort(arr, start, pivot - 1);            
            quicksort(arr, pivot + 1, end);
            
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {10, 80, 30, 90, 40, 50, 70};
        
        quicksort(arr, 0, arr.length - 1);
        
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }  
}