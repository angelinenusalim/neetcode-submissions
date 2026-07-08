class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> output = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            // intervals that end before the new interval starts
            if (newInterval == null || intervals[i][1] < newInterval[0]) {
                output.add(intervals[i]);
            } // intervals that starts after the new interval ends
            else if (intervals[i][0] > newInterval[1]){
                output.add(newInterval);
                output.add(intervals[i]);
                newInterval = null;
            } else {
                // intervals that overlaps
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                newInterval[1]= Math.max(intervals[i][1], newInterval[1]);

            }
        }
        if (newInterval != null) {
            output.add(newInterval);
        }
        output.sort((a, b) -> Integer.compare(a[0], b[0]));

        return output.toArray(new int[output.size()][]);
    }
}
