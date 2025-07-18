class Solution {
    public int jump(int[] nums) {
        int numberOfSteps = 0;
        int endOfCurrentJump = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {

            farthest = Math.max(farthest, i + nums[i]);

            if (i == endOfCurrentJump) {
                numberOfSteps++;
                endOfCurrentJump = farthest;
            }
        }

        return numberOfSteps;
        
    }
}