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
        int output = binarySearch(nums, target, 0, cut - 1);
        if (output != -1) {
            return output;
        }
        return binarySearch(nums, target, cut, nums.length - 1);
    }
    public int binarySearch(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
