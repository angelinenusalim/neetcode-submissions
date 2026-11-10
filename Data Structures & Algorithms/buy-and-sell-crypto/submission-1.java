class Solution {
    public int maxProfit(int[] prices) {
        int left = 0;
        int profit = 0;
        int buy = prices[0];
        for (int right = 0; right < prices.length; right++) {
            profit = Math.max(profit, prices[right] - buy);
            buy = Math.min(buy, prices[right]);
        }
        return profit;
    }
}
