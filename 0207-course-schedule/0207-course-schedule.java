class Solution {

    private boolean dfs(int node, HashMap<Integer, List<Integer>> adjList, boolean[] visited, boolean[] onPath) {
        if (onPath[node]) {
            return false;
        }
        if (visited[node]) {
            return true;
        }

        visited[node] = true;
        onPath[node] = true;

        // explore neighbors
        if (adjList.containsKey(node)) {
            for (int neighbor : adjList.get(node)) {
                if (!dfs(neighbor, adjList, visited, onPath))
                    return false;
            }
        }

        onPath[node] = false;
        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        HashMap<Integer, List<Integer>> courses = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {
            int courseWant = prerequisites[i][0];
            int courseRequire = prerequisites[i][1];

            if (!courses.containsKey(courseRequire)) {
                courses.put(courseRequire, new ArrayList<>());
            }

            courses.get(courseRequire).add(courseWant);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] onPath = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && !dfs(i, courses, visited, onPath))
                return false; // found cycle
        }

        return true;

    }
}