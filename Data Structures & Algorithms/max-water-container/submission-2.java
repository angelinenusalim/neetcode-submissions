class Solution {
    public int maxArea(int[] heights) {
        int area = 0;
        int left = 0;
        int right = heights.length - 1;
        while (left < right) {
            if (heights[left] > heights[right]) {
                int newArea = heights[right]*(right-left);
                area = Math.max(newArea, area);
                right--;
            } else {
                int newArea = heights[left]*(right-left);
                area = Math.max(newArea, area);
                left++;
            }
        }

        return area;
    }
}
