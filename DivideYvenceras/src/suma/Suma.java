
package suma;

public class Suma {

    public static int sum(int[] numbers, int start, int end) {
        
        if (start == end) {
            return numbers[start];
        } else {                                                            
            return sum(numbers, start, (start + end) / 2)
            + sum(numbers, ((start + end) / 2) + 1, end);
        }
        
    }
    
    
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7};
        
        System.out.println(sum(numbers, 0, numbers.length - 1));
    }
    
}
