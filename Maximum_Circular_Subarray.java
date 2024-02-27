class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSumNormal = kadane(nums); // Maximum sum using Kadane's algorithm
        
        if (maxSumNormal < 0) {
            return maxSumNormal; // If all numbers are negative, return maxSumNormal
        }

        int totalSum = 0;
        for (int num : nums) {
            totalSum += num; // Calculate the total sum of the array
        }

        int[] negativeNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            negativeNums[i] = -nums[i]; // Negate all numbers to find minimum sum subarray
        }
        int minSumSubarray = kadane(negativeNums); // Minimum sum subarray using Kadane's algorithm

        int maxSumCircular = totalSum + minSumSubarray; // Maximum sum circular subarray

        return Math.max(maxSumNormal, maxSumCircular); // Return the maximum of maxSumNormal and maxSumCircular
    }

    private static int kadane(int[] nums) {
        int maxSoFar = nums[0]; // Initialize maxSoFar with the first element
        int maxEndingHere = nums[0]; // Initialize maxEndingHere with the first element

        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            // Compare current element with the sum of current element and previous maxEndingHere
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
            // Update maxSoFar if maxEndingHere is greater
        }

        return maxSoFar; // Return the maximum sum found
    }
}
