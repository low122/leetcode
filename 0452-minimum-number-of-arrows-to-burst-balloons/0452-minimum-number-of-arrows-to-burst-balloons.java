class Solution {
    public int findMinArrowShots(int[][] points) {
        
        // We have to find the overlap, if it is we need add 1 and "eliminate" the balloons
        // If it is not overlapping we can directly add 1

        int arrow = 0;

        Arrays.sort(points, (a,b) -> Integer.compare(a[1],b[1]));

        int[] curr = points[0];

        for (int i = 1; i < points.length; i++) {
            int[] next = points[i];

            if (curr[1] < next[0]) {
                // if it is not overlapping
                curr = next;
                arrow++;
            } else {
                // if it is overlapping
                curr[1] = Math.min(curr[1], next[1]);
            }
        }

        arrow++;

        return arrow;
    }
}