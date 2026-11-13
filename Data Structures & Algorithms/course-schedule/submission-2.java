class Solution {

    // key = class, val = prereq
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    HashSet<Integer> taken = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] classes : prerequisites) {
            map.get(classes[0]).add(classes[1]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (dfs(i)) return false;
        }
        return true;

    }

    public boolean dfs(int course) {
        if (taken.contains(course)) return true;
        if (map.get(course).isEmpty()) return false;
        taken.add(course);
        for (int cls : map.get(course)) {
            if (dfs(cls)) return true;
        }
        taken.remove(course);
        map.get(course).clear();
        return false;
    }

    
}
