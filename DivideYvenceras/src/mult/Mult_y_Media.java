
package mult;

public class Mult_y_Media {
    
    public static int mult(int[] array, int start, int end) {                
        
        if (start == end) {
            return array[start];
        } else {                      
            return mult(array, start, (start + end) / 2) * 
                    mult(array, ((start + end) / 2) + 1, end);
        }        
    }
    
    public static int media(int[] array, int start, int end) {
        
        if (start == end) {
            return array[start];
        } else {
            return (media(array, start, (start + end) / 2) + media(array, ((start + end) / 2) + 1, end)) / 2;
        }
        
    }
                      
}
