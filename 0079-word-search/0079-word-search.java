class Solution {
    public boolean exist(char[][] board, String word) {
        String record = "";

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (backtrack(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean backtrack(char[][] board, String word, int i, int j,int count) {

        if (count == word.length()) {
            return true;
        }

        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length ||
        board[i][j] != word.charAt(count)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '#';

        boolean checker = backtrack(board, word, i + 1, j, count + 1) ||
                        backtrack(board, word, i - 1, j, count + 1) ||
                        backtrack(board, word, i, j + 1, count + 1) ||
                        backtrack(board, word, i, j - 1, count + 1);

        board[i][j] = temp;


        return checker;
    }
    
}