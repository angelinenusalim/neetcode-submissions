class Solution {
    public int search(int[] nums, int target) {
        int min = findMin(nums);
        int low;
        int high;

        if (min == 0) {
            low = 0;
            high = nums.length - 1;
        } else if (target >= nums[0]) {
            low = 0;
            high = min - 1;
        } else {
            low = min;
            high = nums.length - 1;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int mid = (high + low) / 2;
        while (low < high) {
            if (nums[mid] > nums[high]) { // change low to mid + 1 because there might be where the min is 
                low = mid + 1;
                mid = (high + low) / 2;
            } else { // nums mid <= nums high
                high = mid;
                mid = (high + low) / 2;
            }
        }
        return mid;
    }
}
