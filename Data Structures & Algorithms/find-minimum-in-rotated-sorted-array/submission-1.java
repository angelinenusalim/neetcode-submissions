class Solution {
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
        return nums[mid];
    }
}

// nums[low] = 3, nums[high] = 2, nums[mid] = 5
// low = 0, high = 5, mid = 2
// low = 3, nums[low] = 6, mid = 4, nums[mid] = 1
// high = 2, mid = 4, nums[high] = 
