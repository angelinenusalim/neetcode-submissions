class Solution {
    int res = 0;
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        HashSet<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                res++;
                dfs(graph, i, visited);
            }
        }
        return res;
    }

    public void dfs(List<List<Integer>> graph, int node, HashSet<Integer> visited) {
        if (visited.contains(node)) return;
        visited.add(node);
        for (int neighbor : graph.get(node)) {
            dfs(graph, neighbor, visited);
        }
    }
}
