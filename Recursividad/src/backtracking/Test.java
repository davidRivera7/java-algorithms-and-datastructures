
package backtracking;

import java.util.ArrayList;

public class Test {
    
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();                                               
        getCombinationSum(4);
    }
    
    public static void getCombinationSum(int n) {
        ArrayList<Integer> numbers = new ArrayList<>();
        int sum = 0;
        combinationSum(n, numbers, sum);
    }
    
    private static void combinationSum(int n, ArrayList<Integer> numbers, int sum) {

        if (sum == n) {
            System.out.println(numbers);
        } else {
            for (int i = 1; i <= n; i++) {
                sum += i;
                if (sum <= n) {
                    numbers.add(i);
                    combinationSum(n, numbers, sum);
                    numbers.remove(numbers.indexOf(i));
                }
                sum -= i;
            }
        }
    }
    
    
    
}
