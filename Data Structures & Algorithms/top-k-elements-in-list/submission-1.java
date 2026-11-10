class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // key = num, val = frequency
        int[] output = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        // current map contains: <1, 1> <2, 2> <3, 3>
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> Integer.compare(b.getValue(), a.getValue()));
        for (int i = 0; i < k; i++) {
            output[i] = list.get(i).getKey();
        }

        return output;
    }
}
