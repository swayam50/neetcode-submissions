class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            adjList.putIfAbsent(prerequisite[0], new ArrayList<>());
            adjList.get(prerequisite[0]).add(prerequisite[1]);
        }

        boolean[] path = new boolean[numCourses];
        int[] visited = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++)
            if (!dfs(i, path, visited, adjList))
                return false;
        return true;
    }

    private boolean dfs(int node, boolean[] path, int[] visited, Map<Integer, List<Integer>> adjList) {
        if (visited[node] != 0)
            return visited[node] == 1 ? true : false;

        if (path[node]) {
            visited[node] = -1;
            return false;
        }

        path[node] = true;

        boolean possible = true;
        if (adjList.containsKey(node))
            for (int adj : adjList.get(node))
                if (!dfs(adj, path, visited, adjList)) {
                    possible = false;
                    break;
                }

        path[node] = false;
        visited[node] = possible ? 1 : -1;

        return possible;
    }
}
