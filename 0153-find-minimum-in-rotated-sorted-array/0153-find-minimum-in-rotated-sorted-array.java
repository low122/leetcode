class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int result = 5001;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            result = Math.min(result, nums[mid]);

            // Sorted Left
            if (nums[mid] <= nums[right]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }
}