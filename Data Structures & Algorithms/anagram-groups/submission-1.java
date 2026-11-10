class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> output = new ArrayList<>();
        // key = word, val = group
        HashMap<String, List<String>> map = new HashMap<>();

        // sort strings then put into map 
        // group same strings together in a list (get the original string by using the value of the hashmap)

        for (int i = 0; i < strs.length; i++) {
            char[] strsArray = strs[i].toCharArray(); // a, c, t
            Arrays.sort(strsArray); // a c, t
            String key = new String(strsArray); // "act"
            if (!map.containsKey(key)) { // no group exists for this anagram 
                List<String> newList = new ArrayList<>();
                newList.add(strs[i]);
                map.put(key, newList); // ("act", "act")
                
            } else {
                map.get(key).add(strs[i]);
            }
        }
        for (List<String> value : map.values()) {
            output.add(value);
        }
        return output;
    }
}
