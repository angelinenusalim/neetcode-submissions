class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int curr = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] + curr < nums[i]) {
                curr = Math.max(nums[i], curr);
                max = Math.max(curr, max);
            } else {
                curr += nums[i];
                max = Math.max(curr, max);
            }
        }
        return max;
    }
}
