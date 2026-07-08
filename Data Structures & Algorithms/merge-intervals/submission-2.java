class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> output = new ArrayList<>();
        output.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            // does not overlap = interval starts after the previous one ends
            if (intervals[i][0] > output.get(output.size() - 1)[1]) {
                output.add(intervals[i]);
            } else {
                output.get(output.size() - 1)[1] = Math.max(output.get(output.size() - 1)[1], intervals[i][1]);
                
            }
            // overlaps = interval starts before the previous one ends
            // keep min start and max end, start = previous start
            // end = math max previous and curr

        }
        return output.toArray(new int[output.size()][]);
    }
}
