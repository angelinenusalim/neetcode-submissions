class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    List<Integer> list = new ArrayList<>();
                    Collections.addAll(list, nums[left], nums[i], nums[right]);
                    set.add(list);
                    left++;
                    right--;
                }
            }
        }
        List<List<Integer>> output = new ArrayList<>(set);
        return output;
    }
}
