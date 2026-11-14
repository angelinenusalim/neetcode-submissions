class Solution {
    int len = 0;
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        // dp[i] = length of the longest increasing subsequence that ENDS at index i
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            len = Math.max(len, dp[i]);
        }
        return len;
    }
}
