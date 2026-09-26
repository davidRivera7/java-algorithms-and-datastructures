
package max;

public class Max {
    
    public static int max(int[] arr, int start, int end) {        
        if (start == end) 
            return arr[start];
        else             
            return Math.max(
                    max(arr, start, (start + end) / 2), 
                    max(arr, ((start + end) / 2) + 1, end));                                         
    }        
    
    /**     
     * @param arr
     * @param start
     * @param end
     * @param maxMin paso elementos cualesquiera EXISTENTES en el arreglo pensando que esos 
     * son mi Min y mi Max
     * @return 
     */
    public static int[] valuesMaxMin(int[] arr, int start, int end, int[] maxMin) {
                                   
        if (start == end)//retornamos unico                      
            return new int[] {arr[start]};
            
        else {
            
            int[] reference;
            
            reference = valuesMaxMin(arr, start, (start + end) / 2, maxMin);
            updateMaxMin(reference[0], maxMin);
            
            reference = valuesMaxMin(arr, ((start + end) / 2) + 1, end, maxMin);
            updateMaxMin(reference[0], maxMin);
                            
            return maxMin;                                        
        }                                        
    }
    
    /**
     * 
     * @param reference nuevo dato a comparar
     * @param maxMin almaceno mi Minimo en 0 y mi Maximo en 1
     */
    private static void updateMaxMin(int reference, int[] maxMin) {        
        if (reference < maxMin[0])
            maxMin[0] = reference;
            
        if (reference > maxMin[1])
            maxMin[1] = reference;           
    }
    
    public static void main(String[] args) {
        int[] numbers = {7, 10, 5, 3, 1, 8, 6, 2, 9};
        
        int[] maxMin = valuesMaxMin(numbers, 0, numbers.length - 1, 
                new int[] {numbers[0], numbers[0]});
        
        if (maxMin.length == 1)
            System.out.println("Unico elemento: " + maxMin[0]);
        else {
            System.out.println("menor: " + maxMin[0]);
            System.out.println("mayor: " + maxMin[1]);
        }
        
    }
}
