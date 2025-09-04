class Solution {
    public void gameOfLife(int[][] board) {

        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int numberOfOnes = 0;

                // Calculate the ONES for current point
                for (int r = i - 1; r <= i + 1; r++) {
                    for (int c = j - 1; c <= j + 1; c++) {

                        if (r == i && c == j) continue;

                        if (r < board.length && r >= 0 && c < board[0].length && c >= 0) {
                            if (board[r][c] == 1 || board[r][c] == -1) numberOfOnes++;
                        }
                    }
                }

                // This is for dead "0"
                // if 0 -> 1 then mark it as 2
                // else mark it as -1
                if (board[i][j] == 0) {
                    if (numberOfOnes == 3) {
                        board[i][j] = 2;
                    }
                } else {
                    if (numberOfOnes < 2 || numberOfOnes > 3) {
                        board[i][j] = -1;
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if (board[i][j] == 2) {
                    board[i][j] = 1;
                } else if (board[i][j] == -1) {
                    board[i][j] = 0;
                }
            }
        }
    }
}