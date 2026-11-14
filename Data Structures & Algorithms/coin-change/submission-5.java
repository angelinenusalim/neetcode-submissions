class Solution {;
    HashSet<Integer> visited = new HashSet<>();
    public int coinChange(int[] coins, int amount) {
        return bfs(coins, amount);
    }

    public int bfs(int[] coins, int amount) {
        if (amount == 0) return 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {amount, 0});
        visited.add(amount);
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int remaining = curr[0];
            int coinsUsed = curr[1];
            for (int coin : coins) {
                int nextRemaining = remaining - coin;
                int nextCoinsUsed = coinsUsed + 1;
                if (visited.contains(nextRemaining)) continue;
                
                if (nextRemaining == 0) {
                    return nextCoinsUsed;
                } else if (nextRemaining < 0) {
                    continue;
                }
                visited.add(nextRemaining);
                queue.offer(new int[] {nextRemaining, nextCoinsUsed});

            } 
        }
        return -1;
    }
}
