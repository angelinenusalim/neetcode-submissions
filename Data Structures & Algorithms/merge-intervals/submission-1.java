class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> output = new ArrayList<>();
        output.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            // interval starts after the previous one ends
            if (intervals[i][0] > output.get(output.size() - 1)[1]) {
                output.add(intervals[i]);
            } else {
                // interval overlaps
                // previous end in this interval's end
                output.get(output.size() - 1)[1] = Math.max(intervals[i][1],  output.get(output.size() - 1)[1]);
            }
        }
        return output.toArray(new int[output.size()][]);
    }
}
