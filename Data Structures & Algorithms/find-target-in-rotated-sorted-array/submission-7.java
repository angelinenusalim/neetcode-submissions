class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = right/2;
        while (right > left) {
            mid = (left + right) / 2;
            if (nums[mid] > nums[right]) { 
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int cut = right;
        left = 0;
        right = nums.length - 1;
        for (int i = 0; i < cut; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        for (int i = cut; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        
        return -1;
    }
}
