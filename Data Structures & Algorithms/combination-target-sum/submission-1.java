class Solution {

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int start = 0;
        List<Integer> path = new ArrayList<>();
        backtrack(nums, result, path, target, start);
        return result;

    }

    private void backtrack(int[] nums,  List<List<Integer>> result, List<Integer> path, int target, int start) {
        if (isSolution(path, target)) {
            result.add(new ArrayList<>(path));
            return;
        }
        int sum = 0;
        for (int i = 0; i < path.size(); i++) {
            sum += path.get(i);
            
        }
        if (sum > target) return;
        for (int i = start; i < nums.length; i++) {
            // choose 
            path.add(nums[i]);
            // explore
            backtrack(nums, result, path, target, i);
            // unchoose
            path.remove(path.size() - 1);
        }
        

    }

    private boolean isSolution(List<Integer> path, int target) {
        int sum = 0;
        for (int i = 0; i < path.size(); i++) {
            sum += path.get(i);
        }
        if (sum == target) {
            return true;
        }
        return false;
    }
    
}
