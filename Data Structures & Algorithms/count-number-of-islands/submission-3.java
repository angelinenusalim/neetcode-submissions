class Solution {
    int island = 0;
    public int numIslands(char[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1' && !visited[row][col]) {              
                    queue.offer(new int[]{row, col});
                    bfs(grid, visited, queue);
                }
            }
        }
        return island;
    }
    public void bfs(char[][] grid, boolean[][] visited, Queue<int[]> queue) {
        island++;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];
            visited[row][col] = true;
            int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
            for (int[] dir : dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if (newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length || visited[newRow][newCol] || grid[newRow][newCol] == '0') {
                    continue;
                }
                visited[newRow][newCol] = true;
                queue.offer(new int[] {newRow, newCol});
            } 
        }
    }
}
