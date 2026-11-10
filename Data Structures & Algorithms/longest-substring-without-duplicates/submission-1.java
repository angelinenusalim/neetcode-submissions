class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int max = 0;
        int curr = 0;
        char[] arr = s.toCharArray();
        HashSet<Character> set = new HashSet<>();
        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                max = Math.max(right-left + 1, max);
                right++;
            } else {
                while (set.contains(s.charAt(right))) { // expand
                    set.remove(s.charAt(left));
                    left++;
                }
            }
        }
        return max;
    }
}
