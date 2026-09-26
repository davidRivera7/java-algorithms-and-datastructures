//es correcta pero excede el limite de tiempo
package array04;

public class ProductOfArrayExceptSelf {
    
    static int[] productExceptSelf(int[] nums) {
        
        int[] answer = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            answer[i] = productAll(nums, 0, i - 1) * productAll(nums, i + 1, nums.length - 1);
        }
        
        return answer;
    }
    
    static int productAll(int[] nums, int start, int end) {
        
        if (start == end) 
            return nums[start];
        
        else if (start < end) {            
            int middle = (start + end) / 2;
            return productAll(nums, start, middle) * productAll(nums, middle + 1, end);            
        }
        
        return 1;
    }
    
    public static void main(String[] args) {
        
        int[] nums = {1, 2, 3, 4};
                
        for (int i : productExceptSelf(nums)) 
            System.out.print(i + ", ");
      
        System.out.println("\nOriginal:");
        for (int i : nums) 
            System.out.print(i + ", ");
        
        System.out.println("");    
                
    }
    
}
