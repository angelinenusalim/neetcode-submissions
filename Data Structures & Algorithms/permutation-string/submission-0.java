class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int left = 0;
        char[] char1 = s1.toCharArray();
        Arrays.sort(char1);
        char[] char2 = s2.toCharArray();

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for (int right = 0; right < s2.length(); right++) {
            char c = s2.charAt(right);
            map.put(c, map.getOrDefault(c, 0) - 1);

            if (right - left + 1 > s1.length()) {
                char removed = s2.charAt(left);
                map.put(removed, map.getOrDefault(removed, 0) + 1);
                left++;
            }

            if (right - left + 1 == s1.length()) {
                boolean allZero = true;
                for (int count : map.values()) {
                    if (count != 0) {
                        allZero = false;
                        break;
                    }
                }

                if (allZero) {
                    return true;
                }
            }

            
        }
        
        return false;
    }
}
