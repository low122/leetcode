class Solution {
    public int maxSubarraySumCircular(int[] nums) {
    int total = 0;
    int maxSum = nums[0], currMax = 0;
    int minSum = nums[0], currMin = 0;

    for (int num : nums) {
        currMax = Math.max(num, currMax + num);
        maxSum = Math.max(maxSum, currMax);

        currMin = Math.min(num, currMin + num);
        minSum = Math.min(minSum, currMin);

        total += num;
    }

    if (maxSum < 0) return maxSum; // all negative
    return Math.max(maxSum, total - minSum);
    }

}