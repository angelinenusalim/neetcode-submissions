class Solution {
    public int maxArea(int[] heights) {
        int start = 0;
        int end = heights.length - 1;
        int output = 0;
        while (end > start && start < heights.length && end > 0) {
            output = Math.max(Math.min(heights[start], heights[end])*(end - start), output);
            if (heights[start] > heights[end]) {
                end--;
            } else {
                start++;
            }
        }
        return output;
    }
}
