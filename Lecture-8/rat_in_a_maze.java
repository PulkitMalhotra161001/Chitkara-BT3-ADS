public class rat_in_a_maze {
    private static final int[][] DIR = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public boolean maze(boolean[][] maze) {
        int n = maze.length;
        int m = maze[0].length;
        boolean[][] visited = new boolean[n][m];
        return solve(0, 0, n - 1, m - 1, maze, visited);
    }

    private boolean solve(int curRow, int curCol, int destRow, int destCol, boolean[][] maze, boolean[][] visited) {
        if (curRow == destRow && curCol == destCol) {
            return true;
        }

        visited[curRow][curCol] = true;

        for (int[] dir : DIR) {
            int newRow = curRow + dir[0];
            int newCol = curCol + dir[1];
            if (isValid(newRow, newCol, maze.length, maze[0].length) && !visited[newRow][newCol] && maze[newRow][newCol]) {
                if (solve(newRow, newCol, destRow, destCol, maze, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isValid(int row, int col, int numRows, int numCols) {
        return row >= 0 && row < numRows && col >= 0 && col < numCols;
    }

    public static void main(String[] args) {
        rat_in_a_maze rat = new rat_in_a_maze();
        boolean[][] maze = {
            {true, false, false, false},
            {true, true, false, true},
            {false, true, false, false},
            {true, true, true, true}
        };
        System.out.println(rat.maze(maze)); // true
    }
}
