class Solution {
    public boolean isPalindrome(String s) {
        
        String lower = s.toLowerCase();
        char[] arr = lower.toCharArray();
        String letter = "";
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isLetter(arr[i]) && !Character.isDigit(arr[i])) {
                continue;
            }
            letter += arr[i];
        }

        int left = 0;
        int right = letter.length() - 1;
        while (left < right) {
            if (letter.charAt(left) != letter.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
