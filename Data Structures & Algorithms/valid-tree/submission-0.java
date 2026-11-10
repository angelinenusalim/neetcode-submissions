class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        if (!dfs(graph, 0, -1, visited)) {
            return false;
        };

        return visited.size() == n;
        
    }

    public boolean dfs(List<List<Integer>> graph, int node, int parent, Set<Integer> visited) {
        // node already visited 
        if (visited.contains(node)) return false;
        visited.add(node);
        // explore the node's neighbors 
        for (int neighbor : graph.get(node)) {
            if (neighbor == parent) continue;
            // if the condition has cycle
            if (!dfs(graph, neighbor, node, visited)) return false;
        }
        return true;
    }

    
}



