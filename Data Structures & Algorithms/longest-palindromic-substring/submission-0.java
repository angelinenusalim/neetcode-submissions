class Solution {
    public String longestPalindrome(String s) {

        // odd length
        int len = 0;
        int index = 0;
            for (int i = 0; i < s.length(); i++) {
                int left = i, right = i;
                while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                    if (right - left + 1> len) {
                        len = right - left + 1;
                        index = left;
                    }
                    left--;
                    right++;
                }

                // even length
            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > len) {
                    len = right - left + 1;
                    index = left;
                }
                left--;
                right++;
            }
        }
        
        return s.substring(index, index+len);
        
    }
}
