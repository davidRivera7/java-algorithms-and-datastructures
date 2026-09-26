//Given an integer array nums, find the subarray with the largest sum, and return its sum.
//correct
package array05;

public class MaximumSubarray {
    
    public static int maxSubArray(int[] nums) {
        
        int result = nums[0];
        int total = 0;
        
        
        for (int n : nums) {                                    
            total += n;
            result = Math.max(result, total);
            
            if (total < 0)
                total = 0;            
        }
        
        return result;
    }    
        
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        
        System.out.println(maxSubArray(nums));
        
    }
    
}
