class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        char[] s_array = s.toCharArray();
        String letter = "";
        for (int i = 0; i < s_array.length; i++) {
            if (!Character.isLetter(s_array[i]) && !Character.isDigit(s_array[i])) {
                continue;
            }
            letter += s_array[i];
        }
        int start = 0;
        int end = letter.length() - 1;
        
        while (start < letter.length() && end > 0) {
            if (letter.charAt(start) != letter.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        
        return true;
    }
}
