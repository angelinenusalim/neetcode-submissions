class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] output = new int[k];
        ArrayList<Integer> max = new ArrayList<>(); 
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());
        for (int i = 0; i < k; i++) {
            output[i] = list.get(i).getKey();
        }
        return output;
    }
}
