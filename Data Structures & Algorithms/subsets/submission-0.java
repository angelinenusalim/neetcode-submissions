class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(0, path, nums);
        return result;
    }
    void backtrack(int start, List<Integer> path, int[] nums) {
        result.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(i+1, path, nums);
            path.remove(path.size() - 1);
        }
    }
    
}
