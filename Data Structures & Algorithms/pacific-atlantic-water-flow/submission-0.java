class Solution {
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int columns = heights[0].length;
        boolean[][] atlantic = new boolean[rows][columns];
        boolean[][] pacific = new boolean[rows][columns];
        for (int c = 0; c < columns; c++) {
            dfs(0, c, pacific, heights, heights[0][c]);
            dfs(rows - 1, c, atlantic, heights, heights[rows-1][c]);
        }
        for (int r = 0; r < rows; r++) {
            dfs(r, 0, pacific, heights, heights[r][0]);
            dfs(r, columns - 1, atlantic, heights, heights[r][columns - 1]);
        }
        List<List<Integer>> list = new ArrayList<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    list.add(Arrays.asList(r,c));
                }
            }
        }
        return list;

    }
    public void dfs(int row, int column, boolean[][] ocean, int[][] heights, int prevHeight) {
        if (row < 0 || column < 0 || row >= heights.length || column >= heights[0].length || ocean[row][column] ||
            heights[row][column] < prevHeight) {
            return;
        }
        ocean[row][column] = true;
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newColumn = column + dir[1];
            dfs(newRow, newColumn, ocean, heights, heights[row][column]);
        }

    }
}
