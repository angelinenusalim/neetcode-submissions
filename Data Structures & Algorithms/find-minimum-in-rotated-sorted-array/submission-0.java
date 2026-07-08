class Solution {
    public int findMin(int[] nums) {
         int left = 0;
         int right = nums.length - 1;
         int mid = right/2;
         while (right > left) {
            if (nums[mid] > nums[right]) {
                left = mid + 1;
                mid = (right + left)/2;
            } else {
                right = mid;
                mid = (right + left)/2;
            }
         }
         
         return Math.min(nums[left], nums[right]);
    }
}
