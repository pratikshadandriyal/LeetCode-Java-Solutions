/**
 * Solution to the "Trapping Rain Water" problem on LeetCode.
 * Problem: https://leetcode.com/problems/trapping-rain-water/
 *
 * This solution uses a two-pointer approach to calculate the amount of trapped water.
 * The left and right pointers traverse the array from both ends, while keeping track
 * of the maximum heights encountered so far on both sides.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
 
public class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int totalWater = 0;

        while (left <= right) {
            if (height[left] <= height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                totalWater += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                totalWater += rightMax - height[right];
                right--;
            }
        }

        return totalWater;
    }
}
