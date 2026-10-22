class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        int start = 0;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (dfs(board, word, visited, row, col, start)) {
                    return true;
                };
            }
        }
        return false;
        
    }

    private boolean dfs(char[][] board, String word, boolean[][] visited, int row, int col, int start) {
        // valid 
        if (start == word.length()) {
            return true;
        }
        int rowSize = board.length;
        int colSize = board[0].length;
        // prune
        if (row < 0 || col < 0 || row >= rowSize || col >= colSize || visited[row][col] || board[row][col] != word.charAt(start)) {
            return false;
        }
        // set node as visited 
        visited[row][col] = true;
        // explore 
        boolean res = dfs(board, word, visited, row+1, col, start + 1) ||
                    dfs(board, word, visited, row, col+1, start + 1) ||
                    dfs(board, word, visited, row-1, col, start + 1) ||
                    dfs(board, word, visited, row, col-1, start + 1);

        // unchoose the node  
        visited[row][col] = false;

        return res;
    }
}
