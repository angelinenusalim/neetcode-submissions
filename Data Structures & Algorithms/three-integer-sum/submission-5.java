class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (nums[i] + nums[left] + nums[right] == 0) {
                List<Integer> list = new ArrayList<>();
                Collections.addAll(list, nums[i], nums[left], nums[right]);
                set.add(list);
                left++;
                right--;
                } else if (sum > 0) {
                    right--;
                } else { // sum < 0
                    left++;
                }
            }
            
        }
        List<List<Integer>> output = new ArrayList<>(set);
        return output;
    }
}
