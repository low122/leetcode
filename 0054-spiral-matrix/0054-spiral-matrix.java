class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int top = 0, bottom = row - 1, left = 0, right = col - 1;
        List<Integer> result = new ArrayList<>();

        while (left <= right && top <= bottom) {
            for (int c = left; c <= right; c++) {
                result.add(matrix[top][c]);
            }
            top++;

            for (int c = top; c <= bottom; c++) {
                result.add(matrix[c][right]);
            }
            right--;

            if (top <= bottom) {
                for (int c = right; c >= left; c--) {
                    result.add(matrix[bottom][c]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int c = bottom; c >= top; c--) {
                result.add(matrix[c][left]);
            }
            left++;
            }
        }

        return result;
    }
} 