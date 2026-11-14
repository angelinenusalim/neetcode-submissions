class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        if (s.length() == 0) return 1;
        dp[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            // If the last ONE digit is valid:
            // Add the number of ways to decode the previous i-1 characters.
            if (s.charAt(i-1) != '0') {
                dp[i] += dp[i-1];
            }
            // If the last TWO digits form a valid letter:
            // Add the number of ways to decode the previous i-2 characters.
            if (i >= 2) {
                int twoDigit = Integer.parseInt(s.substring(i - 2, i));
                if (twoDigit >= 10 && twoDigit <=26) {
                    dp[i] += dp[i-2];
                }
            }
        }
        return dp[s.length()];
    }
}
