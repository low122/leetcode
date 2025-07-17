class Solution {
    public boolean canJump(int[] nums) {
        // if the "sum" exceeds the last element's position then next element...
        int sum = 0;
        int destination = nums.length-1;
        int position = nums.length-2;

        while (position >= 0) {
            if (nums[position]+position >= destination) {
                destination = position;
            }
            position--;
        }

        return destination == 0;
    }
}