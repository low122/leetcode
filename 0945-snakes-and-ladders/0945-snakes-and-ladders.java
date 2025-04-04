class Solution {
    public int snakesAndLadders(int[][] board) {

        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();
        int step = 0;
        int count = 1;
        boolean leftToRight = true;
        Queue<Integer> queue = new LinkedList<>();
        int destination = board.length * board.length;

        // First we need to mark each position of the board...
        // Start from the left bottom, which is from i = board.length and j = 0
        // if not -1, which is the destination of the current node
        // So a hashmap<new number, destination>
        for (int i = board.length-1; i >= 0; i--) {
            if (leftToRight) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] != -1) {
                        map.put(count, board[i][j]);
                    } else {
                        map.put(count, count);
                    }
                    System.out.println(count + " " + board[i][j]);
                    count++;
                }
            } else {
                for (int j = board[i].length-1; j >= 0; j--) {
                    if (board[i][j] != -1) {
                        map.put(count, board[i][j]);
                    } else {
                        map.put(count, count);
                    }
                    System.out.println(count + " " + board[i][j]);
                    count++;
                }
            }

            leftToRight = !leftToRight;
        }

        int width = board.length-1;
        queue.add(1); // start from the beginning
        visited.add(1);

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int currValue = queue.remove();
                
                if (currValue == destination) {
                    return step;
                }

                for (int dice = 1; dice <= 6; dice++) {
                    int tempDestination = currValue + dice;

                    if (tempDestination > destination) {
                        break;
                    }

                    int tempPosition = map.getOrDefault(tempDestination, tempDestination);
                    if (!visited.contains(tempPosition)) {
                        queue.add(tempPosition);
                        visited.add(tempPosition);
                    }
                }
            }

            step++;
        }

        return -1;
    }
}