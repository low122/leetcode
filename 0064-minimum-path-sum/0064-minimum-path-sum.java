class Solution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[] dp = new int[cols];

        dp[cols - 1] = grid[rows - 1][cols - 1];
        for (int col = cols - 2; col >= 0; col--) {
            dp[col] = grid[rows - 1][col] + dp[col + 1];
        }

        for (int row = rows - 2; row >= 0; row--) {
            dp[cols - 1] += grid[row][cols - 1]; // rightmost column
            for (int col = cols - 2; col >= 0; col--) {
                dp[col] = grid[row][col] + Math.min(dp[col], dp[col + 1]);
            }
        }

        return dp[0]; // final result is in top-left
    }
}