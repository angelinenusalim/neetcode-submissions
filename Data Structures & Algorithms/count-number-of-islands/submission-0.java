class Solution {
    private static final int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int islands = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    dfs(grid, r, c);
                    islands++;
                }
            }
        }
        return islands;
    }

    private void dfs(char[][] grid, int row, int column) {
        if (row < 0 || column < 0 || row >= grid.length || column >= grid[0].length || grid[row][column] == '0') {
            return;
        }
        grid[row][column] = '0';
        for (int[] dir : directions) {
            dfs(grid, row + dir[0], column + dir[1]);
        }

    }
}
