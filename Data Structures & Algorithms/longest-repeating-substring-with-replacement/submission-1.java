class Solution {
    public int characterReplacement(String s, int k) {
        // window size - most frequent
        int left = 0;
        char[] s_array = s.toCharArray();
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            if (!map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), 1);
            } else {
                map.put(s.charAt(right), map.get(s.charAt(right)) + 1);
            }
            int maxFreq = 0;
            for (int value : map.values()) {
                maxFreq = Math.max(maxFreq, value);
            }
            // valid: k > window - max freq
            while ((right - left + 1) -  maxFreq > k) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
