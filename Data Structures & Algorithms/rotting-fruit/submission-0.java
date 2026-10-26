class Solution {
    int fresh = 0;
    int time = 0;
    public int orangesRotting(int[][] grid) {
        Queue<int[]> rotten = new LinkedList<>();
        // count fresh oranges 
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    fresh++;
                } else if (grid[row][col] == 2) {
                    rotten.offer(new int[]{row, col});
                }
            }
        }
        bfs(grid, rotten);
        if (fresh != 0) {
            return -1;
        }
        return time;
    }
    public void bfs(int[][] grid, Queue<int[]> rotten) {
        while (!rotten.isEmpty()) {
            int size = rotten.size();
            boolean rot = false;
            for (int i = 0; i < size; i++) {
                int[] current = rotten.poll();
                int r = current[0];
                int c = current[1];
                int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            for (int[] dir : directions) {
                int newRow = r + dir[0];
                int newCol = c + dir[1];
                if (newRow < 0 || newRow >= grid.length ||
                    newCol < 0 || newCol >= grid[0].length ||
                    grid[newRow][newCol] != 1 || fresh < 0) {
                    continue;
                }
                grid[newRow][newCol] = 2;
                rot = true;
                fresh--;
                rotten.offer(new int[]{newRow, newCol});
            }
        }
            
        if (rot) {
            time++;
        }
        }
        
    }
}
