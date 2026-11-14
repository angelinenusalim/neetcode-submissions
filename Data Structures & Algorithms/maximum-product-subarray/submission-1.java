class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int resMax = Integer.MIN_VALUE;
        int resMin = Integer.MIN_VALUE;
        int[] dpMax = new int[nums.length];
        int[] dpMin = new int[nums.length];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dpMax[i] = Math.max(dpMax[i-1]*nums[i], nums[i]);
            dpMax[i] = Math.max(dpMin[i-1]*nums[i], dpMax[i]);
            dpMin[i] = Math.min(dpMin[i-1]*nums[i], nums[i]);
            dpMin[i] = Math.min(dpMax[i-1]*nums[i], dpMin[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            resMax = Math.max(resMax, dpMax[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            resMax = Math.max(resMax, dpMin[i]);
        }
        return resMax;
    }
}
