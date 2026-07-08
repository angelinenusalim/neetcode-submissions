class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, Integer> map = new HashMap<>();
        List<List<String>> output = new ArrayList<>();
        int index = 0;
        Arrays.sort(strs);
        for (int i = 0; i < strs.length; i++) {
            char[] strs_array = strs[i].toCharArray();
            Arrays.sort(strs_array);
            String key = new String(strs_array);
            if (!map.containsKey(key)) {
                map.put(key, index);
                output.add(new ArrayList<>());
                index++;
            }
            int stringIndex = map.get(key);
            output.get(stringIndex).add(strs[i]);
        }
        return output;
    }
}