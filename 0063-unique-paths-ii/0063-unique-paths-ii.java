class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        Map<String, Integer> dp = new HashMap<>();
        String key = row + "," + col;
        dp.put(key, -1);
        int count = pathCounter(obstacleGrid, dp, 0, 0);

        return count;
    }

    public int pathCounter(int[][] obstacleGrid, Map<String, Integer> dp, int r, int c) {

        String key = r + "," + c;

        // Base case

        // 1. Check row and col out of bound and obstacle
        if (r == obstacleGrid.length || c == obstacleGrid[0].length ||
        obstacleGrid[r][c] == 1) {
            return 0;
        }

        if (r == obstacleGrid.length - 1 && c == obstacleGrid[0].length - 1) {
            return 1;
        }

        // 2. Check visited node
        
        if (dp.containsKey(key)) return dp.get(key);

        // 3. Do the recursion
        int down = pathCounter(obstacleGrid, dp, r + 1, c);
        int right = pathCounter(obstacleGrid, dp, r, c + 1);
        int totalPaths = down + right;

        dp.put(key, totalPaths);
        
        // 4. Return the solution

        return totalPaths;
    }
}