class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] cache = new int[amount + 1];
        Arrays.fill(cache, -1);
        int output = dfs(coins, amount, cache);
        if (output >= (int) 1e9) {
            return - 1;
        } else return output;
    }
    public int dfs(int[] coins, int amount, int[] cache) {
        if (amount == 0) return 0;
        if (cache[amount] != -1) return cache[amount];
        int output = (int) 1e9;
        for (int i = 0; i < coins.length; i++) {
            if (amount - coins[i] >= 0) {
                output = Math.min(output, 1 + dfs(coins, amount - coins[i], cache));
            }
            cache[amount] = output;
        }
        return output;
    }
}
