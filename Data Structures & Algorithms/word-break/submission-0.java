class Solution {
    HashSet<Integer> visited = new HashSet<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        return backtrack(s, wordDict, 0);
    }

    boolean backtrack(String s, List<String> wordDict, int start) {
        if (start == s.length()) return true;
        if (visited.contains(start)) return false;
        for (String word : wordDict) {
            if (s.startsWith(word, start)) {
                if (backtrack(s, wordDict, start + word.length())) {
                    return true;
                };
            }
        }
        visited.add(start);
        return false;
    }
}
