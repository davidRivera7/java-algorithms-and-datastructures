
package array03;

import java.util.ArrayList;

public class ContainsDuplicate {
    
    //si funciona pero excede limite de tiempo
    static boolean containsDuplicate(int[] nums) {
        quicksort(nums, 0, nums.length - 1);
        
        for (int i = 0; i < nums.length - 1; i++) {            
            if (nums[i] == nums[i + 1])
                return true;            
        }
        
        return false;
    }
    
    static void quicksort(int[] nums, int start, int end) {
        if (start < end) {
            
            int pivot = nums[end];
            int posLittle = start - 1;
            
            for (int i = start; i < end; i++) {               
                if (nums[i] < pivot) {
                    posLittle++;
                    int change = nums[posLittle];
                    nums[posLittle] = nums[i];
                    nums[i] = change;
                }                
            }
            
            int posPivot = posLittle + 1;
            int change = nums[posPivot];
            nums[posPivot] = pivot;
            nums[end] = change;
            
            quicksort(nums, start, posPivot - 1);
            quicksort(nums, posPivot + 1, end);
        }
    }
    
    //si funciona pero el limite excede
    static boolean containsDuplicate(int[] nums, int i, ArrayList<Integer> added) {
        if (i == nums.length) 
            return false;
        else {
            
            if (!added.contains(nums[i])) {                 
                added.add(nums[i]);
                return containsDuplicate(nums, i + 1, added);
            }
            
            return true;
        }
    }                                   
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        
        System.out.println(containsDuplicate(nums));
    }               
    
}
