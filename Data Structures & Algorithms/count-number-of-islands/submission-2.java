class Solution {
    int island = 0;
    public int numIslands(char[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1' && !visited[row][col]) {
                    queue.offer(new int[]{row, col});
                    bfs(grid, queue, visited);
                }
            }
        }
        return island;
    }

    public void bfs(char[][] grid, Queue<int[]> queue, boolean[][] visited) {
        island++;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];

            // Explore
            int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            for (int[] dir : directions) {
                int newRow = r + dir[0];
                int newCol = c + dir[1];

                // Prune
                if (newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length || visited[newRow][newCol] || grid[newRow][newCol] == '0') {
                    continue;
                }

                visited[newRow][newCol] = true;
                queue.offer(new int[] {newRow, newCol});
            }
        }

        
    }
}
