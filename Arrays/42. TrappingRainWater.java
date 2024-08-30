/**
 * Solution to the "Trapping Rain Water" problem on LeetCode.
 * Problem: https://leetcode.com/problems/trapping-rain-water/
 * Problem Description:
 * - Given an array of non-negative integers representing the heights of bars in a histogram,
 *   where the width of each bar is 1, calculate how much water it can trap after raining.
 * - The amount of water trapped at each index depends on the height of the tallest bars
 *   to the left and right of that index. Water can only be trapped if these bars are taller
 *   than the current bar, and the amount of water trapped is determined by the difference
 *   between the shorter of the two bars and the height of the current bar.
 *
 * Approach:
 * - We use a two-pointer technique to traverse the array from both ends, starting with a
 *   left pointer at the beginning of the array and a right pointer at the end.
 * - The key insight is that the amount of water that can be trapped at a given index is
 *   determined by the shorter of the maximum heights on the left and right sides of that index.
 * - We maintain two variables, `leftMax` and `rightMax`, to keep track of the maximum heights
 *   encountered so far from the left and right sides, respectively.
 * - If the height at the left pointer is less than or equal to the height at the right pointer,
 *   we calculate the trapped water based on `leftMax` and move the left pointer to the right.
 * - Otherwise, we calculate the trapped water based on `rightMax` and move the right pointer to the left.
 * - The loop continues until the two pointers meet, ensuring that all trapped water is calculated.
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
