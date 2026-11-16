class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int res = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1 && !visited[r][c]) {
                    queue.offer(new int[] {r, c});
                    res = Math.max(res, bfs(grid, visited, queue));
                }
            }
        }
        return res;
    }
    int bfs(int[][] grid, boolean[][] visited, Queue<int[]> queue) {
        int size = 0;
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            size++;
            int row = curr[0];
            int col = curr[1];
            visited[row][col] = true;
            int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
            for (int[] dir : dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if (newRow < 0 || newCol < 0 || newRow >= grid.length || newCol >= grid[0].length || visited[newRow][newCol] || grid[newRow][newCol] == 0) {continue;}
                visited[newRow][newCol] = true;
                
                queue.offer(new int[] {newRow, newCol});
            }
            
        }
        return size;
    }
}
