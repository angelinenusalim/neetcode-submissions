class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        if (sCharArray.length != tCharArray.length) {
            return false;
        }
        Arrays.sort(sCharArray);
        Arrays.sort(tCharArray);
        for (int i = 0; i < sCharArray.length; i++) {
            if (sCharArray[i] != tCharArray[i]) {
                return false;
            }
        }
        return true;
    }
}
