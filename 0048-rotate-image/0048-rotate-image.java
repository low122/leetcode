class Solution {
    public void rotate(int[][] matrix) {
        int top = 0, left = 0, bottom = matrix.length-1, right = matrix.length-1;

        while (left < right && top < bottom) {

            int temp;
            
            for (int i = 0; i < right - left; i++) {
                int a = matrix[top][left+i];
                int b = matrix[top+i][right];
                int c = matrix[bottom][right-i];
                int d = matrix[bottom-i][left];

                matrix[top][left+i] = d;
                matrix[top+i][right] = a;
                matrix[bottom][right-i] = b;
                matrix[bottom-i][left] = c;
            }
            top++;
            left++;
            right--;
            bottom--;
        }
    }
}