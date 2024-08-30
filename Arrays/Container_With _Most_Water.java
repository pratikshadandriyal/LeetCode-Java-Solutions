/**
 * Solution to the "Container With Most Water" problem on LeetCode.
 * Problem: https://leetcode.com/problems/container-with-most-water/
 *
 * Problem Description:
 * - Given an array `height` of non-negative integers where each integer represents
 *   the height of a vertical line drawn at that index, find two lines that together
 *   with the x-axis forms a container that holds the most water.
 * - The objective is to maximize the area formed between the pair of lines.
 *
 * Approach:
 * - We use a two-pointer technique, starting with one pointer at the beginning
 *   of the array (`left`) and the other at the end (`right`).
 * - The area of water that can be contained is determined by the shorter line
 *   and the distance between the two lines (width).
 * - We calculate the area at each step and update the maximum area found.
 * - To maximize the area, we move the pointer that points to the shorter line,
 *   as moving the pointer pointing to the taller line would only decrease the width
 *   without increasing the height.
 *
 * Time Complexity: O(n) - We traverse the array once.
 * Space Complexity: O(1) - No additional space is required beyond a few variables.
 *
 * Example:
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The maximum area of water the container can hold is 49 units.
 *
 * Edge Cases:
 * - If the array has less than 2 heights, no container can be formed.
 * - Handles cases where all lines are of the same height.
 *
 * This solution is efficient and widely applicable, making it suitable for coding interviews.
 */
public class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            // Calculate the width and height
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);

            // Update the maximum area found
            maxArea = Math.max(maxArea, minHeight * width);

            // Move the pointers to try and find a larger area
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
