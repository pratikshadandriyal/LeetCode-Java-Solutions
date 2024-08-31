/**
 * The Solution class provides a method to calculate the maximum profit that can be achieved from 
 * buying and selling stock on different days.
 *
 * Problem: Given an array `prices` where `prices[i]` is the price of a given stock on the `i`th day, 
 * find the maximum profit you can achieve by buying on one day and selling on another day.
 * Note: You cannot sell a stock before you buy one.
 *
 * Approach:
 * - We need to find the maximum difference between the selling price and the buying price, 
 *   where the selling price comes after the buying price.
 * - Initialize `min` to the first element in the `prices` array to keep track of the minimum price 
 *   encountered so far.
 * - Initialize `profit` to 0, as the minimum profit in the worst case is 0 (i.e., no transaction).
 * - Iterate through the array, updating `min` to the current price if it is lower than the current `min`.
 * - For each price, calculate the profit by subtracting the current `min` from the current price, 
 *   and update `profit` if this new profit is greater than the previous `profit`.
 * - Finally, return the maximum `profit`.
 *
 * Time Complexity: O(n) - We only pass through the array once.
 * Space Complexity: O(1) - No extra space is used apart from a few variables.
 */
class Solution {
    public int maxProfit(int[] prices) {
        
        int profit = 0;        // Initialize profit to 0
        int min = prices[0];   // Start with the first price as the minimum price
        
        // Loop through each price in the array
        for(int i = 0; i < prices.length ; i++){
            
            // Update the minimum price if the current price is lower
            if(prices[i] < min){
                min = prices[i];
            }

            // Calculate the potential profit and update the max profit if it's higher
            profit = Math.max(profit , prices[i] - min);
        }
        
        // Return the maximum profit calculated
        return profit;
    }
}
