class Solution {
    HashSet<Integer> classTaken = new HashSet<>();
    HashMap<Integer, List<Integer>> prereq = new HashMap<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            prereq.put(i, new ArrayList<>());
        }
        for (int[] classes : prerequisites) {
            prereq.get(classes[0]).add(classes[1]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(i)) {
                return false;
            }
        }
        return true;
        
    }
    public boolean hasCycle(int course) {
        // cycle
        if (classTaken.contains(course)) {
            return true;
        }
        // no prereq
        if (prereq.get(course).isEmpty()) {
            return false;
        }
        classTaken.add(course);
        for (int cls : prereq.get(course)) {
            if (hasCycle(cls)) {
                return true;
            }
        }
        classTaken.remove(course);
        prereq.put(course, new ArrayList<>());
        return false;
    }
}
