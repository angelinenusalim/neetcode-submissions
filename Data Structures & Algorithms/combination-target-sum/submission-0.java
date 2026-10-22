class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        int start = 0;
        backtrack(result, currentPath, nums, target, start);
        return result;
    }

    private void backtrack(List<List<Integer>> result,  List<Integer> currentPath, int[] nums, int target, int start) {
        if (isSolution(currentPath, target)) {
            result.add(new ArrayList<>(currentPath));
            return;
        }
        int sum = 0;
        for (int i = 0; i < currentPath.size(); i++) {
            sum += currentPath.get(i);
        }
        if (sum > target) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            currentPath.add(nums[i]);
            backtrack(result, currentPath, nums, target, i);
            currentPath.remove(currentPath.size() - 1);
        }
    }

    private boolean isSolution(List<Integer> currentPath, int target) {
        int result = 0;
        for (int i = 0; i < currentPath.size(); i++) {
            result += currentPath.get(i);
        }
        if (result == target) {
            return true;
        }
        return false;
    }
}
