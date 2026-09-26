/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order. 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
*/

package array01;

import java.util.ArrayList;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        return twoSum(nums, target, 0, 0, new ArrayList<Integer>(), new int[2]);
    }
    
    /*
    I use arrayList so that it allows me to store a first value which is the zero position. 
    If I used an 'int[]' array, all the values ​​in the array would be initialized to 
    zero and in this way I would never be able to enter the zero position to consider it in 
    my combination answers.
    */
    private static int[] twoSum(int[] nums, int tarjet, int iterator, int sum,
            ArrayList<Integer> positions, int[] twoPositionNumbers) {
        
        if (iterator == 2) {
            
            if (sum == tarjet)
                return twoPositionNumbers;
            
            return null;
            
        } else {            
            
            for (int i = 0; i < nums.length; i++) {
                
                if (isAllow(i, positions)) {                                      
                    
                    positions.add(i);
                    twoPositionNumbers[iterator] = i;
                    if (twoSum(nums, tarjet, iterator + 1, sum + nums[i],
                            positions, twoPositionNumbers) != null)
                        return twoPositionNumbers;
                    
                    twoPositionNumbers[iterator] = 0;
                    positions.removeLast();
                }
                                    
            }
            
            return null;
        }
        
    }
    
    private static boolean isAllow(int newPositionNumber, ArrayList<Integer> twoPositionNumbers) {
        if (twoPositionNumbers.isEmpty())
            return true;
        
        for (int i : twoPositionNumbers) 
            if (i == newPositionNumber)
                return false;
        
        return true;
    }                
    
    public static void main(String[] args) {        
        int[] integers = {2, 7, 11, 15};                                        
        int[] twoNumbers = twoSum(integers, 9);
        
        if (twoNumbers != null) {        
            for (int n : twoNumbers)
                System.out.print(n + " ");
            
            System.out.println("");
            System.exit(0);
        }                 
        
        System.out.println("There is no pair of numbers that added together achieve the objective");            
    }
    
}
