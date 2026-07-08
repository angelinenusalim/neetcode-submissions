class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int currentLength = 1;
        int maxLength = 1;
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + 1 == nums[i + 1]) {
                currentLength++;
            } else if (nums[i] == nums[i+1]) {
                continue;
            } else {
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                }
                currentLength = 1;
            }
            if (currentLength > maxLength) {
                maxLength = currentLength;
            }
        }
        return maxLength;
    }
}
