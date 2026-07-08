class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for (int i = 0; i < strs.size(); i++) {
            encoded.append(strs.get(i).length()).append("#").append(strs.get(i));
        }
        return encoded.toString();
    }

    public List<String> decode(String str) {
        char[] strArray = str.toCharArray();
        List<String> output = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i,j));
            int start = j + 1;
            String word = str.substring(start, start + length);
            output.add(word);
            i = start + length;
        }
        return output;
    }
}
