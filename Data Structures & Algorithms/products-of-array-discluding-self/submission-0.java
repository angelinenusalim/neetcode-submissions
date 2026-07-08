class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        Arrays.fill(output, 1);
        int index = 0;
        // Key: Index, Value: nums
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(i, nums[i]);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int i = 0;
            while (index < nums.length && i < nums.length) {
                if (i != key) {
                    output[index] *= nums[i];
                }
                i++;
            }
            index++;
        }
        return output;
    }
}  
