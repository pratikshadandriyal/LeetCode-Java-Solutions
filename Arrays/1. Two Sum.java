/**
 * TwoSumSolution class provides different approaches to solve the Two Sum problem.
 * Problem: Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * Approaches:
 * 1. Brute-Force Approach
 * Iterate through each pair of elements in the array and check if they add up to the target.
 * 2. Better Approach using HashMap
 * Use a HashMap to store the indices of the array elements. For each element, check if the complement (target - element) exists in the map.
 * 3. Optimal Approach using a single-pass HashMap
 * This is similar to the better approach but optimized for single pass through the array
 *
 * Edge Cases Considered:
 * - Array length less than 2
 * - No solution exists (handled by exception)
 * - Duplicate elements leading to a valid solution
 * 
 * Time Complexities:
 * - Brute-Force: O(n^2)
 * - Better: O(n)
 * - Optimal: O(n)
 */

import java.util.HashMap;
import java.util.Map;

public class TwoSumSolution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution found.");
    }
    
    public static void main(String[] args) {
        TwoSumSolution solution = new TwoSumSolution();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = solution.twoSum(nums, target);
        
        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }
}
